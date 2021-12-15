package dao.sqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DungChung {
	final private String URL="jdbc:sqlserver://HUYNHBAO\\SQLEXPRESS:1433;databaseName=QlSach;user=sa; password=18T1021011";
	final private String CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public Connection cn;
	public void connect() throws SQLException, ClassNotFoundException{
		//b1: Xac dinh HQTCSDL
    	Class.forName(CLASS_NAME);
    	cn= DriverManager.getConnection(URL);
    	System.out.println("Da ket noi");
	}
	
	public void disconnect() throws SQLException {
		cn.close();
	}
}
