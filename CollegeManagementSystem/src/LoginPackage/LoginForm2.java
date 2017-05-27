package LoginPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import GUI.MainFrame;
import Methods.AllMethod;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;


public class LoginForm2 extends JFrame
{
	
  private JPanel contentPane;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private AllMethod function;
  private int indexOfSelectedIteam;
  private JCheckBox checkBox;
  private Preferences pref;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LoginForm2 frame = new LoginForm2();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  


  public LoginForm2()
  {
	  // this is logiform2 constructor
	  // next line
    function = new AllMethod();
    pref = Preferences.userRoot().node("RememberMe");
    try {
      UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
    }
    catch (Exception localException) {}
    
    setIconImage(Toolkit.getDefaultToolkit()
      .getImage("E:\\eclipse workspace\\CollegeManagementSystem\\src\\Icons\\staff16.png"));
    setResizable(false);
    setTitle("Login");
    setDefaultCloseOperation(3);
    setBounds(380, 150, 715, 374);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    JLabel label = new JLabel("");
    label.setBorder(null);
    label.setIcon(new ImageIcon("E:\\eclipse workspace\\CollegeManagementSystem\\src\\Icons\\001.jpg"));
    contentPane.add(label, "North");
    
    JPanel panel = new JPanel();
    panel.setBorder(new EtchedBorder(0, null, null));
    contentPane.add(panel, "Center");
    panel.setLayout(null);
    
    JLabel lblSelect = new JLabel("Select :");
    lblSelect.setFont(new Font("Tahoma", 0, 16));
    lblSelect.setBounds(214, 22, 61, 24);
    panel.add(lblSelect);
    
    final JComboBox comboBox = new JComboBox();
    comboBox.setModel(new DefaultComboBoxModel(
      new String[] { "--- Select One ---", "Admin", "Teacher", "Student", "Other Staff" }));
    comboBox.setBounds(275, 23, 194, 24);
    panel.add(comboBox);
    
    JLabel lblUsername = new JLabel("Username :");
    lblUsername.setFont(new Font("Tahoma", 0, 16));
    lblUsername.setBounds(184, 57, 91, 24);
    panel.add(lblUsername);
    
    usernameField = new JTextField();
    usernameField.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
    usernameField.setBounds(273, 57, 196, 24);
    panel.add(usernameField);
    usernameField.setColumns(10);
    usernameField.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {
          LoginForm2.this.validationOfEntry(comboBox);
        }
        
      }
    });
    JLabel lblPassword = new JLabel("Password :");
    lblPassword.setFont(new Font("Tahoma", 0, 16));
    lblPassword.setBounds(187, 92, 91, 24);
    panel.add(lblPassword);
    
    checkBox = new JCheckBox("Remember Me");
    checkBox.setBounds(275, 125, 138, 23);
    panel.add(checkBox);
    
    JButton btnLogin = new JButton("Login");
    btnLogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LoginForm2.this.validationOfEntry(comboBox);
      }
      

    });
    btnLogin.setIcon(new ImageIcon("E:\\eclipse workspace\\CollegeManagementSystem\\src\\Icons\\log.png"));
    btnLogin.setBounds(275, 158, 115, 35);
    panel.add(btnLogin);
    
    passwordField = new JPasswordField();
    passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
    passwordField.setBounds(275, 92, 194, 24);
    panel.add(passwordField);
    

    String uname = pref.get("username", "");
    String password = pref.get("password", "");
    String index = pref.get("indexx", "");
    usernameField.setText(uname);
    passwordField.setText(password);
    comboBox.setSelectedIndex(Integer.parseInt(index));
    
    final JLabel clearLabel = new JLabel("clear");
    clearLabel.setBorder(null);
    clearLabel.setFont(new Font("Tahoma", 0, 11));
    clearLabel.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent arg0) {
        pref.put("username", "");
        pref.put("password", "");
        pref.putInt("indexx", 0);
        JOptionPane.showMessageDialog(null, "Cleared Filed ");
        usernameField.setText("");
        passwordField.setText("");
        comboBox.setSelectedIndex(0);
      }
      
      public void mouseEntered(MouseEvent e) {
        clearLabel.setForeground(Color.BLUE);
        clearLabel.setFont(new Font("Tahoma", 0, 15));
      }
      
      public void mouseExited(MouseEvent e)
      {
        clearLabel.setForeground(Color.BLACK);
        clearLabel.setFont(new Font("Tahoma", 0, 11));
      }
      
    });
    clearLabel.setHorizontalAlignment(0);
    clearLabel.setBounds(643, 179, 46, 14);
    panel.add(clearLabel);
    

    passwordField.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {
          LoginForm2.this.validationOfEntry(comboBox);
        }
      }
    });
  }
  
  // validation for GUI login fields
  private void validationOfEntry(JComboBox comboBox) {
    indexOfSelectedIteam = comboBox.getSelectedIndex();
    
    if (function.loginSelectionIndexValidation(indexOfSelectedIteam).booleanValue()) {
      if (usernameField.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Username must be entered");
      } else if (String.valueOf(passwordField.getPassword()).equals("")) {
        JOptionPane.showMessageDialog(null, "Password must be entered");
      } else if (function.login(indexOfSelectedIteam, usernameField, passwordField).booleanValue()) {
        MainFrame window = new MainFrame();
       window.frame.setVisible(true);
        if (checkBox.isSelected()) {
          int index = comboBox.getSelectedIndex();
          String username = usernameField.getText();
          char[] password = passwordField.getPassword();
          pref.put("username", username);
          pref.put("password", String.valueOf(password));
          pref.putInt("indexx", index);
        }
        
        dispose();
      }
    }
  }
}
