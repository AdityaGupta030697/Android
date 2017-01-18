package com.example.tab;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class One extends Fragment{
	
	

	
	inventory inven ;
	SQLiteDatabase sqdb;
EditText t1,t2,t3,t4,t5;
Button b;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View root =  inflater.inflate(R.layout.activity_one,container,false);
		return root;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		//getActivity().findViewById(id);
		//use get Activity at all place (act) 
	
		
	try{
Activity act = getActivity();
		t1 = (EditText) act.findViewById(R.id.editText1); 
		t2 = (EditText) act.findViewById(R.id.editText2); 
		t3 = (EditText) act.findViewById(R.id.editText3); 
		t4 = (EditText) act.findViewById(R.id.editText4); 
		t5 = (EditText) act.findViewById(R.id.editText5); 
		b = (Button) act.findViewById(R.id.button1);
	inven = new inventory(act);
	sqdb = inven.getWritableDatabase();
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			int icode = Integer.parseInt(t1.getText()+"");
			String iname = t2.getText()+"";
			int qty = Integer.parseInt(t3.getText()+"");
			int price = Integer.parseInt(t4.getText()+"");
			String date = t5.getText()+"";
			sqdb.execSQL("insert into  item(icode,iname,qty,price,date)values("+icode+",'"+iname+"',"+qty+","+price+",'"+date+"');");
			sqdb.close();
			Toast.makeText(getActivity(),"submitted",Toast.LENGTH_LONG).show();
			
			
			
			}
		});
		
		
	}catch(Exception e)
	{
		Toast.makeText(getActivity(), "Record not available",Toast.LENGTH_LONG).show();
	}
		
		
		
		
		super.onStart();
		
		
		
		
		
	}
	
	
	
	
	}

