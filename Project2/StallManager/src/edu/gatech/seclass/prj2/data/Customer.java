package edu.gatech.seclass.prj2.data;

import java.util.Date;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Represents a single customer.
 */
public class Customer {
	
	public static final String TABLE_CUSTOMER = "customer";
	
	public static final String COLUMN_ID = "_id";
	
	public static final String COLUMN_FIRST_NAME = "firstname";
	public static final String COLUMN_LAST_NAME = "lastname";
	public static final String COLUMN_ZIPCODE = "zipcode";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_GOLD_STATUS = "goldstatus";
	public static final String COLUMN_DISCOUNT = "discount";
	public static final String COLUMN_CREATED = "created";
	
    public static final String CUSTOMER_TABLE_CREATE =
            "CREATE TABLE " + Customer.TABLE_CUSTOMER + " (" +
            Customer.COLUMN_ID + " INTEGER PRIMARY KEY, " +
            Customer.COLUMN_FIRST_NAME + " TEXT, " +
            Customer.COLUMN_LAST_NAME + " TEXT, " +
            Customer.COLUMN_ZIPCODE + " TEXT, " +
            Customer.COLUMN_EMAIL + " TEXT, " +
            Customer.COLUMN_GOLD_STATUS + " BOOLEAN, " +                
            Customer.COLUMN_CREATED + " LONG, " +
            Customer.COLUMN_DISCOUNT + " INTEGER);";
    
	private long id;

	private String firstName;
	private String lastName;
	private String zipCode;
	private String email;
	private boolean goldStatus;
	private int discount;
	private Date created;
	
	/**
	 * Creates a new instance of {@code Customer} using the current
	 * date and time to populate the {@code created} field.
	 * The initial discount is 0 and the gold status {@code false}.
	 */
	public Customer() {
		super();
		this.created = new Date();
		setDiscount(0);
		setGoldStatus(false);
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean hasGoldStatus() {
		return goldStatus;
	}
	public void setGoldStatus(boolean goldStatus) {
		this.goldStatus = goldStatus;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getCreated() {
		return created;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public ContentValues contentValues() {
	    ContentValues values = new ContentValues();
	    values.put(COLUMN_FIRST_NAME, getFirstName());
	    values.put(COLUMN_LAST_NAME, getLastName());
	    values.put(COLUMN_EMAIL, getEmail());
	    values.put(COLUMN_ZIPCODE, getZipCode());
	    values.put(COLUMN_GOLD_STATUS, hasGoldStatus());
	    values.put(COLUMN_CREATED, getCreated().getTime());
	    values.put(COLUMN_DISCOUNT, getDiscount());
	    return values;
	}

	public static Customer fromCursor(Cursor cursor) {
			Customer c = new Customer();
			c.setId(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)));
			c.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRST_NAME)));
			c.setLastName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LAST_NAME)));
			c.setZipCode(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ZIPCODE)));
			c.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)));
			c.setGoldStatus(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_GOLD_STATUS))>0);
			c.setCreated(new Date(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_CREATED))));
			c.setDiscount(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_DISCOUNT)));
			return c;
		}
	
	public String fullName() {
		return getFirstName() + " " + getLastName();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + discount;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (goldStatus ? 1231 : 1237);
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", zipCode=" + zipCode
				+ ", email=" + email + ", goldStatus=" + goldStatus
				+ ", discount=" + discount + ", created=" + created + "]";
	}
	
}
