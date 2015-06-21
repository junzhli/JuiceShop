package info.androidhive.tabsswipe;

import java.util.ArrayList;
import java.util.List;

import com.fju.juice.student.MySQLiteHelper;
import com.fju.student.fruit.juice.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class Order extends Fragment {
	MySQLiteHelper db;
	EditText name_Juice;
	EditText name_Smoothie;
	EditText price_Juice;
	EditText price_Smoothie;
	Button juiceNew;
	Button smoothieNew;
	private String Name_Juice;
	private String Name_Smoothie;
	private String Price_Juice;
	private String Price_Smoothie;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_order, container, false);
		return rootView;
	}
	
	@Override
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		db = new MySQLiteHelper(getActivity());
	//buttons and field initialize		 
		name_Juice = (EditText)getView().findViewById(R.id.editText1_nameJuice);
		name_Smoothie = (EditText)getView().findViewById(R.id.editText3_nameSmoothie);
		price_Juice = (EditText)getView().findViewById(R.id.editText2_priceJuice);
		price_Smoothie = (EditText)getView().findViewById(R.id.editText4_priceSmoothie);
		
		Button juiceNew = (Button)getView().findViewById(R.id.button1_newJuice);
		Button smoothieNew = (Button)getView().findViewById(R.id.button2_newSmoothie);
		juiceNew.setOnClickListener(juiceNewDoListener);
		smoothieNew.setOnClickListener(smoothieNewDoListener);
		  
	};
	
	private Button.OnClickListener juiceNewDoListener = new Button.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Name_Juice = name_Juice.getText().toString();
			Price_Juice = price_Juice.getText().toString();
			if(!Name_Juice.contains("果汁") || Price_Juice.isEmpty()){
				AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create(); //Read Update
				 
				alertDialog.setMessage("資料為空或者為非果汁商品");
		        alertDialog.show();  //<-- See This!
			}
			else {
				Toast.makeText(getActivity().getApplicationContext(),"商品已加入並上架",Toast.LENGTH_LONG).show();
				
				db.updateMenu(Name_Juice, Price_Juice);
				//db.UpdateData
				name_Juice.setText("");
				price_Juice.setText("");
			}
			
		}
		
	};
	
	private Button.OnClickListener smoothieNewDoListener = new Button.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Name_Smoothie = name_Smoothie.getText().toString();
			Price_Smoothie = price_Smoothie.getText().toString();
			if(!Name_Smoothie.contains("冰沙") || Price_Smoothie.isEmpty()){
				AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create(); //Read Update
		        
				alertDialog.setMessage("資料為空或者為非冰沙商品");
		        alertDialog.show();  //<-- See This!
			}
			else {
				Toast.makeText(getActivity().getApplicationContext(),"商品已加入並上架",Toast.LENGTH_LONG).show();
				
				db.updateMenu(Name_Smoothie, Price_Smoothie);
				//db.UpdateData
				name_Smoothie.setText("");
				price_Smoothie.setText("");
				
			}
			
			
		}
		
	};
	
}
