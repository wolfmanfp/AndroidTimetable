package hu.wolfmanfp.timetable.courselist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.wolfmanfp.timetable.R

class CourseListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var dateText: TextView = itemView.findViewById(R.id.item_txtDate)
    var nameText: TextView = itemView.findViewById(R.id.item_txtName)
    var roomText: TextView = itemView.findViewById(R.id.item_txtRoom)

}
