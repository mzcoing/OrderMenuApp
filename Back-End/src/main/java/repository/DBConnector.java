package repository;
import java.sql.*;

// import javax.sql.DataSource;

// import org.apache.derby.jdbc.*;
// import org.skife.jdbi.v2.sqlobject.Bind;
// import org.skife.jdbi.v2.sqlobject.SqlQuery;
// import org.skife.jdbi.v2.sqlobject.SqlUpdate;


public class DBConnector   {

    public static Connection createDatabaseConnection()

    throws SQLException, ClassNotFoundException {
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver);
             String url = "jdbc:derby:FOADB";
            Connection c = DriverManager.getConnection(url+";create=true");
            return c;
            }
    }

// @SqlUpdate("create table Menu (id int primary key, name varchar(100), items )")
    // void createSomethingTable();
  
    // @SqlUpdate("insert into something (id, name) values (:id, :name)")
    // void insert(@Bind("id") int id, @Bind("name") String name);
  
    // @SqlQuery("select name from something where id = :id")
    // String findNameById(@Bind("id") int id);
/*
 * The method creates a Connection object. Loads the embedded driver,
 * starts and connects to the database using the connection URL.
 */
// // public static Connection createDatabaseConnection()
// //         throws SQLException, ClassNotFoundException {
// //     String driver = "org.apache.derby.jdbc.EmbeddedDriver";
// //     Class.forName(driver);
// //     String url = "jdbc:derby:FOADB";
// //     Connection c = DriverManager.getConnection(url+";create=true");
// //     return c;
// //         }
// //     }

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



