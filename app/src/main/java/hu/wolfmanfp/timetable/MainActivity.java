package hu.wolfmanfp.timetable;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import hu.wolfmanfp.timetable.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		switch (id) {
		case R.id.action_about:
			startActivity(new Intent(MainActivity.this, AboutActivity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		ListView list;
		List<Course> courseList;
		String readString;

		//private final String FILE = getActivity().getExternalFilesDir(null).getAbsolutePath() + "/data.json";
		private final String FILE = "data.json";

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);

			this.list = (ListView) rootView.findViewById(R.id.courseListView);

			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

			this.courseList = JSONHandler.getCourses(this.readFromFile());

			courseList.add(new Course("Szoftvertechnológia", 1, 7, 45, 9, 30, "A008"));
			courseList.add(new Course("Kiszolgálók üzemeltetése", 1, 11, 15, 12, 45, "A201"));

			ArrayAdapter<Course> adapter = new CourseListAdapter(getActivity(), courseList);
			list.setAdapter(adapter);
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
}
