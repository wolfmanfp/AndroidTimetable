package hu.wolfmanfp.timetable.database

import androidx.room.*
import hu.wolfmanfp.timetable.entities.Course

@Dao
interface CourseDao {
    @Query("SELECT * FROM course")
    fun getAll() : List<Course>

    @Insert
    fun add(course: Course)

    @Update
    fun update(course: Course)

    @Delete
    fun delete(course: Course)
}
