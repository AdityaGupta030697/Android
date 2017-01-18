package com.example.tab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class inventory extends SQLiteOpenHelper{

	public inventory(Context context) {
		super(context,"inventory",null,112);
		// TODO Auto-generated constructor stub
}
@Override
	public void onCreate(SQLiteDatabase sql) {
		// TODO Auto-generated method stub
		sql.execSQL("create table item(icode Integer ,iname string,qty int,price int ,date string);");
		sql.execSQL("create table customer(ccode int,cname string,city string,contact string);");
		sql.execSQL("create table saleorder(ordno int,ccode int,icode int,qty int,orddate string);"); 
		sql.execSQL("create table sale (srno int ,ordno int ,ccode int,icode int,rate int ,sdate string);");
		}

	@Override
	
	public void onUpgrade(SQLiteDatabase sql, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
		sql.execSQL("create table penorder(ordno int,ccode int,icode int,qty int,orddate string);"); 
		}
}
