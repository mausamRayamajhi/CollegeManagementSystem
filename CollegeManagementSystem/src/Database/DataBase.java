package Database;

import java.sql.Connection;

public class DataBase
{
  private static Connection con;
  
  public DataBase() {}
  
  public Connection Connect_To_Database() throws Exception {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/cms";
      con = (Connection)java.sql.DriverManager.getConnection(url, "root", "");
      return con;
    }
    catch (ClassNotFoundException e) {
      throw new Exception("Driver not found");
    }
  }
}
