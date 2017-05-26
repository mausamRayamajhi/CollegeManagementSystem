package Methods;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import Database.DataBase;


public class AllMethod
{
  private Connection conn;
  private DataBase db;
  private PreparedStatement pst;
  private ResultSet rs;
  private String sql;
  
  public AllMethod() {}
  
  public Boolean login(int indexOfSelectedIteam, JTextField usernameField, JPasswordField passwordField)
  {
    db = new DataBase();
    String tableName = null;
    String userName = null;
    String password = null;
    try {
      if (indexOfSelectedIteam == 1) {
        tableName = "admin";
        userName = "admin_username";
        password = "admin_password";
      } else if (indexOfSelectedIteam == 2) {
        tableName = "teacher";
        userName = "admin_username";
        password = "admin_password";
      }
      else if (indexOfSelectedIteam == 3) {
        tableName = "student";
        userName = "admin_username";
        password = "admin_password";
      }
      else if (indexOfSelectedIteam == 4) {
        tableName = "otherStaff";
        userName = "admin_username";
        password = "admin_password";
      }
      
      conn = (Connection) db.Connect_To_Database();
      String name = usernameField.getText();
      char[] pass = passwordField.getPassword();
      sql = ("SELECT COUNT(*) AS rowcount FROM " + tableName + " where BINARY " + userName + "=? and BINARY " + password + "=?");
      pst = conn.prepareStatement(sql);
      pst.setString(1, name);
      pst.setString(2, String.valueOf(pass));
      rs = pst.executeQuery();
      rs.next();
      int count = rs.getInt("rowcount");
      if (count == 1) {
        JOptionPane.showMessageDialog(null, "Sucessfull");
        return Boolean.valueOf(true);
      }
      JOptionPane.showMessageDialog(null, "Username or Password is Incorrect");
      return Boolean.valueOf(false);

    }
    catch (Exception e)
    {

      e.printStackTrace();
    }
    return null;
  }
  

  public Boolean loginSelectionIndexValidation(int indexOfSelectedIteam)
  {
    if (indexOfSelectedIteam < 1) {
      JOptionPane.showMessageDialog(null, "Selection is not done.");
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public String hashing(String input) {
    try {
      MessageDigest mgd = MessageDigest.getInstance("MD5");
      byte[] messageDigest = mgd.digest(input.getBytes());
      BigInteger number = new BigInteger(1, messageDigest);
      String hashtext = number.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
