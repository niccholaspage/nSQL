import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery extends Query {
	private boolean comma;
	
	public UpdateQuery(Connection connection, String sql){
		super(connection, sql);
		
		comma = false;
	}
	
	public UpdateQuery set(String set){
		if (comma){
			sql += ",";
		}
		
		sql += " " + set;
		
		comma = true;
		
		return this;
	}
	
	public void execute(){
		Statement statement;
		try {
			statement = connection.createStatement();
			
			statement.executeQuery(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
