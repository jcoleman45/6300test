package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.prj2.R;

import edu.gatech.seclass.prj2.data.Customer;

/**
 * Provides a form to enter customer details and a button to persist the information.
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface. 
 */
public class CustomerAddFragment extends Fragment implements OnClickListener {

	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	private CustomerAddFragment.Callbacks mCallbacks = sDummyCallbacks;

	/**
	 * A callback interface that all activities containing this fragment must
	 * implement. This mechanism allows activities to be notified of item
	 * selections.
	 */
	public interface Callbacks {
		/**
		 * Callback for when a button has been clicked.
		 */
		public void buttonClicked(int id);
	}

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static CustomerAddFragment.Callbacks sDummyCallbacks = new Callbacks() {
		
		@Override
		public void buttonClicked(int id) {
		}
	};
	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_customer_add,
				container, false);
		((Button) rootView.findViewById(R.id.btn_save_customer)).setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		mCallbacks.buttonClicked(v.getId());
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

	public Customer buildCustomer() {
		Customer c = new Customer();
		c.setFirstName(((EditText) rootView.findViewById(R.id.txt_firstname)).getText().toString());
		c.setLastName(((EditText) rootView.findViewById(R.id.txt_lastname)).getText().toString());
		c.setZipCode(((EditText) rootView.findViewById(R.id.txt_zipcode)).getText().toString());
		c.setEmail(((EditText) rootView.findViewById(R.id.txt_email)).getText().toString());
		return c;
	}

}