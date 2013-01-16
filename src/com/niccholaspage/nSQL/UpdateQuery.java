package com.niccholaspage.nSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery extends Query {
	private boolean comma;
	
	private boolean and;
	
	protected UpdateQuery(Connection connection, String sql){
		super(connection, sql);
		
		comma = false;
		
		and = false;
	}
	
	public UpdateQuery set(String field, Object value){
		if (comma){
			sql += ",";
		}
		
		sql += " " + field + "=" + value;
		
		comma = true;
		
		return this;
	}
	
	public UpdateQuery where(String where){
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
