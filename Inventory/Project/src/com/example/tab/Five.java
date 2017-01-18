package com.example.tab;

import java.util.ArrayList;

import android.R.string;
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

public class Five extends Fragment{
	
	
	Spinner sp;
	EditText et1;
	Button b;
	inventory iv;
	SQLiteDatabase sq,sq2;
	ArrayList<String> ar;
	ArrayAdapter<String> ad;
	Integer k,j;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_five,container,false);
	}

	@Override
	public void onStart() {
		
		
		
		try{
		
		final Activity act = getActivity();
		et1 = (EditText)act.findViewById(R.id.editText1);
		sp = (Spinner)act.findViewById(R.id.spinner1);
		b = (Button)act.findViewById(R.id.button1);
		iv = new inventory(act);
		sq = iv.getReadableDatabase();
		ar = new ArrayList<String>();
		ad = new ArrayAdapter<String>(act, android.R.layout.simple_spinner_item,ar);
		
Cursor cr = sq.rawQuery("select * from item ;",null);
		
		
		while(!cr.isLast())
		{
			cr.moveToNext();
			ar.add(cr.getInt(0)+"");
			
		
		}
		
		sp.setAdapter(ad);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				j = Integer.parseInt(arg0.getItemAtPosition(arg2)+"");
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	
		});
	
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				k = Integer.parseInt(et1.getText()+"");
				sq2 = iv.getWritableDatabase();
				sq2.execSQL(" update item set qty = qty + "+k+" where icode = "+j+";");
				Toast.makeText(act, "added",0).show();
						}
		});
		
		
		
	}catch(Exception e)
	{
		Toast.makeText(getActivity(), "Record not available",Toast.LENGTH_LONG).show();
	}
		// TODO Auto-generated method stub
		super.onStart();
		
		
		
		
	}
	

}
