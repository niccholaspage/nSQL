import java.sql.Connection;

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
}
