package hu.wolfmanfp.timetable.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalTime

/**
 * This class contains all information about a university course.
 * @author wolfmanfp
 * @param name The name of the course.
 * @param dayOfWeek Monday-Friday
 * @param startTime
 * @param endTime
 * @param room
 */
@Entity(tableName = "course")
data class Course (
        @PrimaryKey(autoGenerate = true)
        var id: Long?,
        var name: String,
        var dayOfWeek: DayOfWeek,
        var startTime: LocalTime,
        var endTime: LocalTime,
        var room: String
)
