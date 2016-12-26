package dominio;

import java.util.ArrayList;

public class Datos {
	private String usuario = "jd";
	public ArrayList usuarios = new ArrayList();
	public ArrayList passwords = new ArrayList();
	public ArrayList nombreMedicos = new ArrayList();
	public ArrayList fechaNMedicos = new ArrayList();
	public ArrayList rutaFotoMedicos = new ArrayList();
	public Datos(){
		usuarios.add("jd");
		passwords.add("jd");
		nombreMedicos.add("Dr. John Dorian");
		fechaNMedicos.add("25/06/1978");
		rutaFotoMedicos.add("/presentacion/jd.jpg");
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
				s="<html><body>"+nombreMedicos.get(i)+"<br>"+ fechaNMedicos.get(i)+"<br>Último acceso:<br>31/12/2016</body></html>";
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
}
