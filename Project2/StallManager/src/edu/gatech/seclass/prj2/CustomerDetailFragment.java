package edu.gatech.seclass.prj2;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.gatech.seclass.prj2.R;
import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.CustomerAdapter;
import edu.gatech.seclass.prj2.data.DataHelper;
import edu.gatech.seclass.prj2.data.PersistanceException;

/**
 * A fragment representing a single Customer detail screen. This fragment is
 * either contained in a {@link CustomerListActivity} in two-pane mode (on
 * tablets) or a {@link CustomerDetailActivity} on handsets.
 */
public class CustomerDetailFragment extends Fragment {
	
	private static final String SN = CustomerDetailFragment.class.getSimpleName();
	
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ROW_ID = "row_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Customer customer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ROW_ID)) {
			long id = getArguments().getLong(ARG_ROW_ID);
			Context context = getActivity();
			DataHelper data = new DataHelper(context);
			SQLiteDatabase db = data.getReadableDatabase();
			Cursor cursor = db.query(Customer.TABLE_CUSTOMER, null, "_id=" + id, null, null, null, null);
			if (cursor.getCount() == 1 && cursor.moveToFirst()) {
				customer = Customer.fromCursor(cursor);
			} else {
				Log.e(SN, "Could not load customer with DB row ID: " + id);
			}
 
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_customer_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (customer != null) {
			((TextView) rootView.findViewById(R.id.customer_detail))
					.setText(customer.toString());
		}

		return rootView;
	}
}
