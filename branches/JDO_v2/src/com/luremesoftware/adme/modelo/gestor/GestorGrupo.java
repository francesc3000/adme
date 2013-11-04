package com.luremesoftware.adme.modelo.gestor;

import java.util.ArrayList;
import java.util.List;

import com.luremesoftware.adme.bbdd.GrupoBbdd;
import com.luremesoftware.adme.modelo.Grupo;
import com.luremesoftware.adme.modelo.Propietario;
import com.luremesoftware.adme.modelo.Publi;
import com.luremesoftware.adme.modelo.Usuario;
import com.luremesoftware.adme.modelo.lista.ListaMensaje;

public class GestorGrupo {

	private GrupoBbdd grupoBbdd = null;
	
	public GestorGrupo(){
		this.grupoBbdd = new GrupoBbdd();
	}
	
	public Propietario getGrupo(String nombreGrupo){
		return this.grupoBbdd.getGrupo(nombreGrupo);
	}

	public List<Propietario> getListaGrupo(Propietario usuario){
		return this.grupoBbdd.getListaGrupo(usuario);
	}

	public List<Publi> getListaPubli(Propietario grupo){
		
		GestorPubli gestorPubli = new GestorPubli();
		
		grupo.setListaPubli(gestorPubli.getListaPubli(grupo));

		return grupo.getListaPubli();
		
	}
	
	public List<Publi> getListaPubli(List<Propietario> listaGrupo){
		List<Publi> listaPubli = new ArrayList<Publi>();
		
		for(Propietario grupo:listaGrupo){
			grupo.setListaPubli(this.getListaPubli(grupo));
			listaPubli.addAll(grupo.getListaPubli());
		}
		
		return listaPubli;
	}

	/**
	 * Regista un grupo en el sistema
	 * 
	 * @return Se retorna un listado de mensajes del sistema
	 */	
	public ListaMensaje putGrupo(Propietario grupo){	
		return this.grupoBbdd.putGrupo(grupo);
	}

	public ListaMensaje borraGrupo(Propietario grupo){
		return this.grupoBbdd.borraGrupo(grupo);
	}
}