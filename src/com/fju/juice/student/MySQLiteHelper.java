package com.fju.juice.student;
 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
 
import com.fju.juice.student.Book;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.Time;
import android.util.Log;
 
public class MySQLiteHelper extends SQLiteOpenHelper {
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "JuiceDB";
    public static String tableName = "COMPANY"; // DataListView.java
    
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override 
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create tables
    	// /*
        // NULL, Due to the database file (JuiceDB) pre-loaded
    	// If the program first runs without Database imported, it will crash.
    	// So if it should be copy Database (JuiceDB) to Android Device Data partition : /data/data/com.fju.student.fruit.juice/databases
    	// Android must be ROOTED
    	// */
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
    	// NULL
        // create fresh books table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------
 
    /**
     * CRUD operations (create "add", read "get", update, delete) book + get all books + delete all books
     */
     
    // Get All Books name
    public List<String> getAllBooksName() {
        	List<String> labels = new ArrayList<String>();
        	
             //Select All Query
            String selectQuery = "SELECT name FROM juice";
         
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
         
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                	labels.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
            // closing connection
            cursor.close();
            //Select Smoothie Table
            db = this.getReadableDatabase();
            String selectQuerySmoothie = "SELECT name FROM smoothie";
            Cursor cursor1 = db.rawQuery(selectQuerySmoothie, null);
         
            // looping through all rows and adding to list
            if (cursor1.moveToFirst()) {
                do {
                	labels.add(cursor1.getString(0));
                } while (cursor1.moveToNext());
            }
            
            // closing connection
            cursor1.close();
            db.close();
        	
        	// returning lables
        	return labels;
        }
    
    public int updateBuy(String name, String price, String number, String ice, String surgar, String CustomerID, String pc) {
    	 
        // Get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        // Input values, and make a query.
        ContentValues values = new ContentValues();
        values.put("name", name); // inserting a string
        values.put("prize", price); // inserting an int
        values.put("number", number); // inserting an int
        values.put("ice", ice); // inserting an int
        values.put("sugar", surgar); // inserting an int
        values.put("ID", CustomerID);
        values.put("pc", pc);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String test = sdf.format(cal.getTime());
        values.put("date", Calendar.getInstance().getTime().toLocaleString());

        // Inserting Row
        db.insert("COMPANY", null, values);
        // 4. close
        db.close();
 
        return 1;
 
    }

	public String findPrice(String name) {
		// TODO Auto-generated method stub
		String Price = new String();
		String selectQueryJuice = "SELECT prize FROM juice WHERE name = '" + name + "'";
		String selectQuerySmoothie = "SELECT prize FROM smoothie WHERE name = '" + name + "'";

		SQLiteDatabase db = this.getReadableDatabase();
		if(name.contains("果汁")){
			Cursor cursor = db.rawQuery(selectQueryJuice, null);
	        // looping through all rows and adding to list
	        if (cursor.moveToFirst()) {
	            do {
	            	Price = cursor.getString(0);
	            	
	            } while (cursor.moveToNext());
	        }
	        cursor.close();
		}
		if(name.contains("冰沙")){
			Cursor cursor = db.rawQuery(selectQuerySmoothie, null);
		     
	        // looping through all rows and adding to list
			if (cursor.moveToFirst()) {
	            do {
	            	Price = cursor.getString(0);
	            } while (cursor.moveToNext());
	        }
	        cursor.close();
		}
        
        // closing connection
        
        db.close();
		
		return Price;
	}

	public void updateMenu(String name, String price) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
        values.put("name", name); // inserting a string
        values.put("prize", price); // inserting an int
        
        // Inserting Row
        if(name.contains("果汁")){
        	db.insert("juice", null, values);
        }
        if(name.contains("冰沙")){
        	db.insert("smoothie", null, values);
        }
        // 4. close
        db.close();
	}
	
	public List<Book> getAllBuys()
	{
	    List<Book> BookList = new ArrayList<Book>();

	    //select query
	    String selectQuery = "SELECT * FROM COMPANY";

	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);


	    for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
	    {
	         Book book = new Book();
	            book.setName(cursor.getString(0));
	            book.setPrice(cursor.getString(1));
	            book.setNumber(cursor.getString(2));
	            book.setIce(cursor.getString(3));
	            book.setSugar(cursor.getString(4));
	            book.setPC(cursor.getString(5));
	            book.setCustomerID(cursor.getString(6));
	            book.setDate(cursor.getString(7));
	            // Adding History to list
	            BookList.add(book);
	    }

	    return BookList;

	}
	
	public String[] getAllBuysStringArray()
	{
	    

	    //select query
	    String selectQuery = "SELECT * FROM COMPANY";

	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	    String[] BookList = new String[cursor.getCount()];
	    int i = 0;
	    for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
	    {
	            BookList[i] = "Name : " + cursor.getString(0) + ", Price = " + cursor.getString(1) + ", Number = " + cursor.getString(2) + ", Ice = " + cursor.getString(3) + ", Sugar = " +  cursor.getString(4) + ", PC = " + cursor.getString(5) + ", Customer ID = " + cursor.getString(6) + ", Date = " + cursor.getString(7);
	            i++;
	    }

	    return BookList;

	}
	
	
}