package hu.wolfmanfp.timetable;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
		TextView dateText = (TextView) itemView.findViewById(R.id.item_txtDate);
		dateText.setText(currentCourse.getDayOfWeek()+", "+
				currentCourse.getStartHour()+":"+currentCourse.getStartMinute()+"-"+
				currentCourse.getEndHour()+":"+currentCourse.getEndMinute());
		TextView nameText = (TextView) itemView.findViewById(R.id.item_txtName);
		nameText.setText(currentCourse.getName());
		TextView roomText = (TextView) itemView.findViewById(R.id.item_txtRoom);
		roomText.setText(currentCourse.getRoom());
		
		return itemView;
	}
	
}
