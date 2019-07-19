package libro.cap05;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ChatSwing extends JFrame{
	
	private JTextField tfNick;
	private JTextField tfMensaje;
	private JButton bLogin;
	private JButton bLogout;
	private JButton bEnviar;
	private JList lstLog;
	
	private Border border;
	
	public ChatSwing() {
		super("Chat");
		
		// pedimos el panel de contención al JFrame
		Container content = getContentPane();
		
		// seteamos el layout
		content.setLayout(new BorderLayout());
		
		// este sera ek tipo de borde que 
		// utilizaremos en todos los paneles
		border  = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		// creamos el panel norte
		JPanel pNorth = _crearNorte();
		content.add(pNorth, BorderLayout.NORTH);
		
		// creamos el panel central
		JPanel pCenter = _crearCenter();
		content.add(pCenter, BorderLayout.CENTER);
		
		// creamos el panel sur
		JPanel pSouth = _crearSur();
		content.add(pSouth, BorderLayout.SOUTH);
		
		setSize(400, 300);
		setVisible(true);		
	}
	
	private JPanel _crearNorte() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		// instancio un TitledRorder  con el titulo y el objeto border
		// que cree en el constructor
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Nick");
		
		// asigno el titledBorder al panel
		p.setBorder(titleBorder);
		
		tfNick = new JTextField(10);
		p.add(tfNick);
		
		bLogin = new JButton("Login");
		p.add(bLogin);
		
		bLogout = new JButton("Logout");
		p.add(bLogout);
		
		return p;
	}
	
	private JPanel _crearCenter() {
		JPanel p = new JPanel(new BorderLayout());
		
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Conversacion");
		
		p.setBorder(titleBorder);
		
		lstLog = new JList();
		JScrollPane scroll = new JScrollPane(lstLog);
		p.add(scroll, BorderLayout.CENTER);
		
		return p;
	}
	
	private JPanel _crearSur() {
		JPanel p = new JPanel();
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Mensaje");
		p.setBorder(titleBorder);
		
		tfMensaje = new JTextField();
		p.add(tfMensaje, BorderLayout.CENTER);
		
		bEnviar = new JButton("Enviar");
		p.add(bEnviar, BorderLayout.EAST);
		
		return p;
	}
	
	public static void main(String[] args) throws Exception{
		// UIManager.setLookAndFeel(new LookAndFeel());
		ChatSwing c = new ChatSwing();
	}
}
