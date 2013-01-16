package com.niccholaspage.nSQL.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery extends Query {
	private boolean and;
	
	public DeleteQuery(Connection connection, String sql){
		super(connection, sql);
		
		and = false;
	}
	
	public DeleteQuery where(String where){
		if (and){
			sql += " AND";
		}else {
			sql += " WHERE";
		}
		
		sql += " " + where;
		
		and = true;
		
		return this;
	}
	
	public void execute(){
		Statement statement;
		try {
			statement = connection.createStatement();
			
			statement.executeQuery(sql);
			
			statement.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
