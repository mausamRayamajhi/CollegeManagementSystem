package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MainFrame {

	public JFrame frmCollegeManagementSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmCollegeManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} catch (Exception e) {
			// TODO: handle exception
		}
		frmCollegeManagementSystem = new JFrame();
		frmCollegeManagementSystem.setTitle("College Management System");
		frmCollegeManagementSystem
				.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/Icons/cms_icon.png")));
		frmCollegeManagementSystem.setBounds(100, 100, 828, 470);
		frmCollegeManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/Banner/School management System 01.jpg")));
		frmCollegeManagementSystem.getContentPane().add(label, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		frmCollegeManagementSystem.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblAtten = new JLabel("OVERVIEW");
		lblAtten.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblAtten.setIconTextGap(13);
		lblAtten.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/icon/Home_16px.png")));
		lblAtten.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtten.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtten.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAtten = new GridBagConstraints();
		gbc_lblAtten.fill = GridBagConstraints.BOTH;
		gbc_lblAtten.insets = new Insets(10, 10, 5, 0);
		gbc_lblAtten.gridx = 0;
		gbc_lblAtten.gridy = 0;
		panel_1.add(lblAtten, gbc_lblAtten);
		
		lblAtten.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
		});

		JLabel lblAttendence = new JLabel("ATTENDENCE");
		lblAttendence.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblAttendence.setIconTextGap(13);
		lblAttendence.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/icon/Sheet of Paper_16px_1.png")));
		lblAttendence.setHorizontalAlignment(SwingConstants.LEFT);
		lblAttendence.setForeground(Color.WHITE);
		lblAttendence.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAttendence = new GridBagConstraints();
		gbc_lblAttendence.insets = new Insets(10, 10, 5, 0);
		gbc_lblAttendence.gridx = 0;
		gbc_lblAttendence.gridy = 1;
		panel_1.add(lblAttendence, gbc_lblAttendence);

		JLabel lblStudents = new JLabel("STUDENTS");
		lblStudents.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblStudents.setIconTextGap(13);
		lblStudents.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/icon/Student Male_16px.png")));
		lblStudents.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudents.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblStudents = new GridBagConstraints();
		gbc_lblStudents.anchor = GridBagConstraints.WEST;
		gbc_lblStudents.insets = new Insets(10, 10, 5, 0);
		gbc_lblStudents.gridx = 0;
		gbc_lblStudents.gridy = 2;
		panel_1.add(lblStudents, gbc_lblStudents);
		
		JLabel lblTeachers = new JLabel("TEACHERS");
		lblTeachers.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblTeachers.setIconTextGap(13);
		lblTeachers.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/icon/Singing Teacher_16px.png")));
		lblTeachers.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeachers.setForeground(Color.WHITE);
		lblTeachers.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTeachers = new GridBagConstraints();
		gbc_lblTeachers.anchor = GridBagConstraints.WEST;
		gbc_lblTeachers.insets = new Insets(10, 10, 5, 0);
		gbc_lblTeachers.gridx = 0;
		gbc_lblTeachers.gridy = 3;
		panel_1.add(lblTeachers, gbc_lblTeachers);
	}

}
