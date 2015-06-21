package com.fju.juice.student;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DataListView extends ListActivity {
	
	private ArrayList<String> results = new ArrayList<String>();
	private String tableName = MySQLiteHelper.tableName;
	private SQLiteDatabase newDB;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
    }
	private void displayResultList() {
		TextView tView = new TextView(this);
        tView.setText("This data is retrieved from the database and only 4 " +
        		"of the results are displayed");
        getListView().addHeaderView(tView);
        
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
		
	}
	private void openAndQueryDatabase() {
		try {
			MySQLiteHelper dbHelper = new MySQLiteHelper(this.getApplicationContext());
			newDB = dbHelper.getWritableDatabase();
			Cursor c = newDB.rawQuery("SELECT * FROM BUY", null);

	    	if (c != null ) {
	    		if  (c.moveToFirst()) {
	    			do {
	    				String Name = c.getString(c.getColumnIndex("name"));
	    				String Price = c.getString(c.getColumnIndex("price"));
	    				String Number = c.getString(c.getColumnIndex("number"));
	    				String Ice = c.getString(c.getColumnIndex("ice"));
	    				String Sugar = c.getString(c.getColumnIndex("surgar"));
	    				String PC = c.getString(c.getColumnIndex("pc"));
	    				String CustomerID = c.getString(c.getColumnIndex("customerID"));
	    				String Date = c.getString(c.getColumnIndex("date"));
	    				results.add("Name: " + Name + ",Price: " + Price + ",Number: " + Number + ", Ice: " + Ice + ", Sugar" + Sugar + "," +
	    						" PC: " + PC + ", CustomerID: " + CustomerID + ", Date: " + Date
	    						);
	    			}while (c.moveToNext());
	    		} 
	    	}			
		} catch (SQLiteException se ) {
        	Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } finally {
        	if (newDB != null) 
        		newDB.close();
        }

	}
    
}