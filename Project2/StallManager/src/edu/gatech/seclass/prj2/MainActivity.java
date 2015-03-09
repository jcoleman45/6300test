package edu.gatech.seclass.prj2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.stallmanager.R;

public class MainActivity extends Activity implements MainMenuFragment.Callbacks {

	private static final String SN = MainActivity.class.getSimpleName();
	
	private static final String TAG_MAIN = "main";
	
	Fragment mainFragment;
	Fragment aboutFragment;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setDisplayHomeAsUpEnabled(false);


		if (savedInstanceState == null) {
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			if (mainFragment == null) {
				mainFragment = Fragment.instantiate(this, MainMenuFragment.class.getName());
				transaction.add(R.id.main_container, mainFragment, TAG_MAIN);
			} else {
				transaction.attach(mainFragment);
			}
			transaction.commit();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as we specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.action_about) {
			startActivity(new Intent(this, AboutActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void mainMenuButtonClicked(int id) {
		switch (id) {
		case R.id.btn_add_customer:
			Log.d(SN, "Add Customer button clicked");
			break;
		case R.id.btn_manage_customers:
			Log.d(SN, "Manage Customers button clicked");
			startActivity(new Intent(this, CustomerListActivity.class));
			break;
		default:
			Log.e(SN, "Unknown button ID: " + id);
			break;
		}
		
	}
	
}
