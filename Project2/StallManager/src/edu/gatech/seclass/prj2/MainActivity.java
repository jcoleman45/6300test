package edu.gatech.seclass.prj2;

import com.example.stallmanager.R;
import com.example.stallmanager.R.id;
import com.example.stallmanager.R.layout;
import com.example.stallmanager.R.menu;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

	private static final String TAG_MAIN = "main";
	private static final String TAG_ABOUT = "about";
	
	Fragment mainFragment;
	Fragment aboutFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setDisplayHomeAsUpEnabled(false);

		if (savedInstanceState == null) {
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			if (mainFragment == null) {
				mainFragment = Fragment.instantiate(this, PlaceholderFragment.class.getName());
				transaction.add(R.id.main_container, mainFragment, TAG_MAIN);
			} else {
				transaction.attach(mainFragment);
			}
			transaction.commit();
			
				
		}
	}

	private void homeAsUp(boolean up) {
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(up);
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
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.action_about) {
			startActivity(new Intent(this, AboutActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
}
