import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class Conexion {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
	// lista de objetos que devolveran los resultados 
		List<Curso>listaDeCursos = new ArrayList<Curso>();
	// conexion a la base de datos y ejecucion de la sentencia
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	
	//Class.forName("com.mysql.jdbc.Driver"); Driver para MySQL
	Connection conexion = null;
	
	
	String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1"; //Caso Oracle
	String urlMySQL = "jdbc:mysql://localhost:3306/basedatos"; // Caso MySQL
	String urlPG = "jdbc:postgresql://localhost:5432/basedatos"; //Caso PostgreSQL
	conexion = DriverManager.getConnection(url, "JIOH", "1160");
	try {
	// Creacion de la tabla e inserccion de datos 
		Statement st = conexion.createStatement();
	//st.executeUpdate("DROP TABLE CURSOS"); //descomentar si la tabla
	
	st.executeQuery("CREATE TABLE DEPARTAMENTO ( NUMDEPTO NUMBER PRIMARY KEY NOT NULL, NOMDEPTO VARCHAR(100), UBICACIONDPTO VARCHAR(100))"); 
	st.executeQuery("INSERT INTO DEPARTAMENTO VALUES(1,'INFORMATICA', 'Chile')");
	st.executeQuery("INSERT INTO DEPARTAMENTO VALUES(2,'REDES', 'Chile')");
	st.executeQuery("INSERT INTO DEPARTAMENTO VALUES(3,'PARTES', 'Chile')");
	st.executeQuery("INSERT INTO DEPARTAMENTO VALUES(4,'SALUD', 'Chile')");
	// consulta a la base de datos 
	st = conexion.createStatement();
	ResultSet resultado = st.executeQuery("SELECT * FROM DEPARTAMENTO");
//	while (resultado.next()) {
//		Curso curso = new Curso();
//		curso.setId(resultado.getInt("id"));
//		curso.setNombre(resultado.getString("nombre"));
//		listaDeCursos.add(curso);	
//		}
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	// se imprime la lista de cursos obtenida de la consulta
	System.out.println(listaDeCursos);
	}
}
