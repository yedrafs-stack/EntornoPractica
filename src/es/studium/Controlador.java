package es.studium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Controlador extends WindowAdapter implements ActionListener, KeyListener
{
	// clases
	Modelo modelo;
	VistaMenuPrincipal vistaMP;
	VistaInformacion vistaInfo;
	VistaTicket vistaTicket;
	VistaConfirmacion vistaConfi;
	VistaAgradecimiento vistaFinal;

	// variables de control
	ArrayList<String> alNEventos = new ArrayList<>();
	ArrayList<String> alInfoEventos = new ArrayList<>();
	ArrayList<String> alInfoTarifas = new ArrayList<>();
	
	int tipoConsulta;
	int tipoConsultaReferencia;
	int referencia;
	int tipoChoice;

	public Controlador(Modelo modelo, VistaMenuPrincipal vistaMP)
	{
		this.modelo = modelo;
		this.vistaMP = vistaMP;

		this.vistaMP.ventana.addWindowListener(this);
		this.vistaMP.btnInfo.addActionListener(this);
		this.vistaMP.btnTicket.addActionListener(this);
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public void keyPressed(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void actionPerformed(ActionEvent e)
	{
		if (vistaMP != null)
		{
			if (e.getSource().equals(vistaMP.btnInfo))
			{
				this.vistaInfo = new VistaInformacion();
				this.vistaInfo.ventana.addWindowListener(this);
				this.vistaInfo.btnChoice.addActionListener(this);
				tipoConsulta = 1;
				alNEventos = modelo.consultarBD(tipoConsulta);
				tipoChoice = 1;
				rellenarChoice();
				vistaMP.ventana.setVisible(false);
			} 
			
			else if (e.getSource().equals(vistaMP.btnTicket))
			{

			}
		}
		
		if(vistaInfo != null)
		{
			if (e.getSource().equals(vistaInfo.btnChoice) && vistaInfo.choiceInfo.getSelectedIndex() > 0)
			{
				tipoConsultaReferencia = 1;
				referencia = vistaInfo.choiceInfo.getSelectedIndex();
				alInfoEventos = modelo.consultarBDReferencia(tipoConsultaReferencia, referencia);
				
				//tipoConsultaReferencia = 2;
				//referencia = vistaInfo.choiceInfo.getSelectedIndex();
				//alInfoTarifas = modelo.consultarBDReferencia(tipoConsultaReferencia, referencia);
				vistaInfo.lblNombre.setText(alInfoEventos.get(0).split(" - ")[1]);
				vistaInfo.lblDescripcion.setText(alInfoEventos.get(0).split(" - ")[2]);
				vistaInfo.lblUbicacion.setText(alInfoEventos.get(0).split(" - ")[3]);
				vistaInfo.lblUbicacion.setSize(vistaInfo.lblUbicacion.getPreferredSize());
			}
		}

	}

	public void windowClosing(WindowEvent e)
	{
		if (vistaMP != null && e.getSource().equals(vistaMP.ventana))
		{
			System.exit(0);
		} 
		
		else if (vistaInfo != null && e.getSource().equals(vistaInfo.ventana))
		{
			vistaMP.ventana.setVisible(true);
			vistaInfo.ventana.dispose();
		}
	}
	
	public void rellenarChoice()
	{
		if(tipoChoice == 1)
		{
			vistaInfo.choiceInfo.add("Selecciona un Evento");
			for(int i = 0; i < alNEventos.size(); i++ )
			{
				vistaInfo.choiceInfo.add(alNEventos.get(i).split(" - ")[1]);
			}
		}
		
	}

}
