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
	Modelo modelo;
	MenuPrincipal vistaMP;
	Informacion vistaInfo;
	Ticket vistaTicket;
	Confirmacion vistaConfi;
	Agradecimiento vistaFinal;
	
	ArrayList<String> tabla = new ArrayList<>();

	public Controlador(Modelo modelo, MenuPrincipal vistaMP)
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
		if(vistaMP != null)
		{
			if(e.getSource().equals(vistaMP.btnInfo))
			{
				this.vistaInfo= new Informacion();//PARA QUE SE ABRA LA VENTANA
				this.vistaInfo.ventana.addWindowListener(this);
				vistaMP.ventana.setVisible(false);//PARA QUE SE CIERRE LA OTRA
				int choiceEvento = 1;
				tabla = modelo.obtenerTabla(choiceEvento);
				System.out.println(tabla.get(0)); 
			}
			else if(e.getSource().equals(vistaMP.btnTicket))
			{
				
			}
		}
		
	}

	public void windowClosing(WindowEvent e)
	{
		if(vistaMP != null && e.getSource().equals(vistaMP.ventana))
		{
			System.exit(0);
		}
		else if(vistaInfo != null && e.getSource().equals(vistaInfo.ventana))
		{
			vistaMP.ventana.setVisible(true);
			vistaInfo.ventana.dispose();
		}
	}

}
