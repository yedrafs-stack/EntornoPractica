package es.studium;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class Informacion
{
	Frame ventana = new Frame("Información de Eventos");
	Choice choInfo = new Choice();
	Button btnInfo = new Button("Mostrar informacion");
	Label lblNombre = new Label("");
	Label lblDescripcion = new Label("");
	Label lblFecha = new Label("");
	Label lblHorario = new Label("");
	Label lblUbicacion = new Label("");
	
	public Informacion()
	{
		ventana.setLayout(new FlowLayout());
		ventana.setSize(275,210);
		ventana.add(choInfo);
		ventana.add(btnInfo);
		ventana.add(lblNombre);
		ventana.add(lblDescripcion);
		ventana.add(lblFecha);
		ventana.add(lblHorario);
		ventana.add(lblUbicacion);

		ventana.setResizable(true);		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}
}
