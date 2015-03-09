package edu.gatech.seclass.prj2.data;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomerAdapter extends CursorAdapter {

	public CustomerAdapter(Context context, Cursor c) {
		super(context, c, 0);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		  return LayoutInflater.from(context).inflate(android.R.layout.two_line_list_item, parent, false);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
	      TextView nameView = (TextView) view.findViewById(android.R.id.text1);
	      TextView detailsView = (TextView) view.findViewById(android.R.id.text2);
	      Customer customer = Customer.fromCursor(cursor);
	      nameView.setText(customer.fullName());
	      detailsView.setText("Gold Status: " + customer.hasGoldStatus() + ", Current Discount: " + String.valueOf(customer.getDiscount()));
	}

}
