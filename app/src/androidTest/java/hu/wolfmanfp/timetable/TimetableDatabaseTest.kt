package hu.wolfmanfp.timetable

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import hu.wolfmanfp.timetable.database.CourseDao
import hu.wolfmanfp.timetable.database.TimetableDatabase
import hu.wolfmanfp.timetable.entities.Course
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalTime

class TimetableDatabaseTest {
    private lateinit var courseDao: CourseDao
    private lateinit var db: TimetableDatabase
    private lateinit var course: Course

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TimetableDatabase::class.java).build()
        courseDao = db.courseDao()
        course = Course(1, "Teszt", DayOfWeek.MONDAY, LocalTime.NOON, LocalTime.MIDNIGHT, "A101")
    }

    @Test
    fun testGetAll() {
        val courseList: List<Course> = courseDao.getAll()
        assertTrue(courseList.isEmpty())
    }

    @Test
    fun testAdd() {
        courseDao.add(course)
        val courseList: List<Course> = courseDao.getAll()
        assertTrue(courseList.contains(course))
    }

    @Test
    fun testUpdate() {
        courseDao.add(course)
        course.name = "Valami más"
        courseDao.update(course)
        val courseList: List<Course> = courseDao.getAll()
        assertTrue(courseList.get(0).name.equals("Valami más"))
    }

    @Test
    fun testDelete() {
        courseDao.add(course)
        courseDao.delete(course)
        val courseList: List<Course> = courseDao.getAll()
        assertFalse(courseList.contains(course))
    }

    @After
    fun tearDown() {
        db.close()
    }

}