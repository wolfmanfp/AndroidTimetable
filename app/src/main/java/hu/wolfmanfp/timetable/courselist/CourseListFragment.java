package hu.wolfmanfp.timetable.courselist;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import hu.wolfmanfp.timetable.entities.Course;
import hu.wolfmanfp.timetable.JSONHandler;
import hu.wolfmanfp.timetable.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CourseListFragment extends Fragment {

    RecyclerView list;
    List<Course> courseList;

    //private final String FILE = getActivity().getExternalFilesDir(null).getAbsolutePath() + "/data.json";
    private final String FILE = "data.json";

    public CourseListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.courseList = JSONHandler.getCourses(this.readFromFile());
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

    /**
     * This method reads the content of "data.json" into a String.
     * @return JSON string.
     */
    private String readFromFile() {
        StringBuilder ret = new StringBuilder();

        try {
            FileInputStream input = getActivity().openFileInput(FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while ((line = reader.readLine()) != null) {
                ret.append(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            initFile();
        } catch (IOException e) {

        }

        return ret.toString();
    }

    /**
     * If data.json doesn't exist, this method tries to create it.
     */
    private void initFile() {
        File file = new File(FILE);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        saveToFile();
    }

    /**
     * This method writes all courses into "data.json".
     */
    private void saveToFile() {
        try {
            FileOutputStream output = getActivity().openFileOutput(FILE, Context.MODE_PRIVATE);
            output.write(JSONHandler.writeJSON(this.courseList).getBytes());
            output.close();
        } catch (FileNotFoundException e) {
            initFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
