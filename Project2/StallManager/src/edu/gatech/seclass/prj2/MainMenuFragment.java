package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.stallmanager.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainMenuFragment extends Fragment implements OnClickListener {

	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	private Callbacks mCallbacks = sDummyCallbacks;

	/**
	 * A callback interface that all activities containing this fragment must
	 * implement. This mechanism allows activities to be notified of item
	 * selections.
	 */
	public interface Callbacks {
		/**
		 * Callback for when a button has been clicked.
		 */
		public void mainMenuButtonClicked(int id);
	}

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static Callbacks sDummyCallbacks = new Callbacks() {
		
		@Override
		public void mainMenuButtonClicked(int id) {
		}
	};
	
	public MainMenuFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		((Button) rootView.findViewById(R.id.btn_add_customer)).setOnClickListener(this);
		((Button) rootView.findViewById(R.id.btn_manage_customers)).setOnClickListener(this);
		
		return rootView;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
		}
		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = sDummyCallbacks;
	}

	@Override
	public void onClick(View v) {
		int id = ((Button) v).getId();
		mCallbacks.mainMenuButtonClicked(id);
	}
	
}