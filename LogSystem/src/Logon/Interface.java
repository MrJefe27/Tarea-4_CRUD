package Logon;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import App.Aplicacion;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.UIManager;

public class Interface {

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JFrame frmLoginSystem;

	

	/**
	 * Lanzar aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializar la aplicacion.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Inicializar los componentes del formulario
	 */
	private void initialize() {
		frmLogin =new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(new Color(0, 102, 255));
		frmLogin.setForeground(new Color(149, 189, 255));
		frmLogin.getContentPane().setForeground(new Color(149, 189, 255));
		frmLogin.getContentPane().setFont(new Font("Georgia", Font.BOLD, 17));
		frmLogin.setBounds(200, 200, 583, 350);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 51, 102));
		panel.setBounds(10, 11, 544, 291);
		panel.setBackground(new Color(255, 255, 255));
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesion");
		lblNewLabel.setBounds(133, 76, 265, 44);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setBorder(null);
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 38));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(216, -14, 100, 100);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\cpeguero\\eclipse-workspace\\LogSystem\\src\\Logon\\icon1.png"));
		
		JLabel lblNewLabel_3 = new JLabel("¿No tienes una cuenta?, registrate aqui!! -> -->");
		lblNewLabel_3.setBounds(41, 224, 339, 17);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setFont(new Font("Georgia", Font.BOLD, 14));
		
		JButton btnNewButton_3 = new JButton("Registarse");
		btnNewButton_3.setBounds(401, 212, 113, 29);
		panel.add(btnNewButton_3);
		btnNewButton_3.setBackground(new Color(0, 102, 255));
		btnNewButton_3.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener((ActionEvent e) -> {
                    Registro log = new Registro();
                    Registro.main(null);
                });
		btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 15));
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(401, 251, 113, 29);
		panel.add(btnNewButton_2);
		btnNewButton_2.setBackground(new Color(0, 102, 255));
		btnNewButton_2.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(41, 181, 106, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(51, 51, 51));
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 17));
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(167, 174, 201, 26);
		panel.add(txtPassword);
		txtPassword.setFont(new Font("Georgia", Font.PLAIN, 12));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(401, 172, 113, 29);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(0, 102, 255));
		btnNewButton_1.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(401, 135, 113, 29);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 15));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(167, 137, 201, 26);
		panel.add(txtUsername);
		txtUsername.setFont(new Font("Georgia", Font.PLAIN, 12));
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(41, 138, 73, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {	
				
				try {
					//Inicar la conexion a mysql
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false","root","12345678");
					
					String username = txtUsername.getText();
					@SuppressWarnings("deprecation")
					String password = txtPassword.getText();
					
						java.sql.Statement stm = con.createStatement();
						
						String sql = "SELECT * FROM user where Usuario='"+username+"' and Clave= '"+password+"'";
						ResultSet rs = stm.executeQuery(sql);
						
						if(rs.next()) {
							//Si el usuario y la contrase;a son correctos, entonces lanza un mensaje
														
							dispose();
							JOptionPane.showMessageDialog(null, "Bienvenido "+username);
							Aplicacion log = new Aplicacion();
							Aplicacion.main(null);
							
						}else {
							//Si el usuario y la contrase;a son incorrectos, lanza este msj
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
							txtUsername.setText("");
							txtPassword.setText("");
							
						}
						
						con.close();	
						
				} catch (HeadlessException | ClassNotFoundException | InstantiationException | SQLException e1) {
					System.out.println(e1.getMessage());
				}
				
			}

			private void dispose() { }
			
		});
		btnNewButton_1.addActionListener((ActionEvent e) -> {
                    txtUsername.setText("");
                    txtPassword.setText("");
                } /*
                 * Limpiar las cintas de texto
                 * */ );
		btnNewButton_2.addActionListener((ActionEvent e) -> {
                    /*
                    * Funcionalidad para cerrar la apliacion.
                    * */
                    frmLoginSystem = new JFrame("Salir");
                    if (JOptionPane.showConfirmDialog(frmLoginSystem, "¿Seguro que quieres salir?","Login Systems",
                            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                        System.exit(0);
                    }
                });
	}
}
