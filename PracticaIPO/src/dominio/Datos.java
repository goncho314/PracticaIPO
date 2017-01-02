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
	
	public String getFotoEspecialista(String s) throws SQLException{
		ResultSet rs;
		String sentencia = "SELECT foto FROM medicos WHERE nombre = '"+s+"'";
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
	
	public ArrayList<String> getListaEspecialistas(String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> lista = new ArrayList<String>();
		String sentencia = "SELECT nombre, especialidad FROM medicos WHERE id>2 AND (nombre LIKE '%"+s+"%' OR especialidad LIKE '%"+s+"%')";
		rs = bd.consultar(sentencia);
		while(rs.next()){
			lista.add(rs.getString("nombre"));
			lista.add(rs.getString("especialidad"));
		}
		return lista;
	}
	
	public ArrayList<String> getInfoEspecialistas(String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> info = new ArrayList<String>();
		String sentencia = "SELECT nombre, especialidad, horario, direccion, foto FROM medicos WHERE nombre = '"+s+"'";
		rs = bd.consultar(sentencia);
		if(rs.next()){
			info.add(rs.getString("nombre"));
			info.add(rs.getString("especialidad"));
			info.add(rs.getString("horario"));
			info.add(rs.getString("direccion"));
			info.add(rs.getString("foto"));
		}
		return info;
	}
	
	public ArrayList<String> getInfoPaciente(String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> info = new ArrayList<String>();
		info.add(getDatoPaciente("SELECT DATE_FORMAT(fechaN, '%d/%m/%Y') fecha FROM pacientes WHERE nombre='"+s+"'"));
		info.add(getDatoPaciente("SELECT sexo FROM pacientes WHERE nombre='"+s+"'"));
		info.add(getDatoPaciente("SELECT pais FROM pacientes WHERE nombre='"+s+"'"));
		info.add(getDatoPaciente("SELECT telefono FROM pacientes WHERE nombre='"+s+"'"));
		info.add(getAlergias(s));
		info.add(getDatoPaciente("SELECT comentario FROM antecedentes WHERE paciente =(SELECT id FROM pacientes WHERE nombre='"+s+"')"));
		info.add(getEnfermedades(s));
		info.add(getVacunaciones(s));
		info.add(getDatoPaciente("SELECT comentario FROM tratamiento WHERE paciente =(SELECT id FROM pacientes WHERE nombre='"+s+"')"));
		info.add(getOperaciones(s));
		info.add(getFotoPaciente(s));
		return info;
	}
	
	public String getDatoPaciente(String sentencia) throws SQLException{
		ResultSet rs = bd.consultar(sentencia);
		String s ="";
		if(rs.next())
			s = rs.getString(1);
		return s;
	}
	
	public String getAlergias(String s) throws SQLException{
		ResultSet rs;
		String alergias = "";
		String sentencia = "SELECT al.nombre FROM `alergia-persona` ap, alergias al, pacientes p WHERE ap.alergia=al.id AND p.id=ap.paciente AND p.nombre='"+s+"'";
		rs = bd.consultar(sentencia);
		while(rs.next())
			alergias = alergias+rs.getString(1)+"\n";
		return alergias;
	}
	
	public String getEnfermedades(String s) throws SQLException{
		ResultSet rs;
		String enf = "";
		String sentencia = "SELECT enf.nombre FROM `enfermedades-persona` ep, enfermedades enf, pacientes p WHERE ep.enfermedad=enf.id AND p.id=ep.paciente AND p.nombre='"+s+"'";
		rs = bd.consultar(sentencia);
		while(rs.next())
			enf = enf+rs.getString(1)+"\n";
		return enf;
	}
	
	public String getVacunaciones(String s) throws SQLException{
		ResultSet rs;
		String vac = "";
		String sentencia = "SELECT DATE_FORMAT(vac.fecha, '%d/%m/%Y') fecha,  v.nombre FROM vacunaciones vac, vacunas v, pacientes p WHERE vac.vacuna=v.id AND p.id=vac.paciente AND p.nombre='"+s+"' order by fecha desc";
		rs = bd.consultar(sentencia);
		while(rs.next())
			vac = vac+rs.getString(1)+": "+rs.getString(2)+"\n";
		return vac;
	}
	
	public String getOperaciones(String s) throws SQLException{
		ResultSet rs;
		String op = "";
		String sentencia = "SELECT DATE_FORMAT(op.fecha, '%d/%m/%Y') fecha, op.nombre, m.nombre FROM operaciones op, medicos m, pacientes p WHERE op.paciente=p.id AND op.doctor=m.id AND p.nombre ='"+s+"' ORDER BY fecha DESC";
		rs = bd.consultar(sentencia);
		while(rs.next())
			op = op+rs.getString(1)+": "+rs.getString(2)+", realizado por: "+rs.getString(3)+"\n";
		return op;
	}	
	
	
	public ArrayList<String> getListaPacientes(String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> lista = new ArrayList<String>();
		String sentencia = "SELECT nombre FROM pacientes WHERE medico=(SELECT doctor FROM login WHERE usuario='"+this.usuario+"') AND nombre LIKE '%"+s+"%' ";
		rs = bd.consultar(sentencia);
		while(rs.next()){
			lista.add(rs.getString("nombre"));
		}
		return lista;
	}
	
	public void salirAplicacion(){
		String sentencia = "update login set ultimo_acceso=CURRENT_TIMESTAMP() where usuario='"+this.usuario+"'";
		bd.executeUpdate(sentencia);
	}
}
