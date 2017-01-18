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

public class Three extends Fragment{
	
	
	inventory inven ;
	SQLiteDatabase sqdb,sqdb2;
EditText t1,t2,t3,t4,t5;
Button b;
Spinner sp1,sp2;
ArrayList<String> al,al2;
ArrayAdapter<String> ad ,ad2;
String s1,s2;
Integer i,sales;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_three,container,false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
		
		final Activity act = getActivity();
		inven = new inventory(act);
		sp1 = (Spinner)act.findViewById(R.id.spinner1);
		sp2 = (Spinner)act.findViewById(R.id.spinner2);
		al = new ArrayList<String>();
ad = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al);
al2 = new ArrayList<String>();
ad2 = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,al2);
		
		
		try{
			al.add("Item Code");
		sqdb = inven.getReadableDatabase();
		
	
		Cursor cr = sqdb.rawQuery("select * from item ;",null);
		
		
		while(!cr.isLast())
		{
			cr.moveToNext();
			al.add(cr.getInt(0)+"");
			
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sp1.setAdapter(ad);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> list, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				s1 = list.getItemAtPosition(position)+"";
				t2.setText(s1);
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		
		
		al2.add("Customer Code");
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		}catch(Exception e)
		
		{
			Toast.makeText(getActivity(), "OOPS!!!!!"+"\n" +"PLEASE CHECK"+"\n" +"IF YOU DID SOMETHIN WRONG SIR",Toast.LENGTH_LONG).show();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				t1 = (EditText) act.findViewById(R.id.editText1); 
				t2 = (EditText) act.findViewById(R.id.editText2); 
				t3 = (EditText) act.findViewById(R.id.editText3); 
				t4 = (EditText) act.findViewById(R.id.editText4); 
				t5 = (EditText) act.findViewById(R.id.editText5);
				
				b = (Button) act.findViewById(R.id.button1);
		
		
				
				b.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
					int ordno = Integer.parseInt(t1.getText()+"");
					int icode = Integer.parseInt(t2.getText()+"");
					int ccode = Integer.parseInt(t3.getText()+"");
					int qty = Integer.parseInt(t4.getText()+"");
					String orddate = t5.getText()+"";
					
					
					try{
						
					     sqdb = inven.getReadableDatabase();	
						
						Cursor cr3 = sqdb.rawQuery("select * from item where icode = "+icode+";",null);
						
						while(!cr3.isLast())
						{
							cr3.moveToNext();
						i = Integer.parseInt(cr3.getString(2)+"");
						
						
						}
					
						
						sales = i-qty;
						sqdb2 = inven.getWritableDatabase();
						
						if(qty>i)
						{
							sqdb2.execSQL("insert into penorder(ordno,ccode,icode,qty,orddate)values("+ordno+","+ccode+","+icode+","+qty+",'"+orddate+"');");
							Toast.makeText(act,"due to shortage of resources.....order shifted to pending",Toast.LENGTH_LONG).show();
						}
						else
						{
					sqdb2.execSQL("insert into saleorder(ordno,ccode,icode,qty,orddate)values("+ordno+","+ccode+","+icode+","+qty+",'"+orddate+"');");
				sqdb2.execSQL("update item set qty = "+sales+" where icode = "+icode+";");
						Toast.makeText(act,"submitted",Toast.LENGTH_LONG).show();
					}
					
					sqdb.close();
					sqdb2.close();
					
					}catch(Exception e)
					{
						Toast.makeText(getActivity(), "Record not available",Toast.LENGTH_LONG).show();					}
					
					
					
					}
				});
		
		
		
		
		
		
		
		
		
		
		
		
		super.onStart();
	}
	

}
