package com.example.tab;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Two extends Fragment{

	
	inventory inven ;
	SQLiteDatabase sqdb;
EditText t1,t2,t3,t4;
Button b;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.activity_two,container,false);
	}

	@Override
	public void onStart() {
		
		
		
		
		
		
		
		final Activity act = getActivity();
				t1 = (EditText) act.findViewById(R.id.editText1); 
				t2 = (EditText) act.findViewById(R.id.editText2); 
				t3 = (EditText) act.findViewById(R.id.editText3); 
				t4 = (EditText) act.findViewById(R.id.editText4); 
				
				b = (Button) act.findViewById(R.id.button1);
			inven = new inventory(act);
			sqdb = inven.getWritableDatabase();
				
				b.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
					int ccode = Integer.parseInt(t1.getText()+"");
					String cname = t2.getText()+"";
					String city = t3.getText()+"";
					String contact = t4.getText()+"";
					
					try{
					sqdb.execSQL("insert into customer(ccode,cname,city,contact)values("+ccode+",'"+cname+"','"+city+"','"+contact+"');");
					sqdb.close();
					Toast.makeText(act,"submitted",Toast.LENGTH_LONG).show();
					}catch(Exception e)
					{
						Toast.makeText(getActivity(), "Record not available",Toast.LENGTH_LONG).show();
					}
					
					
					
					}
				});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		super.onStart();
	}
	
}


