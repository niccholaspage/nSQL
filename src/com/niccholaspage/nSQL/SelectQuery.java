package com.niccholaspage.nSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery extends Query {
	private boolean and;
	
	public SelectQuery(Connection connection, String sql){
		super(connection, sql);
		
		and = false;
	}
	
	public SelectQuery where(String where){
		if (and){
			sql += " AND";
		}else {
			sql += " WHERE";
		}
		
		sql += " " + where;
		
		and = true;
		
		return this;
	}
	
	public ResultSet execute(){
		Statement statement;
		try {
			statement = connection.createStatement();
			
			ResultSet set = statement.executeQuery(sql);
			
			statement.close();
			
			return set;
		} catch (SQLException e){
			e.printStackTrace();
			
			return null;
		}
	}
}
