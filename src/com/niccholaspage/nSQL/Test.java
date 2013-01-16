package com.niccholaspage.nSQL;

import com.niccholaspage.nSQL.query.CreateQuery;
import com.niccholaspage.nSQL.query.DeleteQuery;
import com.niccholaspage.nSQL.query.InsertQuery;
import com.niccholaspage.nSQL.query.SelectQuery;
import com.niccholaspage.nSQL.query.UpdateQuery;

public class Test {
	public static void main(String[] args){
		Table table = new Table(null, "nRPG_accounts");
		
		CreateQuery createQuery = table.create().create("INTEGER PRIMARY KEY AUTOINCREMENT").create("name varchar(64) NOT NULL");
		
		System.out.println(createQuery);
		
		SelectQuery selectQuery = table.select("*").where("name=gabe").where("money=100").where("gabe=yolo");
		
		System.out.println(selectQuery);
		
		UpdateQuery updateQuery = table.update().set("name", "yolo").set("money", 1230).set("gabe", "gabe");
		
		System.out.println(updateQuery);
		
		InsertQuery insertQuery = table.insert().insert("name").insert("money").value("yolo").value("212");
		
		System.out.println(insertQuery);
		
		DeleteQuery deleteQuery = table.delete().where("name=gabe").where("money=100");
		
		System.out.println(deleteQuery);
	}
}
