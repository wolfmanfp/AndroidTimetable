package hu.wolfmanfp.timetable;

/**
 * 
 * @author FPeter
 *
 */
public class Course {
	private String name;
	private String dayOfWeek;
	private int startHour;
	private int startMinute;
	private int endHour;
	private int endMinute;
	private String room;

	public Course(String name, String dayOfWeek, int startHour, int startMinute, int endHour, int endMinute,
			String room) {
		this.name = name;
		this.dayOfWeek = dayOfWeek;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.room = room;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDayOfWeek() {
		return this.dayOfWeek;
	}
	
	public String getRoom() {
		return this.room;
	}

	public int getStartHour() {
		return this.startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStartMinute() {
		return this.startMinute;
	}

	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}

	public int getEndHour() {
		return this.endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getEndMinute() {
		return this.endMinute;
	}

	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
}
