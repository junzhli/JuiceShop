package info.androidhive.tabsswipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fju.juice.student.MySQLiteHelper;
import com.fju.student.fruit.juice.R;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TopRatedFragment extends Fragment {
	Spinner spinnerClick;
	Spinner spinnerClickNum;
	MySQLiteHelper db;
	EditText customerID;
	public TextView total;
	private Button btnDo;
	private RadioButton radioButtonIce;
	private RadioButton radioButtonSugar;
	private RadioButton radioButtonCapacity;
	private RadioGroup radioIceGroup;
	private RadioGroup radioSugarGroup;
	private RadioGroup radioCapacityGroup;
	private String Ice;
	private String Sugar;
	private String Capacity;
	private String CustomerID;
	

    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);
		
		
		return rootView;
	}
	@Override
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		final TextView total = (TextView) getView().findViewById(R.id.textView8_Total);
		db = new MySQLiteHelper(getActivity());
		List<String> celebrities =  db.getAllBooksName();
		spinnerClick = (Spinner)getView().findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, celebrities);
		spinnerClick.setAdapter(adapter);
        spinnerClick.setOnItemSelectedListener(
		               new AdapterView.OnItemSelectedListener() {
		                   @Override
		                   public void onItemSelected(AdapterView<?> arg0, View arg1,
		                           int arg2, long arg3) {
		                       int position = spinnerClick.getSelectedItemPosition();
		                       int value = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()));
		                       String tmp = Integer.toString(value);
		                       total.setText(tmp);
		                    	   radioIceGroup = (RadioGroup) getView().findViewById(R.id.radioIce);
		                    	   radioIceGroup.setEnabled(false);		                       
		                   }
		                   @Override
		                   public void onNothingSelected(AdapterView<?> arg0) {
		                       // TODO Auto-generated method stub
		                	  
		                   }
		               }
		           );
		  //Number Spinner Menu initialize and Listener
		  List<String> number=new ArrayList<String>();
		  number.add("1");
		  number.add("2");
		  number.add("3");
		  number.add("4");
		  number.add("5");
		  number.add("6");
		  number.add("7");
		  number.add("8");
		  number.add("9");
		  number.add("10");
		  spinnerClickNum = (Spinner)getView().findViewById(R.id.spinner2_number);
			ArrayAdapter<String> adapter_number = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, number);
			spinnerClickNum.setAdapter(adapter_number);
	        spinnerClickNum.setOnItemSelectedListener(
			               new AdapterView.OnItemSelectedListener() {
			                   @Override
			                   public void onItemSelected(AdapterView<?> arg0, View arg1,
			                           int arg2, long arg3) {
			                       int position = spinnerClickNum.getSelectedItemPosition();
			                       if(Capacity.contains("大")){
				                    	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()));
				            			String totalString = Integer.toString(total_);
				            			total.setText(totalString);
				                    }
				                    if(Capacity.contains("中")){
				                    	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * (Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()) ) - 5);
				            			String totalString = Integer.toString(total_);
				            			total.setText(totalString);
				                    }
				                    if(Capacity.contains("小")){
				                    	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * (Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()) ) - 10);
				            			String totalString = Integer.toString(total_);
				            			total.setText(totalString);
				                    }
			                   }
			                   @Override
			                   public void onNothingSelected(AdapterView<?> arg0) {
			                       // TODO Auto-generated method stub
			                   }
			               }
			           );
	     
	      //Upload Button Listener
		      btnDo = (Button)getView().findViewById(R.id.button1Upload);
			  btnDo.setOnClickListener(btnDoListener);
			  radioIceGroup = (RadioGroup) getView().findViewById(R.id.radioIce);
			  radioSugarGroup = (RadioGroup) getView().findViewById(R.id.radioSugar);
			  radioCapacityGroup = (RadioGroup) getView().findViewById(R.id.radioCapicity);
			    radioIceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			        public void onCheckedChanged(RadioGroup arg0, int id) {
			        	int selectedIdIce = radioIceGroup.getCheckedRadioButtonId();
			        	radioButtonIce = (RadioButton)getView().findViewById(selectedIdIce);
			        	
			        	Ice = radioButtonIce.getText().toString();
			        }
			      });
			    radioSugarGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			        public void onCheckedChanged(RadioGroup arg0, int id) {
			        	int selectedIdSugar = radioSugarGroup.getCheckedRadioButtonId();
			        	radioButtonSugar = (RadioButton)getView().findViewById(selectedIdSugar);
			        	Sugar = radioButtonSugar.getText().toString();
			        }
			      });
			    radioCapacityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			        public void onCheckedChanged(RadioGroup arg0, int id) {
			        	int selectedIdCapacity = radioCapacityGroup.getCheckedRadioButtonId();
			        	radioButtonCapacity = (RadioButton)getView().findViewById(selectedIdCapacity);
			        	Capacity = radioButtonCapacity.getText().toString();
			        	
			        	// Change value if change
			        	int value = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()));
	                    if(Capacity.contains("大")){
	                    	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()));
	            			String totalString = Integer.toString(total_);
	            			total.setText(totalString);
	                    }
	                    if(Capacity.contains("中")){
	                    	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * (Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()) ) - 5);
	            			String totalString = Integer.toString(total_);
	            			total.setText(totalString);
	                    }
	                    if(Capacity.contains("小")){
	                    	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * (Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()) ) - 10);
	            			String totalString = Integer.toString(total_);
	            			total.setText(totalString);
	                    }
			        	
	                      
			        	
			        }
			      });
			    			// (initialize)
			    int selectedIdIce = radioIceGroup.getCheckedRadioButtonId();
	        	radioButtonIce = (RadioButton)getView().findViewById(selectedIdIce);
	        	Ice = radioButtonIce.getText().toString();
	        	int selectedIdSugar = radioSugarGroup.getCheckedRadioButtonId();
	        	radioButtonSugar = (RadioButton)getView().findViewById(selectedIdSugar);
	        	Sugar = radioButtonSugar.getText().toString();
	        	int selectedIdCapacity = radioCapacityGroup.getCheckedRadioButtonId();
	        	radioButtonCapacity = (RadioButton)getView().findViewById(selectedIdCapacity);
	        	Capacity = radioButtonCapacity.getText().toString();
			 //Customer ID response Code Listener
			 customerID = (EditText)getView().findViewById(R.id.editText1_nameJuice);
			 
			 
		  
	};
	
	
	  
	

	
	private Button.OnClickListener btnDoListener = new Button.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity().getApplicationContext(),"購物記錄已上傳並更新",Toast.LENGTH_LONG).show();
			CustomerID = customerID.getText().toString();
			String name = spinnerClick.getSelectedItem().toString();
			String totalString = null;
			Capacity = radioButtonCapacity.getText().toString();
			if(Capacity.contains("大")){
              	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()));
    			totalString = Integer.toString(total_);
            }
            if(Capacity.contains("中")){
            	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * (Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()) ) - 5);
    			totalString = Integer.toString(total_);
            }
            if(Capacity.contains("小")){
            	int total_ = Integer.parseInt(spinnerClickNum.getSelectedItem().toString()) * (Integer.parseInt(db.findPrice(spinnerClick.getSelectedItem().toString()) ) - 10);
    			totalString = Integer.toString(total_);
            }
			
			
			db.updateBuy(spinnerClick.getSelectedItem().toString(), totalString, spinnerClickNum.getSelectedItem().toString(), Ice, Sugar, CustomerID, Capacity);
			Intent i = getActivity().getBaseContext().getPackageManager()
		             .getLaunchIntentForPackage( getActivity().getBaseContext().getPackageName() );
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}
		
	};
}