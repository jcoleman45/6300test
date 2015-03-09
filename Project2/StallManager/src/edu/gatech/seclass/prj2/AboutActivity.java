package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.seclass.prj2.R;

public class AboutActivity extends Activity {
	
	private static final String TAG_ABOUT = "about";
	
	Fragment aboutFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		if (savedInstanceState == null) {
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			if (aboutFragment == null) {
				aboutFragment = Fragment.instantiate(this, AboutFragment.class.getName());
				transaction.add(R.id.about_container, aboutFragment, TAG_ABOUT);
			} else {
				transaction.attach(aboutFragment);
			}
			transaction.commit();
		}
	}

	/**
	 * The fragment containing information about the application.
	 */
	public static class AboutFragment extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_about, container,
					false);
			return rootView;
		}
	}
}
