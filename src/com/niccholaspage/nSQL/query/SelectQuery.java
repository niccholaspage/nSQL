package com.niccholaspage.nSQL.query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery extends Query {
	private boolean and;
	
	private Statement statement;
	
	public SelectQuery(Connection connection, String sql){
		super(connection, sql);
		
		and = false;
	}
	
	public SelectQuery where(String key, Object value){
		if (and){
			sql += " AND";
		}else {
			sql += " WHERE";
		}
		
		sql += " " + key + "=";
		
		StringBuilder builder = new StringBuilder(value + "");
		
		if (value instanceof String){
			builder.insert(0, "'");
			
			builder.append("'");
		}
		
		sql += builder.toString();
		
		and = true;
		
		return this;
	}
	
	public ResultSet execute(){
		try {
			statement = connection.createStatement();
			
			ResultSet set = statement.executeQuery(sql);
			
			return set;
		} catch (SQLException e){
			e.printStackTrace();
			
			return null;
		}
	}
	
	public void close(){
		try {
			statement.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
