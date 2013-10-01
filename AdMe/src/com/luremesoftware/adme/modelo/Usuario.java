package com.luremesoftware.adme.modelo;

import com.luremesoftware.adme.modelo.gestor.GestorGrupo;
import com.luremesoftware.adme.modelo.lista.ListaGrupo;

/**
 * Clase Usuario
 * 
 * @author francesc3000@gmail.com
 *
*/
public class Usuario extends Propietario{
	private String correo;
	private String contrasena;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	
	private ListaGrupo listaGrupo = null;
	
	public Usuario(String correo) {
		super(correo);
		this.setCorreo(correo);
		//Se buscan los grupos en los que participa
		this.listaGrupo = new GestorGrupo().getListaGrupo(this);
	}
	
	/**
	* Completa los datos personales del usuario
    *
    * @param correo El correo del usuario
    * @param contrasena La contrase�a elegida por el usuario
    * @param nombre Nombre del usuario
    * @param apellido1 Primer apellido del usuario
    * @param apellido2 Segundo apellido del usuario
	*/	
	public Usuario(String correo, String contrasena, String nombre, String apellido1, String apellido2){
		super(correo);
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		
		//Se buscan los grupo en los que est� incluido
		this.listaGrupo = new GestorGrupo().getListaGrupo(this);
	}

	public String getCorreo(){
		//if(this.correo==null){this.correo = new String();}
		return this.correo;
	}
	
	public String getContrasena(){
	   //if(this.contrasena==null){this.contrasena = new String();}
		return this.contrasena;
	}
	
	public String getNombre(){
		//if(this.nombre==null){this.nombre = new String();}
		return this.nombre;
	}
	
	public String getApellido1(){
		//if(this.apellido1==null){this.apellido1 = new String();}
		return this.apellido1;
	}
	
	public String getApellido2(){
		//if(this.apellido2==null){this.apellido2 = new String();}
		return this.apellido2;
	}
	
	public Grupo getGrupo(int indice){
		return this.listaGrupo.get(indice);
	}
	
	public ListaGrupo getListaGrupo(){
		return this.listaGrupo;
	}
	
	public void setCorreo(String correo){
		this.correo = correo;
	}
	
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setApellido1(String apellido1){
		this.apellido1 = apellido1;
	}
	
	public void setApellido2(String apellido2){
		this.apellido2 = apellido2;
	}
	
	public String toString(){
		
		return getCorreo() + " " + getNombre() + " " + getApellido1() + " " + getApellido2();

	}
}
