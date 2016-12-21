package dominio;

import java.util.ArrayList;

public class Datos {
	public ArrayList usuarios = new ArrayList();
	public ArrayList passwords = new ArrayList();
	public Datos(){
		usuarios.add("jd");
		passwords.add("jd");
	}
	public Boolean comprobarLogin(String usuario, String password){
		boolean b = false;
		for(int i = 0;i<usuarios.size() && !b;i++)
			b = (usuarios.get(i).equals(usuario) && passwords.get(i).equals(password));
		return b;
	}
}
