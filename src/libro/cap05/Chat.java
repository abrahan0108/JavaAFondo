package libro.cap05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;

public class Chat extends Frame{
	private TextField tfNick;
	private TextField tfMensaje;
	private Button bLogin;
	private Button bLogout;
	private Button bEnviar;
	private List lstLog;
	
	public Chat() {
		super("Chat");
		setLayout(new BorderLayout());
		
		// panel Norte
		Panel pNorth = _crearPNorte();
		add(pNorth, BorderLayout.NORTH);
		
		// panel central
		Panel pCenter = _crearPCenter();
		add(pCenter, BorderLayout.CENTER);
		
		// panel sur
		Panel pSouth = _crearPSur();
		add(pSouth, BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
	}
	
	private Panel _crearPNorte() {
		Panel p = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		p.add(new Label("Nick:"));
		
		tfNick = new TextField(10);
		p.add(tfNick);
		
		bLogin = new Button("Login");
		p.add(bLogin);
		
		bLogout = new Button("Logout");
		p.add(bLogout);
		
		return p;
	}
	
	private Panel _crearPCenter() {
		Panel p = new Panel(new BorderLayout());
		
		// Norte
		p.add(new Label("Conversación:"), BorderLayout.NORTH);
		
		// Centro
		lstLog = new List();
		p.add(lstLog, BorderLayout.CENTER);
		
		return p;
	}
	
	private Panel _crearPSur() {
		Panel p = new Panel(new BorderLayout());
		
		// oeste
		p.add(new Label("Mensaje"), BorderLayout.WEST);
		
		// centro
		tfMensaje = new TextField();
		p.add(tfMensaje, BorderLayout.CENTER);
		
		// Este
		bEnviar = new Button("Enviar");
		p.add(bEnviar, BorderLayout.EAST);
		
		return p;
	}
	
	public static void main(String[] args) {
		Chat c = new Chat(); 
	}

}
