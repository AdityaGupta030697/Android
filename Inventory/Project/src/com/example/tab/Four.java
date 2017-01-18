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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Four extends Fragment{

	inventory inven ;
	SQLiteDatabase sqdb,sqdb2;
EditText t1,t2,t3,t4,t5,t6;
Button b;
Spinner sp1,sp2,sp3;
ArrayList<String> al,al2,al3;
ArrayAdapter<String> ad ,ad2,ad3;
	String s1,s2,s3;
	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_four,container,false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		final Activity act = getActivity();
		inven = new inventory(act);
		sp1 = (Spinner)act.findViewById(R.id.spinner1);
		sp2 = (Spinner)act.findViewById(R.id.spinner2);
		sp3 = (Spinner)act.findViewById(R.id.spinner3);
		al = new ArrayList<String>();
ad = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al);
al2 = new ArrayList<String>();
ad2 = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al2);
al3 = new ArrayList<String>();
ad3 = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al3);
		
		
		try{
		
		sqdb = inven.getReadableDatabase();
		
	al.add("Order no ");
		Cursor cr = sqdb.rawQuery("select ordno from saleorder;",null);
		
		
		while(!cr.isLast())
		{
			cr.moveToNext();
			al.add(cr.getInt(0)+"");
			
		}
		
		sp1.setAdapter(ad);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				s1 = arg0.getItemAtPosition(arg2) +"";
				t2.setText(s1);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		al2.add("Customer Code ");
		Cursor cr2 = sqdb.rawQuery("select ccode from customer;",null);
		
		
		while(!cr2.isLast())
		{
			cr2.moveToNext();
			al2.add(cr2.getInt(0)+"");
			
		}
		
		sp2.setAdapter(ad2);
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				s2 = arg0.getItemAtPosition(arg2)+"";
				t3.setText(s2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		al3.add("Item Code");
		Cursor cr3 = sqdb.rawQuery("select icode from item;",null);
		
		
		while(!cr3.isLast())
		{
			cr3.moveToNext();
			al3.add(cr3.getInt(0)+"");
			
		}
		
		sp3.setAdapter(ad3);
		sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				s3 = arg0.getItemAtPosition(arg2)+"";
				t4.setText(s3);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		}catch(Exception e)
		
		{
			Toast.makeText(getActivity(), "Record not available",Toast.LENGTH_LONG).show();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		t1 = (EditText) act.findViewById(R.id.editText1); 
		t2 = (EditText) act.findViewById(R.id.editText2); 
		t3 = (EditText) act.findViewById(R.id.editText3); 
		t4 = (EditText) act.findViewById(R.id.editText4); 
		t5 = (EditText) act.findViewById(R.id.editText5);
		t6 = (EditText) act.findViewById(R.id.editText6);
		b = (Button) act.findViewById(R.id.button1);

	sqdb = inven.getWritableDatabase();
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//sale (srno int ,ordno int ,ccode int,icode int,rate int ,sdate string)
				int srno = Integer.parseInt(t1.getText()+"");	
			int ordno = Integer.parseInt(t2.getText()+"");
			int ccode = Integer.parseInt(t3.getText()+"");
			int icode = Integer.parseInt(t4.getText()+"");
			int rate = Integer.parseInt(t5.getText()+"");
			String sdate = t6.getText()+"";
			
			
			try{
			sqdb.execSQL("insert into sale(srno,ordno,ccode,icode,rate,sdate)values("+srno+","+ordno+","+ccode+","+icode+","+rate+",'"+sdate+"');");
			sqdb.close();
			Toast.makeText(act,"submitted",Toast.LENGTH_LONG).show();
			}catch(Exception e)
			{
				Toast.makeText(getActivity(), "Record not available",Toast.LENGTH_LONG).show();
			}
			
			
			
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		super.onStart();
	}
	

}
