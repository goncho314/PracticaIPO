package dominio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Datos {
	private String usuario;
	public ArrayList usuarios = new ArrayList();
	public ArrayList passwords = new ArrayList();
	public ArrayList nombreMedicos = new ArrayList();
	public ArrayList especialidad = new ArrayList();
	public ArrayList rutaFotoMedicos = new ArrayList();
	public Datos(){
		usuarios.add("jd");
		passwords.add("jd");
		nombreMedicos.add("Dr. John Dorian");
		especialidad.add("Medicina general");
		rutaFotoMedicos.add("/presentacion/jd.jpg");
		usuarios.add("turk");
		passwords.add("turk");
		nombreMedicos.add("Dr. Christopher Turk");
		especialidad.add("Cirugía");
		rutaFotoMedicos.add("/presentacion/turk.jpg");
		usuarios.add("elliot");
		passwords.add("elliot");
		nombreMedicos.add("Dra. Elliot Reid");
		especialidad.add("Medicina general");
		rutaFotoMedicos.add("/presentacion/elliot.jpg");
		
	}
	public Boolean comprobarLogin(String usuario, String password){
		boolean b = false;
		for(int i = 0;i<usuarios.size() && !b;i++)
			b = (usuarios.get(i).equals(usuario) && passwords.get(i).equals(password));
		return b;
	}
	
	public void setUsuario(String s){
		this.usuario = s;
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public String getInfoMedico(){
		boolean b = false;
		String s = "";
		for(int i = 0;i<usuarios.size() && !b;i++)
			if(usuarios.get(i).equals(this.usuario)){
				b=true;
				s="<html><body>"+nombreMedicos.get(i)+"<br>"+ especialidad.get(i)+"<br>Último acceso:<br>"+getUltimoAcceso()+"</body></html>";
			}
		return s;
	}
	
	public String getFotoMedico(){
		boolean b = false;
		String s = "";
		for(int i = 0;i<usuarios.size() && !b;i++)
			if(usuarios.get(i).equals(this.usuario)){
				b=true;
				s=(String)rutaFotoMedicos.get(i);
			}
		return s;
	}
	
	public String getUltimoAcceso(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
