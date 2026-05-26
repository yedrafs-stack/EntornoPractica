package es.studium;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class MenuPrincipal
{
	Frame ventana = new Frame("E-Sport");
	
	Button btnInfo = new Button("Infomación de Eventos");
	Button btnTicket = new Button("Sacar Ticket");
	
	public MenuPrincipal()
	{
		ventana.setLayout(new FlowLayout());
		ventana.setSize(350, 200);

		ventana.add(btnInfo);
		ventana.add(btnTicket);
		
		ventana.setResizable(true);		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
