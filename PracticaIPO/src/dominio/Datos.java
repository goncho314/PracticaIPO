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
		String sentencia = "SELECT usuario FROM login WHERE usuario='"+usuario+"' AND contrasena='"+password+"'"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
		String s = ""; //$NON-NLS-1$
		String sentencia = Messages.getString("Datos.4")+this.usuario+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		rs = bd.consultar(sentencia);
		if(rs.next())		
				s="<html><body>"+rs.getString(1)+"<br>"+ rs.getString(2)+Messages.getString("Datos.8")+rs.getString(3)+"</body></html>"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		return s;
	}
	
	public String getFotoMedico() throws SQLException{
		ResultSet rs;
		String sentencia = "SELECT foto FROM medicos WHERE id = (SELECT doctor FROM login WHERE usuario='"+this.usuario+"')"; //$NON-NLS-1$ //$NON-NLS-2$
		String ruta = ""; //$NON-NLS-1$
		rs = bd.consultar(sentencia);
		if(rs.next())
			ruta = rs.getString(1);
		return ruta;
	}
	
	public String getFotoEspecialista(String s) throws SQLException{
		ResultSet rs;
		String sentencia = "SELECT foto FROM medicos WHERE nombre = '"+s+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		String ruta = ""; //$NON-NLS-1$
		rs = bd.consultar(sentencia);
		if(rs.next())
			ruta = rs.getString(1);
		return ruta;
	}
	
	public String getFotoPaciente(String nombre) throws SQLException{		
		ResultSet rs;
		String sentencia = "SELECT foto FROM pacientes WHERE nombre = '"+nombre+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		String ruta = ""; //$NON-NLS-1$
		rs = bd.consultar(sentencia);
		if(rs.next())
			ruta = rs.getString(1);
		return ruta;
	}
	
	public ArrayList<String> getDiasCitas(int mes, int year) throws SQLException{
		ResultSet rs;
		ArrayList<String> dias = new ArrayList<String>();
		String sentencia = "SELECT day(c.fecha) dia FROM citas c, medicos m, login l WHERE c.doctor=m.id AND m.id=l.doctor AND month(c.fecha)="+mes+" AND year(c.fecha)="+year+" AND l.usuario='"+this.usuario+"' GROUP BY c.fecha order by c.fecha"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		rs = bd.consultar(sentencia);
		while(rs.next())
			dias.add(rs.getString(1));
		return dias;
	}
	
	public ArrayList<String> getCitasDia(int dia, int mes, int year) throws SQLException{
		ResultSet rs;
		ArrayList<String> citas = new ArrayList<String>();
		String sentencia = "SELECT TIME_FORMAT(c.hora, '%H:%i') hora, p.nombre FROM citas c, medicos m, login l, pacientes p WHERE c.doctor=m.id AND m.id=l.doctor AND c.paciente=p.id AND  day(c.fecha)="+dia+" AND month(c.fecha)="+mes+" AND year(c.fecha)="+year+" AND l.usuario='"+this.usuario+"' order by c.hora"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		rs = bd.consultar(sentencia);
		while(rs.next()){
			citas.add(rs.getString(1));
			citas.add(rs.getString(2));
		}
		return citas;
	}
	
	public ArrayList<String> getListaEspecialistas(String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> lista = new ArrayList<String>();
		String sentencia = Messages.getString("Datos.28")+s+Messages.getString("Datos.29")+s+"%')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		rs = bd.consultar(sentencia);
		while(rs.next()){
			lista.add(rs.getString(1));
			lista.add(rs.getString(2));
		}
		return lista;
	}
	
	public ArrayList<String> getInfoEspecialistas(String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> info = new ArrayList<String>();
		String sentencia = Messages.getString("Datos.31")+s+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		rs = bd.consultar(sentencia);
		if(rs.next()){
			info.add(rs.getString(1));
			info.add(rs.getString(2));
			info.add(rs.getString(3));
			info.add(rs.getString(4));
			info.add(rs.getString(5));
		}
		return info;
	}
	
	public ArrayList<String> getInfoPaciente(String s) throws SQLException{
		ArrayList<String> info = new ArrayList<String>();
		info.add(getDatoPaciente("SELECT DATE_FORMAT(fechaN, '%d/%m/%Y') fecha FROM pacientes WHERE nombre='"+s+"'")); //$NON-NLS-1$ //$NON-NLS-2$
		info.add(getDatoPaciente("SELECT sexo FROM pacientes WHERE nombre='"+s+"'")); //$NON-NLS-1$ //$NON-NLS-2$
		info.add(getDatoPaciente(Messages.getString("Datos.37")+s+"'")); //$NON-NLS-1$ //$NON-NLS-2$
		info.add(getDatoPaciente("SELECT telefono FROM pacientes WHERE nombre='"+s+"'")); //$NON-NLS-1$ //$NON-NLS-2$
		info.add(getAlergias(s));
		info.add(getDatoPaciente(Messages.getString("Datos.41")+s+"')")); //$NON-NLS-1$ //$NON-NLS-2$
		info.add(getEnfermedades(s));
		info.add(getVacunaciones(s));
		info.add(getDatoPaciente(Messages.getString("Datos.43")+s+"')")); //$NON-NLS-1$ //$NON-NLS-2$
		info.add(getOperaciones(s));
		info.add(getFotoPaciente(s));
		return info;
	}
	
	public String getDatoPaciente(String sentencia) throws SQLException{
		ResultSet rs = bd.consultar(sentencia);
		String s =""; //$NON-NLS-1$
		if(rs.next())
			s = rs.getString(1);
		return s;
	}
	
	public String getAlergias(String s) throws SQLException{
		ResultSet rs;
		String alergias = ""; //$NON-NLS-1$
		String sentencia = Messages.getString("Datos.47")+s+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		rs = bd.consultar(sentencia);
		while(rs.next())
			alergias = alergias+rs.getString(1)+"\n"; //$NON-NLS-1$
		return alergias;
	}
	
	public String getEnfermedades(String s) throws SQLException{
		ResultSet rs;
		String enf = ""; //$NON-NLS-1$
		String sentencia = Messages.getString("Datos.51")+s+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		rs = bd.consultar(sentencia);
		while(rs.next())
			enf = enf+rs.getString(1)+"\n"; //$NON-NLS-1$
		return enf;
	}
	
	public String getVacunaciones(String s) throws SQLException{
		ResultSet rs;
		String vac = ""; //$NON-NLS-1$
		String sentencia = Messages.getString("Datos.55")+s+"' order by fecha desc"; //$NON-NLS-1$ //$NON-NLS-2$
		rs = bd.consultar(sentencia);
		while(rs.next())
			vac = vac+rs.getString(1)+": "+rs.getString(2)+"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		return vac;
	}
	
	public String getOperaciones(String s) throws SQLException{
		ResultSet rs;
		String op = ""; //$NON-NLS-1$
		String sentencia = Messages.getString("Datos.60")+s+"' ORDER BY fecha DESC"; //$NON-NLS-1$ //$NON-NLS-2$
		rs = bd.consultar(sentencia);
		while(rs.next())
			op = op+rs.getString(1)+": "+rs.getString(2)+Messages.getString("Datos.0")+rs.getString(3)+"\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return op;
	}	
	
	
	public ArrayList<String> getListaPacientes(String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> lista = new ArrayList<String>();
		String sentencia = "SELECT nombre FROM pacientes WHERE medico=(SELECT doctor FROM login WHERE usuario='"+this.usuario+"') AND nombre LIKE '%"+s+"%' "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		rs = bd.consultar(sentencia);
		while(rs.next()){
			lista.add(rs.getString(1));
		}
		return lista;
	}
	
	public boolean aniadirPaciente(String nombre, String fecha, String sexo, String pais, String telefono){
		boolean b = false;
		String f = String.valueOf(fecha.charAt(6))+String.valueOf(fecha.charAt(7))+String.valueOf(fecha.charAt(8))+String.valueOf(fecha.charAt(9))+"-"+String.valueOf(fecha.charAt(3))+String.valueOf(fecha.charAt(4))+'-'+String.valueOf(fecha.charAt(0))+String.valueOf(fecha.charAt(1)); //$NON-NLS-1$
		String sentencia = "INSERT INTO `pacientes` (`nombre`, `fechaN`, `pais`, `telefono`, `sexo`, `medico`, `foto`, `country`) VALUES('"+nombre+"', '"+f+"', '"+pais+"', '"+telefono.replace(" ", "")+"', '"+sexo+"', (SELECT doctor FROM login WHERE usuario='"+this.usuario+"'), '/presentacion/resources/p0.png', '"+pais+"')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
		b = bd.executeUpdate(sentencia);
		return b;
	}
	
	public boolean editarPaciente(String nombreAnterior, String nombre, String fecha, String sexo, String pais, String telefono) throws NumberFormatException, SQLException{
		ResultSet rs;
		boolean b = false;
		String f = String.valueOf(fecha.charAt(6))+String.valueOf(fecha.charAt(7))+String.valueOf(fecha.charAt(8))+String.valueOf(fecha.charAt(9))+"-"+String.valueOf(fecha.charAt(3))+String.valueOf(fecha.charAt(4))+'-'+String.valueOf(fecha.charAt(0))+String.valueOf(fecha.charAt(1)); //$NON-NLS-1$
		int n = 0;
		String sentencia1 = "SELECT id FROM pacientes WHERE nombre='"+nombreAnterior+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		rs=bd.consultar(sentencia1);
		if(rs.next())
			n = Integer.parseInt(rs.getString(1));
		String sentencia2 = "UPDATE pacientes SET nombre='"+nombre+"', fechaN='"+f+"', pais='"+pais+"', telefono='"+telefono.replace(" ", "")+"', sexo='"+sexo+"', country='"+pais+"' WHERE id="+n; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
		b = bd.executeUpdate(sentencia2);
		return b;
	}
	
	public boolean borrarPaciente(String nombre) throws NumberFormatException, SQLException{
		ResultSet rs;
		boolean b = false;
		int n = 0;
		String sentencia1 = "SELECT id FROM pacientes WHERE nombre='"+nombre+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		rs=bd.consultar(sentencia1);
		if(rs.next())
			n = Integer.parseInt(rs.getString(1));
		String sentencia2 = "DELETE FROM pacientes WHERE id="+n; //$NON-NLS-1$
		b = bd.executeUpdate(sentencia2);
		return b;
	}
	
	public ArrayList<String> getListaInformes(String paciente, String s) throws SQLException{
		ResultSet rs;
		ArrayList<String> lista = new ArrayList<String>();
		String sentencia = "SELECT DATE_FORMAT(i.fecha, '%d/%m/%Y') fecha, m.nombre FROM informes i, medicos m, pacientes p WHERE m.id=i.doctor AND p.id=i.paciente AND i.paciente=(SELECT id FROM pacientes WHERE nombre='"+paciente+"') AND (i.fecha like '%"+s+"%' OR i.doctor IN (SELECT id FROM medicos WHERE nombre like'%"+s+"%'))"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		rs = bd.consultar(sentencia);
		while(rs.next()){
			lista.add(rs.getString(1));
			lista.add(rs.getString(2));
		}
		return lista;
	}
	
	public ArrayList<String> getInforme(String fecha, String nombre) throws SQLException{
		ArrayList<String> informe = new ArrayList<String>();
		String f = String.valueOf(fecha.charAt(6))+String.valueOf(fecha.charAt(7))+String.valueOf(fecha.charAt(8))+String.valueOf(fecha.charAt(9))+"-"+String.valueOf(fecha.charAt(3))+String.valueOf(fecha.charAt(4))+'-'+String.valueOf(fecha.charAt(0))+String.valueOf(fecha.charAt(1)); //$NON-NLS-1$
		String sentencia = Messages.getString("Datos.98")+f+"' AND m.nombre='"+nombre+"'"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		ResultSet rs = bd.consultar(sentencia);
		if(rs.next()){
			informe.add(rs.getString(1));
			informe.add(rs.getString(2));
			informe.add(rs.getString(3));
			informe.add(rs.getString(4));
			informe.add(rs.getString(5));
			informe.add(rs.getString(6));
			informe.add(rs.getString(7));
		}
		return informe;
	}
	
	public void salirAplicacion(){
		String sentencia = "update login set ultimo_acceso=CURRENT_TIMESTAMP() where usuario='"+this.usuario+"'"; //$NON-NLS-1$ //$NON-NLS-2$
		bd.executeUpdate(sentencia);
	}
}
