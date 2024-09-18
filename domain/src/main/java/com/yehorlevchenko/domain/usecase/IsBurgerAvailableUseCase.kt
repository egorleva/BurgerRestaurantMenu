package com.yehorlevchenko.domain.usecase

import com.yehorlevchenko.domain.constants.Constants.SERVER_DATE_PATTERN
import com.yehorlevchenko.domain.constants.DefaultValues.DEFAULT_TIME_ZONE
import com.yehorlevchenko.domain.entity.Burger
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class IsBurgerAvailableUseCase {

    operator fun invoke(burger: Burger): Boolean {
        val currentDate = Calendar.getInstance().time
        val availableSinceDate = getAvailableSinceDate(burger)
        val availableUntilDate = getAvailableUntilDate(burger)

        val isCurrentDateAfterSinceDate = availableSinceDate.before(currentDate)
        val isCurrentDateBeforeUntilDate = availableUntilDate.after(currentDate)

        val isBurgerInStock = burger.isInStock == true

        return isCurrentDateAfterSinceDate && isCurrentDateBeforeUntilDate && isBurgerInStock
    }

    private fun getAvailableSinceDate(burger: Burger): Date {
        return burger.availableSince?.let { Date(it) } ?: Date(Long.MIN_VALUE)
    }

    private fun getAvailableUntilDate(burger: Burger): Date {
        return burger.availableUntil?.let {
            try {
                val dateFormat = SimpleDateFormat(SERVER_DATE_PATTERN, Locale.getDefault())
                dateFormat.timeZone = TimeZone.getTimeZone(DEFAULT_TIME_ZONE)
                dateFormat.parse(it)
            } catch (e: ParseException) {
                Date(Long.MIN_VALUE)
            }
        } ?: Date(Long.MAX_VALUE)
    }
}