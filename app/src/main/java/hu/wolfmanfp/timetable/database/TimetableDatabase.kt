package hu.wolfmanfp.timetable.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import hu.wolfmanfp.timetable.entities.Course

@Database(entities = [Course::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeTypeConverter::class)
abstract class TimetableDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}