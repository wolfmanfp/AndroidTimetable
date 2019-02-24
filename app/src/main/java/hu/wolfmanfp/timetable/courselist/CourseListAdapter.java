package hu.wolfmanfp.timetable.courselist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.threeten.bp.format.TextStyle;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import hu.wolfmanfp.timetable.R;
import hu.wolfmanfp.timetable.entities.Course;

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
		Locale locale = Locale.getDefault();
		holder.dateText.setText(String.format(context.getString(R.string.date_formatted),
				currentCourse.getDayOfWeek().getDisplayName(TextStyle.SHORT, locale),
				currentCourse.getStartTime(),
				currentCourse.getEndTime()
		));
		holder.nameText.setText(currentCourse.getName());
		holder.roomText.setText(currentCourse.getRoom());
	}

	@Override
	public int getItemCount() {
		return courseList.size();
	}
}
