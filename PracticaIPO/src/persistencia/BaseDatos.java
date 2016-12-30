package persistencia;

import java.sql.*;

public class BaseDatos {
	private Connection conexion;
    public Connection getConexion(){
        return conexion;        
    }
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
    public boolean conectar() {
    	boolean conectado = false;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String bd = "jdbc:mysql://localhost:3307/ipo?user=root&password=root";
            setConexion(DriverManager.getConnection(bd));
            if(getConexion() != null){
                conectado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conectado;
    }
    
    public boolean executeUpdate(String s){
    	try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(s);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
       return true;
    }
    
    public ResultSet consultar(String s){
    	ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(s);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultado;
    }
}
