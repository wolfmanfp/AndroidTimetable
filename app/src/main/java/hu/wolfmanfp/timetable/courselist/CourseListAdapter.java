package hu.wolfmanfp.timetable.courselist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormatSymbols;
import java.util.List;

import hu.wolfmanfp.timetable.entities.Course;
import hu.wolfmanfp.timetable.R;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListViewHolder> {
	private final Context context;
	private final List<Course> courseList;
	
	public CourseListAdapter(Context context, List<Course> courseList) {
		this.context = context;
	    this.courseList = courseList;
	}

	@NonNull
	@Override
	public CourseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.course_view, parent, false);
		CourseListViewHolder holder = new CourseListViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull CourseListViewHolder holder, int position) {
		Course currentCourse = this.courseList.get(position);
		holder.dateText.setText(String.format(context.getString(R.string.date_formatted),
				new DateFormatSymbols().getShortWeekdays()[currentCourse.getDayOfWeek()+1],
				currentCourse.getStartHour(),
				currentCourse.getStartMinute(),
				currentCourse.getEndHour(),
				currentCourse.getEndMinute()
		));
		holder.nameText.setText(currentCourse.getName());
		holder.roomText.setText(currentCourse.getRoom());
	}

	@Override
	public int getItemCount() {
		return courseList.size();
	}
}
