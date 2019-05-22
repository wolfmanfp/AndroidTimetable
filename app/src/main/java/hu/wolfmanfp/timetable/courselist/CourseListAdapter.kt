package hu.wolfmanfp.timetable.courselist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.wolfmanfp.timetable.R
import hu.wolfmanfp.timetable.entities.Course
import org.threeten.bp.format.TextStyle
import java.util.*

class CourseListAdapter(private val context: Context, private val courseList: List<Course>) :
        RecyclerView.Adapter<CourseListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.course_view, parent, false)
        return CourseListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseListViewHolder, position: Int) {
        val (_, name, dayOfWeek, startTime, endTime, room) = this.courseList[position]
        val locale = Locale.getDefault()
        holder.dateText.text =
                "${dayOfWeek.getDisplayName(TextStyle.SHORT, locale)} $startTime-$endTime"
        holder.nameText.text = name
        holder.roomText.text = room
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

}
