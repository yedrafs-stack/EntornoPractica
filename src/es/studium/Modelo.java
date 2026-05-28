package es.studium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/eventosGaming";
	String user = "userEventosGaming";
	String password = "Studium2025#";
	String sentenciaSQL = "";

	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public Modelo()
	{
		try
		{
			Class.forName(driver);
		} catch (ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}

	}

	public ArrayList<String> consultarBD(int tipoConsulta)
	{
		ArrayList<String> arrayList = new ArrayList<>();

		try
		{
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			if (tipoConsulta == 1)
			{
				sentenciaSQL = "select * from eventos";
				resultSet = statement.executeQuery(sentenciaSQL);
				while (resultSet.next())
				{
					String linea = resultSet.getString("idEvento") + " - " + resultSet.getString("nombreEvento") + " - "
							+ resultSet.getString("descripcionEvento") + " - " + resultSet.getString("ubicacionEvento");
					arrayList.add(linea);
				}
			}
		}

		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}

		return arrayList;
	}

	public ArrayList<String> consultarBDReferencia(int tipoConsultaReferencia, int referencia)
	{
		ArrayList<String> arrayList = new ArrayList<>();
		try
		{
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			if(tipoConsultaReferencia == 1)
			{
				sentenciaSQL = "select * from eventos where idEvento = " + referencia;
				resultSet = statement.executeQuery(sentenciaSQL);
				while (resultSet.next())
				{
					String linea = resultSet.getString("idEvento") + " - " + resultSet.getString("nombreEvento") + " - "
							+ resultSet.getString("descripcionEvento") + " - " + resultSet.getString("ubicacionEvento");
					arrayList.add(linea);
				}
			}
			
			/*
			else if(tipoConsultaReferencia == 2)
			sentenciaSQL = "select idHorarioFK, date_format(inicioHorario, '%d/%m/%Y %H:%i:%s') as 'Inicio',  date_format(finHorario, '%d/%m/%Y %H:%i:%s') as 'Fin', nombreCategoria, precioTarifa, stockTarifa from categorias join tarifas on tarifas.idCategoriaFK = categorias.idCategoria join horarios on tarifas.idHorarioFK = horarios.idHorario where idEventoFK = " + referencia;
			resultSet = statement.executeQuery(sentenciaSQL);
			while (resultSet.next())
			{
				String linea = resultSet.getString("idHorarioFK") + " - " + resultSet.getString("Inicio") + " - " + resultSet.getString("Fin") + " - " + resultSet.getString("nombreCategoria") + " - " + resultSet.getString("precioTarifa") + " - " + resultSet.getString("stockTarifa");
				arrayList.add(linea);
			}
*/
		}

		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		return arrayList;
	}
}
