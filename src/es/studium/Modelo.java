package es.studium;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/eventoTicket";
	String login = "entorno";
	String password = "Studium2025#";
	String sentenciaSQL = "";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	
	public Modelo()
	{
		try
		{
			Class.forName(driver);
		}	
		catch (ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		
	}
}
