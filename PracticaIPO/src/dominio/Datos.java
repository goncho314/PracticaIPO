package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.BaseDatos;

public class Datos {
	BaseDatos bd = new BaseDatos();
	private String usuario;
	public Datos(){
		bd.conectar();		
	}
	public Boolean comprobarLogin(String usuario, String password) throws SQLException{
		boolean b = false;
		ResultSet rs;
		String sentencia = "SELECT usuario FROM login WHERE usuario='"+usuario+"' AND contrasena='"+password+"'";
		rs = bd.consultar(sentencia);
		if (rs.next())
			b = true;
		return b;
	}
	
	public void setUsuario(String s){
		this.usuario = s;
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	public String getInfoMedico() throws SQLException{
		ResultSet rs;
		String s = "";
		String sentencia = "select m.nombre, m.especialidad, DATE_FORMAT(l.ultimo_acceso, '%d/%m/%Y %k:%i:%s') as ultimo from medicos m, login l where m.id=l.doctor and l.usuario='"+this.usuario+"'";
		rs = bd.consultar(sentencia);
		if(rs.next())		
				s="<html><body>"+rs.getString("nombre")+"<br>"+ rs.getString("especialidad")+"<br>Último acceso:<br>"+rs.getString("ultimo")+"</body></html>";
		return s;
	}
	
	public String getFotoMedico() throws SQLException{
		ResultSet rs;
		String sentencia = "SELECT foto FROM medicos WHERE id = (SELECT doctor FROM login WHERE usuario='"+this.usuario+"')";
		String ruta = "";
		rs = bd.consultar(sentencia);
		if(rs.next())
			ruta = rs.getString("foto");
		return ruta;
	}
	
	public String getFotoPaciente(String nombre) throws SQLException{		
		ResultSet rs;
		String sentencia = "SELECT foto FROM pacientes WHERE nombre = '"+nombre+"'";
		String ruta = "";
		rs = bd.consultar(sentencia);
		if(rs.next())
			ruta = rs.getString("foto");
		return ruta;
	}
	
	public ArrayList<String> getDiasCitas(int mes, int year) throws SQLException{
		ResultSet rs;
		ArrayList<String> dias = new ArrayList<String>();
		String sentencia = "SELECT day(c.fecha) dia FROM citas c, medicos m, login l WHERE c.doctor=m.id AND m.id=l.doctor AND month(c.fecha)="+mes+" AND year(c.fecha)="+year+" AND l.usuario='"+this.usuario+"' GROUP BY c.fecha order by c.fecha";
		rs = bd.consultar(sentencia);
		while(rs.next())
			dias.add(rs.getString("dia"));
		return dias;
	}
	
	public ArrayList<String> getCitasDia(int dia, int mes, int year) throws SQLException{
		ResultSet rs;
		ArrayList<String> citas = new ArrayList<String>();
		String sentencia = "SELECT TIME_FORMAT(c.hora, '%H:%i') hora, p.nombre FROM citas c, medicos m, login l, pacientes p WHERE c.doctor=m.id AND m.id=l.doctor AND c.paciente=p.id AND  day(c.fecha)="+dia+" AND month(c.fecha)="+mes+" AND year(c.fecha)="+year+" AND l.usuario='"+this.usuario+"' order by c.hora";
		rs = bd.consultar(sentencia);
		while(rs.next()){
			citas.add(rs.getString("hora"));
			citas.add(rs.getString("nombre"));
		}
		return citas;
	}
	
	public void salirAplicacion(){
		String sentencia = "update login set ultimo_acceso=CURRENT_TIMESTAMP() where usuario='"+this.usuario+"'";
		bd.executeUpdate(sentencia);
	}
}
