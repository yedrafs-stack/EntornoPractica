package es.studium;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Informacion
{
	Frame ventana = new Frame("Información de Eventos");
	Choice choInfo = new Choice();
	
	public Informacion()
	{
		ventana.setLayout(new FlowLayout());
		ventana.setSize(275,210);
		
		choInfo.add("Selecciona un Evento");
		ventana.add(choInfo);

		ventana.setResizable(true);		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}
}
