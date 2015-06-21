package info.androidhive.tabsswipe;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.fju.juice.student.Book;
import com.fju.juice.student.DataListView;
import com.fju.juice.student.MySQLiteHelper;
import com.fju.student.fruit.juice.R;

import android.R.color;

import android.app.ListFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GamesFragment extends Fragment {

	static final ArrayList<HashMap<String,String>> myList = new ArrayList<HashMap<String,String>>(); 
	static final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	MySQLiteHelper db;
	StringBuilder builder = new StringBuilder();
	private ListView lv;
	private SimpleAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_games, container, false);
		return rootView;
	}
	
	@Override
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		db = new MySQLiteHelper(getActivity());
		String[] result = db.getAllBuysStringArray();
		ListView leaderboard = (ListView) getView().findViewById(R.id.profilelist);
		TextView aaa = (TextView) getView().findViewById(R.id.textView1_test);		
		ArrayAdapter adapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, result);
        
        SimpleAdapter adapter = new SimpleAdapter(
        		getActivity(),
        		myList,
        		R.layout.leaderboard_item,
        		new String[] {"name","price","number", "ice", "sugar", "pc", "customerID", "date"},
        		new int[] {R.id.nameText,R.id.priceText, R.id.numberText, R.id.iceText, R.id.sugarText, R.id.pcText, R.id.customerIDText, R.id.dateText}
        		);
        populateList();
  		leaderboard.setAdapter(adapter2);
		//buttons and field initialize		 


		
	}
	
	private void populateList() {
    	HashMap<String,String> temp = new HashMap<String,String>();
    	
    	temp.put("name","fff");
    	temp.put("price", "22");
    	temp.put("number", "5");
    	temp.put("ice", "good");
    	temp.put("sugar", "okkkk");
    	temp.put("customerID", "3456234");
    	temp.put("date", "15469834:00");
    	myList.add(temp);
    	
    	temp.clear();
    	temp.put("name","ffg");
    	temp.put("price", "22");
    	temp.put("number", "5");
    	temp.put("ice", "good");
    	temp.put("sugar", "okkkk");
    	temp.put("customerID", "3456234");
    	temp.put("date", "15469834:00");
    	myList.add(temp);
    }
	
	
	
	  	
	
}
