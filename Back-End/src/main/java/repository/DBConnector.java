package repository;
import java.sql.*;

import javax.sql.DataSource;

import org.apache.derby.jdbc.*;


public final class DBConnector {

/*
 * The method creates a Connection object. Loads the embedded driver,
 * starts and connects to the database using the connection URL.
 */
public static Connection createDatabaseConnection()
        throws SQLException, ClassNotFoundException {
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    Class.forName(driver);
    String url = "jdbc:derby:FOADB";
    Connection c = DriverManager.getConnection(url+";create=true");
    return c;
}
    }

    // private static DataSource dataSource;
    // public String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    // Connection conn = null;
    // Statement st = null;
    // String url = "jdbc:derby:FOADB";

    // javax.sql.DataSource makeDataSource (String dbname, boolean create){

	// EmbeddedDataSource ds = new EmbeddedDataSource(); 

	// if (create)
	// 	ds.setCreateDatabase("create");
   
	// return ds;
    // }



