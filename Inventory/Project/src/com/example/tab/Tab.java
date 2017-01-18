package com.example.tab;

import android.R.drawable;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Tab extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem mt2 = 	menu.add("exit");
		
		
		
	
		
		
		
		
		// Inflate the menu; this adds items to the action bar if it is present.
		ActionBar actionBar = getActionBar();
		ActionBar.Tab t = actionBar.newTab();
		t.setText("Item Details");

		t.setTabListener(new TabListener() {
			
			

			@Override
			public void onTabReselected(android.app.ActionBar.Tab arg0,
					FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(android.app.ActionBar.Tab arg0,
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				One f = new One();
				ft.replace(R.id.fm,f);
				
			
			}

			@Override
			public void onTabUnselected(android.app.ActionBar.Tab arg0,
					FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
		});

		ActionBar.Tab t1 = actionBar.newTab();
		t1.setText("Cust. Details");
		
t1.setTabListener(new TabListener() {
			
			

			@Override
			public void onTabReselected(android.app.ActionBar.Tab arg0,
					FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(android.app.ActionBar.Tab arg0,
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Two f = new Two();
				ft.replace(R.id.fm,f);
			}

			@Override
			public void onTabUnselected(android.app.ActionBar.Tab arg0,
					FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ActionBar.Tab t2 = actionBar.newTab();
		t2.setText("Order");
		
t2.setTabListener(new TabListener() {
			
			

			@Override
			public void onTabReselected(android.app.ActionBar.Tab arg0,
					FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(android.app.ActionBar.Tab arg0,
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Three f = new Three();
				ft.replace(R.id.fm,f);
				
			}

			@Override
			public void onTabUnselected(android.app.ActionBar.Tab arg0,
					FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
		});



ActionBar.Tab t3 = actionBar.newTab();
t3.setText("Selling Details");
//t3.setIcon(drawable.arrow_up_float);
t3.setTabListener(new TabListener() {
	
	

	@Override
	public void onTabReselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(android.app.ActionBar.Tab arg0,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Four f = new Four();
		ft.replace(R.id.fm,f);
	}

	@Override
	public void onTabUnselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
});
		


ActionBar.Tab t4 = actionBar.newTab();
t4.setText("Add Item");

t4.setTabListener(new TabListener() {
	
	

	@Override
	public void onTabReselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(android.app.ActionBar.Tab arg0,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Five f = new Five();
		ft.replace(R.id.fm,f);
	}

	@Override
	public void onTabUnselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
});
ActionBar.Tab t5 = actionBar.newTab();
t5.setText("Pending");
//t3.setIcon(drawable.arrow_up_float);
t5.setTabListener(new TabListener() {
	
	

	@Override
	public void onTabReselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(android.app.ActionBar.Tab arg0,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Six f = new Six();
		ft.replace(R.id.fm,f);
	}

	@Override
	public void onTabUnselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
});
ActionBar.Tab t6 = actionBar.newTab();
t6.setText("Sales Report");
//t3.setIcon(drawable.arrow_up_float);
t6.setTabListener(new TabListener() {
	
	

	@Override
	public void onTabReselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(android.app.ActionBar.Tab arg0,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Seven f = new Seven();
		ft.replace(R.id.fm,f);
	}

	@Override
	public void onTabUnselected(android.app.ActionBar.Tab arg0,
			FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
});	      
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.addTab(t);
		actionBar.addTab(t1);
		actionBar.addTab(t2);
		actionBar.addTab(t3);
		actionBar.addTab(t4);
		actionBar.addTab(t5);
		actionBar.addTab(t6);
		
		return true;
	
}
	public boolean onOptionsItemSelected(MenuItem i) {
		// TODO Auto-generated method stub
		//Toast.makeText(this,i.getTitle()+"",Toast.LENGTH_LONG).show();
		Toast.makeText(this,"GoodBye!!",Toast.LENGTH_LONG).show();
		if((i.getTitle()+"").equalsIgnoreCase("exit"))
		{
			finish();
		}
		
		
		
		
		return super.onOptionsItemSelected(i);
	}
}
