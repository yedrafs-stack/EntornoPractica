package es.studium;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class VistaConfirmacion
{
	Frame ventana = new Frame("Confirmación de Facturas");
	Label lblResumen = new Label("Resumen del evento seleccionado:");
	Label lblDatos = new Label("Datos del solicitante ingresados:");
	Label lblTipoTicket = new Label("Tipo de Ticket:");
	Label lblCalculo = new Label("Cálculo Total:");
	Button btnPago = new Button("Confirmar y Pagar");
	Button btnCancelar = new Button("Cancelar");

	public VistaConfirmacion()
	{
		ventana.setLayout(new FlowLayout());
		ventana.setSize(275,210);
		
		ventana.add(lblResumen);
		ventana.add(lblDatos);
		ventana.add(lblTipoTicket);
		ventana.add(lblCalculo);

		ventana.setResizable(true);		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
