package hu.wolfmanfp.timetable.database

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalTime

object DateTimeTypeConverter {
    @TypeConverter
    @JvmStatic
    fun toLocalTime(value: String): LocalTime {
        return LocalTime.parse(value)
    }

    @TypeConverter
    @JvmStatic
    fun fromLocalTime(value: LocalTime): String {
        return value.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toDayOfWeek(value: Int): DayOfWeek {
        return DayOfWeek.of(value)
    }

    @TypeConverter
    @JvmStatic
    fun fromDayOfWeek(value: DayOfWeek): Int {
        return value.value
    }
}