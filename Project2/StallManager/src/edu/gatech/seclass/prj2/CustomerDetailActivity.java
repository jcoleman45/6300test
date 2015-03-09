package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.os.Bundle;

/**
 * An activity representing a single Customer detail screen. 
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link CustomerDetailFragment}.
 */
public class CustomerDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_detail);

		if (savedInstanceState == null) {
			// Create the detail fragment and add it to the activity
			// using a fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putLong(CustomerDetailFragment.ARG_ROW_ID, getIntent()
					.getLongExtra(CustomerDetailFragment.ARG_ROW_ID, -1));
			CustomerDetailFragment fragment = new CustomerDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction()
					.add(R.id.customer_detail_container, fragment).commit();
		}
	}

}
