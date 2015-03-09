package edu.gatech.seclass.prj2;

import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.CustomerAdapter;
import edu.gatech.seclass.prj2.data.DataHelper;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * An activity representing a list of Customers. The activity
 * presents a list of items, which when touched, lead to a
 * {@link CustomerDetailActivity} representing item details.
 */
public class CustomerListActivity extends Activity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_list);
		
		DataHelper data = new DataHelper(this);
		SQLiteDatabase db = data.getReadableDatabase();
		Cursor cursor = db.query(Customer.TABLE_CUSTOMER, null, null, null, null, null, null);
		
		ListView lv = (ListView) findViewById(R.id.customer_list);
		lv.setOnItemClickListener(this);
		lv.setAdapter(new CustomerAdapter(this, cursor));

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent detailIntent = new Intent(this, CustomerDetailActivity.class);

		detailIntent.putExtra(CustomerDetailActivity.CUSTOMER_ROW_ID, id);
		startActivity(detailIntent);
	}
	
}
