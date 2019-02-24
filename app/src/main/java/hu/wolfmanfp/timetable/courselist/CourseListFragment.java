package hu.wolfmanfp.timetable.courselist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import hu.wolfmanfp.timetable.R;
import hu.wolfmanfp.timetable.database.TimetableDatabase;
import hu.wolfmanfp.timetable.entities.Course;

/**
 * A placeholder fragment containing a simple view.
 */
public class CourseListFragment extends Fragment {

    RecyclerView list;
    List<Course> courseList;
    TimetableDatabase db;

    public CourseListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.courseList = new ArrayList<>();
        this.db = Room
                .databaseBuilder(getActivity(), TimetableDatabase.class, "timetable")
                .allowMainThreadQueries()
                .build();
        courseList = db.courseDao().getAll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView.Adapter adapter = new CourseListAdapter(getActivity(), courseList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()); //important for displaying the view

        this.list = rootView.findViewById(R.id.courseListView);
        list.setAdapter(adapter);
        list.setLayoutManager(layoutManager);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
