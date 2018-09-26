package hu.wolfmanfp.timetable.tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hu.wolfmanfp.timetable.entities.Course;
import hu.wolfmanfp.timetable.JSONHandler;

public class JSONHandlerTest {
	private static final String TEST_JSON = "{\"courseList\":[{\"endHour\":9,\"dayOfWeek\":1,\"startHour\":7,\"name\":\"Szoftvertechnológia\",\"startMinute\":45,\"room\":\"A008\",\"endMinute\":30},{\"endHour\":12,\"dayOfWeek\":1,\"startHour\":11,\"name\":\"Kiszolgálók üzemeltetése\",\"startMinute\":15,\"room\":\"A201\",\"endMinute\":45}]}";
	
	@Test
	public void testWriteJSON() {
		Course course1 = new Course("Szoftvertechnológia", 1, 7, 45, 9, 30, "A008");
		Course course2 = new Course("Kiszolgálók üzemeltetése", 1, 11, 15, 12, 45, "A201");
		List<Course> courseList = new ArrayList<Course>();
		courseList.add(course1);
		courseList.add(course2);
		assertEquals(TEST_JSON, JSONHandler.writeJSON(courseList));
	}
	
	@Test
	public void testGetCourses() {
		List<Course> courseList = JSONHandler.getCourses(TEST_JSON);
		Course course1 = courseList.get(0);
		Course course2 = courseList.get(1);
		assertEquals(7, course1.getStartHour());
		assertEquals(15, course1.getStartMinute());
	}

}
