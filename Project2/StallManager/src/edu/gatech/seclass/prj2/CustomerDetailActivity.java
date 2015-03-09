package edu.gatech.seclass.prj2;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.DataHelper;

/**
 * An activity representing a single Customer detail screen. 
 */
public class CustomerDetailActivity extends Activity implements OnClickListener, TextWatcher, OnCheckedChangeListener {
	
	private static final String SN = CustomerDetailActivity.class.getSimpleName();

	public static final String CUSTOMER_ROW_ID = "edu.gatech.seclass.prj2.customer_row_id";
	
	private Customer loadedCustomer = null;
	private Customer currentCustomer = null;
	
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
			loadedCustomer = data.findCustomerById(rowId);
		}

		txtFirstName = (EditText) findViewById(R.id.customer_detail_txt_firstname);
		txtLastName = (EditText) findViewById(R.id.customer_detail_txt_lastname);
		txtZipCode = (EditText) findViewById(R.id.customer_detail_txt_zipcode);
		txtEmailAddress = (EditText) findViewById(R.id.customer_detail_txt_email);
		txtDiscount = (EditText) findViewById(R.id.customer_detail_txt_discount);
		chkGoldStatus = (CheckBox) findViewById(R.id.customer_detail_gold);
		lblCreated = (TextView) findViewById(R.id.customer_detail_lbl_created_display);
		btnEdit = (Button) findViewById(R.id.customer_detail_btn_edit_customer);
		btnSave = (Button) findViewById(R.id.customer_detail_btn_save_customer);

		if (loadedCustomer != null) {
			Date created = loadedCustomer.getCreated();
			java.text.DateFormat df = DateFormat.getLongDateFormat(this);
			java.text.DateFormat tf = DateFormat.getTimeFormat(this);
			lblCreated.setText(df.format(created) + " " + tf.format(created));
			fillForm(loadedCustomer);
		}
		
		// add on click listeners
		btnEdit.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		
		// as the last step, add change listener (don't do this before filling in data)
		txtFirstName.addTextChangedListener(this);
		txtLastName.addTextChangedListener(this);
		txtZipCode.addTextChangedListener(this);
		txtEmailAddress.addTextChangedListener(this);
		txtDiscount.addTextChangedListener(this);
		chkGoldStatus.setOnCheckedChangeListener(this);
	}

	private void fillForm(Customer c) {
		txtFirstName.setText(c.getFirstName());
		txtLastName.setText(c.getLastName());
		txtZipCode.setText(c.getZipCode());
		txtEmailAddress.setText(c.getEmailAddress());
		txtDiscount.setText(String.valueOf(c.getDiscount()));
		chkGoldStatus.setChecked(c.hasGoldStatus());
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

					btnEdit.setEnabled(false);
					editing = true;
				} else {
					Log.e(SN, "Pressed Edit button while already in Edit mode");
				}
				break;
			case R.id.customer_detail_btn_save_customer:
				DataHelper data = new DataHelper(this);
				currentCustomer.setId(loadedCustomer.getId());
				data.updateCustomer(currentCustomer);
				Log.d(SN, "Updated customer: " + currentCustomer.toString());
				finish();
				break;
			default:
				Log.e(SN, "Unknown button ID: " + v.getId());
				break;
			}
		} else {
			Log.e(SN, "Encountered click event not originating from a button, ID: " + v.getId());
		}
	}

	private Customer build() {
		Customer c = new Customer(); 
		c.setFirstName(txtFirstName.getText().toString());
		c.setLastName(txtLastName.getText().toString());
		c.setZipCode(txtZipCode.getText().toString());
		c.setEmailAddress(txtEmailAddress.getText().toString());
		Double discount;
		try {
			discount = Double.valueOf(txtDiscount.getText().toString());
		} catch(NumberFormatException e) {
			discount = 0.0;
		}
		c.setDiscount(discount);
		c.setGoldStatus(chkGoldStatus.isChecked());
		return c;
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// no-op
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// no-op
	}

	@Override
	public void afterTextChanged(Editable s) {
		checkDirty();
	}

	private void checkDirty() {
		currentCustomer = build();
		if(!loadedCustomer.equals(currentCustomer)) {
			btnSave.setEnabled(true);	
		} else {
			btnSave.setEnabled(false);
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		checkDirty();
	}
	
}
