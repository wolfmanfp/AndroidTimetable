package hu.wolfmanfp.timetable;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONHandler {
	
	public JSONHandler() {
	}
	
	/**
	 * This method converts the list of courses into JSON.
	 * @param courseList An ArrayList containing Course objects.
	 * @return A string containing JSON information.
	 */
	public static String writeJSON(List<Course> courseList) {
		JSONObject jsonObj = new JSONObject();
        try {
			jsonObj.put("courseList", courseList);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj.toString();
	}
	
	/**
	 * This method creates an ArrayList from JSON.
	 * @param json A string containing JSON information.
	 * @return An ArrayList of Course objects.
	 */
	public static List<Course> getCourses(String json) {
		List<Course> courseList = new ArrayList<Course>();
		
		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject.getJSONArray("courseList");
			if (jsonArray != null) {
				for (int i = 0; i < jsonArray.length(); i++) {
					courseList.add(getCourse(jsonArray.getJSONObject(i)));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return courseList;
	}
	
	/**
	 * This method converts a JSONObject into a Course object.
	 * @param jsonObject A JSONObject containing course data.
	 * @return A Course object.
	 */
	private static Course getCourse(JSONObject jsonObject) {
		Course course = null;
        try {
        	String name = jsonObject.getString("name");
			int dayOfWeek = jsonObject.getInt("dayOfWeek");
			int startHour = jsonObject.getInt("startHour");
	        int startMinute = jsonObject.getInt("startMinute");
	        int endHour = jsonObject.getInt("endHour");
	        int endMinute = jsonObject.getInt("endMinute");
	        String room = jsonObject.getString("room");
	        course = new Course(name, dayOfWeek, startHour, startMinute, endHour, endMinute, room);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return course;
        
	}
}
