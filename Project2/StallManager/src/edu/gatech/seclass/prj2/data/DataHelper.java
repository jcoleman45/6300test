package edu.gatech.seclass.prj2.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "jvxcdf_stallmanager";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		 db.execSQL(Customer.CUSTOMER_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// no upgrade paths, this is the initial version
	}

	/**
	 * Persist the given customer.
	 * @param customer a new customer to persist
	 * @return the same customer with the ID field filled in
	 * @throws PersistanceException if storing to DB did not succeed
	 */
	public Customer addCustomer(SQLiteDatabase db, Customer customer) throws PersistanceException {
		long id = db.insert(Customer.TABLE_CUSTOMER, null, customer.contentValues());
		if(id == -1) {
			throw new PersistanceException("Could not store customer to DB: " + customer);
		}
		customer.setId(id);
		return customer;
	}
	
//	public List<Customer> customers(SQLiteDatabase db) throws PersistanceException {
//		String[] columns = new String[]{
//				Customer.COLUMN_ID,
//				Customer.COLUMN_FIRST_NAME,
//				Customer.COLUMN_LAST_NAME,
//				Customer.COLUMN_ZIPCODE,
//				Customer.COLUMN_EMAIL,
//				Customer.COLUMN_GOLD_STATUS,
//				Customer.COLUMN_CREATED,
//				Customer.COLUMN_DISCOUNT,
//				};
//		Cursor cursor = db.query(Customer.TABLE_CUSTOMER, columns, null, null, null, null, null);
//		List<Customer> list = new ArrayList<Customer>(cursor.getCount());
//		for(int i = 0; i < cursor.getCount(); i++) {
//			cursor.moveToPosition(i);
//			Customer c = new Customer();
//			c.setId(cursor.getInt(0));
//			c.setFirstName(cursor.getString(1));
//			c.setLastName(cursor.getString(2));
//			c.setZipCode(cursor.getString(3));
//			c.setEmail(cursor.getString(4));
//			c.setGoldStatus(cursor.getInt(5)>0);
//			c.setCreated(new Date(cursor.getLong(6)));
//			c.setDiscount(cursor.getInt(7));
//			list.add(c);
//		}
//		return list;
//	}
}
