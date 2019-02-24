package hu.wolfmanfp.timetable.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hu.wolfmanfp.timetable.entities.Course

@Database(entities = [Course::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeTypeConverter::class)
abstract class TimetableDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}