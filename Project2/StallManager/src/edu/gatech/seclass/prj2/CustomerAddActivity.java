package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.DataHelper;
import edu.gatech.seclass.prj2.data.PersistanceException;

public class CustomerAddActivity extends Activity implements OnClickListener {
	
	private static final String SN = CustomerAddActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_add);
		((Button) findViewById(R.id.btn_save_customer)).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = ((Button) v).getId();
		switch (id) {
		case R.id.btn_save_customer:
			Log.d(SN, "Save Customer button clicked");
			DataHelper data = new DataHelper(this);
			SQLiteDatabase db = data.getWritableDatabase();
			Customer customer = buildCustomer();
		
			try {
				customer = data.addCustomer(db, customer);
				Log.i(SN, "Saved new customer to DB: " + customer.toString());
			} catch (PersistanceException e) {
				Log.e(SN, "Could not store new customer: " + e.getMessage());
			}
			break;
		default:
			Log.e(SN, "Unknown button ID: " + id);
			break;
		}
		
	}
	
	private Customer buildCustomer() {
		Customer c = new Customer();
		c.setFirstName(((EditText) findViewById(R.id.txt_firstname)).getText().toString());
		c.setLastName(((EditText) findViewById(R.id.txt_lastname)).getText().toString());
		c.setZipCode(((EditText) findViewById(R.id.txt_zipcode)).getText().toString());
		c.setEmail(((EditText) findViewById(R.id.txt_email)).getText().toString());
		return c;
	}
	
	
}
