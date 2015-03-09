package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.DataHelper;

/**
 * An activity representing a single Customer detail screen. 
 */
public class CustomerDetailActivity extends Activity {
	
	private static final String SN = CustomerDetailActivity.class.getSimpleName();

	public static final String CUSTOMER_ROW_ID = "edu.gatech.seclass.prj2.customer_row_id";
	
	Customer customer = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_detail);
		
		long rowId = getIntent().getLongExtra(CUSTOMER_ROW_ID, -1);
		if (rowId != -1) {
			DataHelper data = new DataHelper(this);
			SQLiteDatabase db = data.getReadableDatabase();
			Cursor cursor = db.query(Customer.TABLE_CUSTOMER, null, "_id=" + rowId, null, null, null, null);
			if (cursor.getCount() == 1 && cursor.moveToFirst()) {
				customer = Customer.fromCursor(cursor);
			} else {
				Log.e(SN, "Could not load customer with DB row ID: " + rowId);
			}
		}

		if (customer != null) {
			((TextView) findViewById(R.id.customer_detail)).setText(customer.toString());
		}
	}

	
}
