package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient.CustomViewCallback;

import edu.gatech.seclass.prj2.R;

import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.DataHelper;
import edu.gatech.seclass.prj2.data.PersistanceException;

public class CustomerAddActivity extends Activity implements CustomerAddFragment.Callbacks {
	
	private static final String SN = CustomerAddActivity.class.getSimpleName();

	private static final String TAG_ADD = "addfragment";
	
	CustomerAddFragment addFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_add);
		
		if (savedInstanceState == null) {
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			if (addFragment == null) {
				addFragment = (CustomerAddFragment) Fragment.instantiate(this, CustomerAddFragment.class.getName());
				transaction.add(R.id.container, addFragment, TAG_ADD);
			} else {
				transaction.attach(addFragment);
			}
			transaction.commit();
		}

	}

	@Override
	public void buttonClicked(int id) {
		switch (id) {
		case R.id.btn_save_customer:
			Log.d(SN, "Save Customer button clicked");
			DataHelper data = new DataHelper(this);
			SQLiteDatabase db = data.getWritableDatabase();
			Customer customer = addFragment.buildCustomer();
		
			try {
				data.addCustomer(db, customer);
			} catch (PersistanceException e) {
				Log.e(SN, "Could not store new customer: " + e.getMessage());
			}
			break;
		default:
			Log.e(SN, "Unknown button ID: " + id);
			break;
		}
		
	}
}
