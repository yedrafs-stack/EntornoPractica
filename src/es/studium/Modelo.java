package es.studium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modelo
{
	String url = "jdbc:mysql://localhost:3306/eventoTicket";
	String driver = "com.mysql.cj.jdbc.Driver";
	String login = "entorno";
	String password = "Studium2025#";
	String sentenciaSQL = "";
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
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
	
	public ArrayList<String> obtenerTabla(int tipoChoice)
	{
		ArrayList<String> array = new ArrayList<>();
		try
		{
			connection = DriverManager.getConnection(url, driver, password);
			
			if(tipoChoice == 1)
			{
				sentenciaSQL = "select * from eventos";
				preparedStatement = connection.prepareStatement(sentenciaSQL);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next())
				{
					array.add(resultSet.getString("idEvento") + " - " + resultSet.getString("nombreEvento") + " - " + resultSet.getString("descripcionEvento") + " - " + resultSet.getString("fechaEvento") + " - " + resultSet.getString("horarioEvento") + " - " + resultSet.getString("ubicacionEvento"));
				}
			}
		}
		
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		return array;
	}
}
