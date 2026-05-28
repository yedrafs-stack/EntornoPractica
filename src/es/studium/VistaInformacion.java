package es.studium;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class VistaInformacion
{
	Frame ventana = new Frame("Información de Eventos");
	Choice choiceInfo = new Choice();
	Button btnChoice = new Button("Mostrar informacion");
	Label lblNombre = new Label("DreamHack");
	Label lblDescripcion = new Label("");
	Label lblFecha = new Label("");
	Label lblHorario = new Label("");
	Label lblUbicacion = new Label("");
	
	public VistaInformacion()
	{
		ventana.setLayout(new FlowLayout());
		
		ventana.add(choiceInfo);
		ventana.add(btnChoice);
		ventana.add(lblNombre);
		ventana.add(lblDescripcion);
		ventana.add(lblFecha);
		ventana.add(lblHorario);
		ventana.add(lblUbicacion);

		ventana.setVisible(true);
		ventana.setSize(800,600);
		ventana.setResizable(false);		
		ventana.setLocationRelativeTo(null);
		

	}
}
