package edu.gatech.seclass.prj2;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.DataHelper;

/**
 * An activity representing a single Customer detail screen. 
 */
public class CustomerDetailActivity extends Activity implements OnClickListener {
	
	private static final String SN = CustomerDetailActivity.class.getSimpleName();

	public static final String CUSTOMER_ROW_ID = "edu.gatech.seclass.prj2.customer_row_id";
	
	private Customer loadedCustomer = null;
	private boolean editing = false;
	
	private EditText txtFirstName;
	private EditText txtLastName;
	private EditText txtZipCode;
	private EditText txtDiscount;
	private CheckBox chkGoldStatus;
	private EditText txtEmailAddress;
	private TextView lblCreated;
	private Button btnEdit;
	private Button btnSave;
	
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
				loadedCustomer = Customer.fromCursor(cursor);
			} else {
				Log.e(SN, "Could not load customer with DB row ID: " + rowId);
			}
			db.close();
		}

		btnEdit = (Button) findViewById(R.id.customer_detail_btn_edit_customer);
		btnSave = (Button) findViewById(R.id.customer_detail_btn_save_customer);
		btnEdit.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		
		if (loadedCustomer != null) {
			txtFirstName = (EditText) findViewById(R.id.customer_detail_txt_firstname);
			txtLastName = (EditText) findViewById(R.id.customer_detail_txt_lastname);
			txtZipCode = (EditText) findViewById(R.id.customer_detail_txt_zipcode);
			txtEmailAddress = (EditText) findViewById(R.id.customer_detail_txt_email);
			txtDiscount = (EditText) findViewById(R.id.customer_detail_txt_discount);
			chkGoldStatus = (CheckBox) findViewById(R.id.customer_detail_gold);
			lblCreated = (TextView) findViewById(R.id.customer_detail_lbl_created_display);
			
			Date created = loadedCustomer.getCreated();
			java.text.DateFormat df = DateFormat.getLongDateFormat(this);
			java.text.DateFormat tf = DateFormat.getTimeFormat(this);
			lblCreated.setText(df.format(created) + " " + tf.format(created));
			
			txtFirstName.setText(loadedCustomer.getFirstName());
			txtLastName.setText(loadedCustomer.getLastName());
			txtZipCode.setText(loadedCustomer.getZipCode());
			txtEmailAddress.setText(loadedCustomer.getEmailAddress());
			txtDiscount.setText(String.valueOf(loadedCustomer.getDiscount()));
			chkGoldStatus.setChecked(loadedCustomer.hasGoldStatus());
			
		}
	}

	@Override
	public void onClick(View v) {
		if(v instanceof Button) {
			switch (v.getId()) {
			case R.id.customer_detail_btn_edit_customer:
				Log.d(SN, "Edit button clicked");
				if(editing == false) {
					txtFirstName.setEnabled(true);
					txtLastName.setEnabled(true);
					txtZipCode.setEnabled(true);
					txtEmailAddress.setEnabled(true);
					txtDiscount.setEnabled(true);
					chkGoldStatus.setEnabled(true);
					btnSave.setEnabled(true);
					btnEdit.setEnabled(false);
					editing = true;
				} else {
					Log.e(SN, "Pressed Edit button while already in Edit mode");
				}
				break;
			case R.id.customer_detail_btn_save_customer:
				Log.d(SN, "Save Customer button clicked");
				break;
			default:
				Log.e(SN, "Unknown button ID: " + v.getId());
				break;
			}
		} else {
			Log.e(SN, "Encountered click event not originating from a button, ID: " + v.getId());
		}
	}

	
}
