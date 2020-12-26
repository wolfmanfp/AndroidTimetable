package hu.wolfmanfp.timetable.courselist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import hu.wolfmanfp.timetable.R
import hu.wolfmanfp.timetable.database.TimetableDatabase
import hu.wolfmanfp.timetable.entities.Course
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class CourseListFragment : Fragment() {

    private lateinit var list: RecyclerView
    private lateinit var courseList: List<Course>
    private lateinit var db: TimetableDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.courseList = ArrayList()
        this.db = Room.databaseBuilder(requireContext(), TimetableDatabase::class.java, "timetable")
                .allowMainThreadQueries()
                .build()
        courseList = db.courseDao().getAll()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        val adapter = CourseListAdapter(requireContext(), courseList)
        val layoutManager = LinearLayoutManager(activity) //important for displaying the view

        this.list = rootView.findViewById(R.id.courseListView)
        list.adapter = adapter
        list.layoutManager = layoutManager

        return rootView
    }

}
