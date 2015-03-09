package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.CustomerAdapter;
import edu.gatech.seclass.prj2.data.DataHelper;

/**
 * A list fragment representing a list of Customers. 
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class CustomerListFragment extends ListFragment {

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
		 * Callback for when an item has been selected.
		 */
		public void onItemSelected(long rowId);
	}

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static Callbacks sDummyCallbacks = new Callbacks() {
		
		@Override
		public void onItemSelected(long id) {
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Context context = getActivity();
		DataHelper data = new DataHelper(context);
		SQLiteDatabase db = data.getReadableDatabase();
		Cursor cursor = db.query(Customer.TABLE_CUSTOMER, null, null, null, null, null, null);
		
		setListAdapter(new CustomerAdapter(context, cursor));
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
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);
		long rowId = getListView().getItemIdAtPosition(position);
		mCallbacks.onItemSelected(rowId);
	}


}
