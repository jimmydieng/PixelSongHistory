package me.jimmydieng.pixelsonghistory.data.models

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset


class LocalDateTimeTypeConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        if (value == null) {
            return null
        }

        return Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault()).toLocalDateTime()
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): Long? = date?.toInstant(ZoneOffset.UTC)?.toEpochMilli()
}
