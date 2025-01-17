package bookConten;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GraIterface.adminAddUser;
import bookSQL.txSQL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



public class changeBook extends JFrame {
	String theTitle="修改图书";
	String theWord="修改添加";
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminAddUser frame = new adminAddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public changeBook() {
		setTitle(theTitle);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(115, 31, 171, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7D22\u4E66\u53F7");
		lblNewLabel.setBounds(57, 30, 48, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D");
		lblNewLabel_1.setBounds(57, 82, 48, 30);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 83, 171, 30);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5269\u4F59\u672C\u6570");
		lblNewLabel_1_1.setBounds(57, 133, 48, 30);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 134, 171, 30);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton(theWord);
//添加时间响应----------------------------------------------------------
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=textField.getText();
				String password=textField_1.getText();
				String identity=textField_2.getText();
				try {
					txSQL ver = new txSQL();
				    ver.addrow(userName, password,identity,"UPDATE user SET identity='"+password+"' WHERE user_name='"+userName+"';");
				    JOptionPane.showMessageDialog(null, "修改成功！");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(49, 179, 266, 23);
		contentPane.add(btnNewButton);
	}

}