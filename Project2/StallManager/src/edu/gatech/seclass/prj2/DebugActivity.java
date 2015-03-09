package edu.gatech.seclass.prj2;

import java.util.Date;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import edu.gatech.seclass.prj2.data.Customer;
import edu.gatech.seclass.prj2.data.DataHelper;

public class DebugActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_debug);
		TextView textView = (TextView) findViewById(R.id.lbl_debug);
		DataHelper data = new DataHelper(this);
		SQLiteDatabase db = data.getReadableDatabase();
		String[] columns = new String[]{Customer.COLUMN_ID,
										Customer.COLUMN_FIRST_NAME,
										Customer.COLUMN_LAST_NAME,
										Customer.COLUMN_ZIPCODE,
										Customer.COLUMN_EMAIL,
										Customer.COLUMN_DISCOUNT,
										Customer.COLUMN_GOLD_STATUS,
										Customer.COLUMN_CREATED};
		Cursor cursor = db.query(Customer.TABLE_CUSTOMER, columns, null, null, null, null, null);
		String rows = "Id, firstName, lastName, zipCode, email, discount, goldStatus, created\n\n";
		for(int i = 0; i < cursor.getCount(); i++) {
			cursor.moveToPosition(i);
			rows += cursor.getInt(0) + ", " +
					cursor.getString(1) + ", " +
					cursor.getString(2)  + ", " + 
					cursor.getString(3)  + ", " + 
					cursor.getString(4) + ", " + 
					cursor.getInt(5) + ", "  + 
					(cursor.getInt(6)>0) + ", " + 
					new Date(cursor.getLong(7)) + "\n";
		}
		textView.setText(rows);
	}
}
