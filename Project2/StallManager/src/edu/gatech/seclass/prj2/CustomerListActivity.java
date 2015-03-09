package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * An activity representing a list of Customers.The activity
 * presents a list of items, which when touched, lead to a
 * {@link CustomerDetailActivity} representing item details.
 * <p>
 * The list of items is a {@link CustomerListFragment} and the
 * item details (if present) is a {@link CustomerDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link CustomerListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class CustomerListActivity extends Activity implements
		CustomerListFragment.Callbacks {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_list);
		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link CustomerListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(long id) {
		Intent detailIntent = new Intent(this, CustomerDetailActivity.class);

		detailIntent.putExtra(CustomerDetailFragment.ARG_ROW_ID, id);
		startActivity(detailIntent);
	}
}
