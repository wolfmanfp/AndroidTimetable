package hu.wolfmanfp.timetable.courselist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hu.wolfmanfp.timetable.R;

public class CourseListViewHolder extends RecyclerView.ViewHolder {
    public TextView dateText;
    public TextView nameText;
    public TextView roomText;

    public CourseListViewHolder(View itemView) {
        super(itemView);
        dateText = itemView.findViewById(R.id.item_txtDate);
        nameText = itemView.findViewById(R.id.item_txtName);
        roomText = itemView.findViewById(R.id.item_txtRoom);
    }
}
