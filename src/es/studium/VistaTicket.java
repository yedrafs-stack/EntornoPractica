package es.studium;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class VistaTicket
{
	Frame ventana = new Frame("Información de Eventos");
	Choice choEvento = new Choice();
	Label lblNom = new Label("Nombre");
	TextField txtNom = new TextField(10);
	Label lblApellido= new Label("Apellidos");
	TextField txtApellido = new TextField(10);
	Label lblDni= new Label("Dni");
	TextField txtDni = new TextField(10);
	Label lblDireccion= new Label("Dirección");
	TextField txtDireccion = new TextField(10);
	Choice choCantidad = new Choice();
	Choice choTicket = new Choice();
	Button btnContinuar = new Button("Continuar");


	
	public VistaTicket()
	{
		ventana.setLayout(new FlowLayout());
		ventana.setSize(275,210);
		
		choEvento.add("Selecciona un Evento");
		ventana.add(choEvento);
		ventana.add(lblNom);
		ventana.add(txtNom);
		ventana.add(lblApellido);
		ventana.add(txtApellido);
		ventana.add(lblDni);
		ventana.add(txtDni);
		ventana.add(lblDireccion);
		ventana.add(txtDireccion);
		choCantidad.add("Cantidad de tickets");
		ventana.add(choCantidad);
		choTicket.add("Tipo de ticket");
		ventana.add(choTicket);
		ventana.add(btnContinuar);



		ventana.setResizable(true);		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}
}
