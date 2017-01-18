package com.example.tab;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Seven extends Fragment{
	inventory inven ;
	SQLiteDatabase sqdb;
EditText t1,t2,t3,t4,t5;
Button b;
Spinner sp1;
ArrayList<String> al;
ArrayAdapter<String> ad ;
String s1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_seven,container,false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		try{
		Activity act = getActivity();
		t1 = (EditText) act.findViewById(R.id.editText1); 
		t2 = (EditText) act.findViewById(R.id.editText2); 
		t3 = (EditText) act.findViewById(R.id.editText3); 
		t4 = (EditText) act.findViewById(R.id.editText4); 
		t5 = (EditText) act.findViewById(R.id.editText5); 
		b = (Button) act.findViewById(R.id.button1);
		sp1 = (Spinner)act.findViewById(R.id.spinner1);
		inven = new inventory(act);
		
		al = new ArrayList<String>();
		ad = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al);
		
		al.add("Serial No");
		sqdb = inven.getReadableDatabase();
		
		
		Cursor cr = sqdb.rawQuery("select srno from sale;",null);
		
		
		while(!cr.isLast())
		{
			cr.moveToNext();
			al.add(cr.getInt(0)+"");
			
		
		}
		sp1.setAdapter(ad);
		
		
sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		s1 = arg0.getItemAtPosition(arg2)+"";
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				int k = Integer.parseInt(s1);
				Cursor cr2 = sqdb.rawQuery("select * from sale where srno = "+k+";",null);
				
				
				while(!cr2.isLast())
				{
					cr2.moveToNext();
					 t1.setText(cr2.getInt(1)+"");
					 t2.setText(cr2.getInt(2)+"");
					 t3.setText(cr2.getInt(3)+"");
					 t4.setText(cr2.getInt(4)+"");
					 t5.setText(cr2.getString(5));
					 
					 
					
				
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		catch(Exception e)
		{
			Toast.makeText(getActivity(), "Record not available",Toast.LENGTH_LONG).show();
		}
		
		
		
		
		super.onStart();
	}
	
	
	
	
	
}
