package es.studium;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class Agradecimiento
{
	Frame ventana = new Frame("Final");
	Label lblMensaje = new Label("Gracias por su compra.");
	Button btnAcpetar = new Button("Aceptar");
	
	public Agradecimiento()
	{
		ventana.setLayout(new FlowLayout());
		ventana.setSize(275,210);
		
		ventana.add(lblMensaje);
		ventana.add(btnAcpetar);

		ventana.setResizable(true);		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

}
