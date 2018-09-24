package hu.wolfmanfp.timetable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.List;

@SuppressLint("ViewHolder")
public class CourseListAdapter extends ArrayAdapter<Course> {
	private final Context context;
	private final List<Course> courseList;
	
	public CourseListAdapter(Context context, List<Course> courseList) {
		super(context, R.layout.course_view, courseList);
		this.context = context;
	    this.courseList = courseList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) this.context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.course_view, parent, false);
		
		Course currentCourse = this.courseList.get(position);
		TextView dateText = itemView.findViewById(R.id.item_txtDate);
		dateText.setText(String.format(context.getString(R.string.date_formatted),
                new DateFormatSymbols().getShortWeekdays()[currentCourse.getDayOfWeek()+1],
                currentCourse.getStartHour(),
                currentCourse.getStartMinute(),
                currentCourse.getEndHour(),
                currentCourse.getEndMinute()
            ));
		TextView nameText = itemView.findViewById(R.id.item_txtName);
		nameText.setText(currentCourse.getName());
		TextView roomText = itemView.findViewById(R.id.item_txtRoom);
		roomText.setText(currentCourse.getRoom());
		
		return itemView;
	}
	
}
