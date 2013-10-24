package com.luremesoftware.adme.modelo.gestor;

import java.util.List;

import com.luremesoftware.adme.bbdd.PubliBbdd;
import com.luremesoftware.adme.modelo.Publi;
import com.luremesoftware.adme.modelo.lista.ListaMensaje;
import com.luremesoftware.adme.modelo.lista.ListaMetadato;

public class GestorPubli {
	
	private PubliBbdd publiBbdd = null;
	
	public GestorPubli(){
		this.publiBbdd = new PubliBbdd();
	}
	
	/**
	 * Se retorna el listado de Publicaciones a partir de una tabla de Metadatos
	 * @param listaMetadato Filtros que se quiere buscar publicaciones
	 * @return Listado de Publicaciones
	 */	
	public List<Publi> getListaPubli(ListaMetadato listaMetadato){
		return this.publiBbdd.getListaPubli(listaMetadato);
	}

	/**
	 * Crea una publicaci�n en el sistema
	 * 
	 * @return Retorna el identificador de la publicaci�n
	 */
	public ListaMensaje putPubli(Publi publi){
		return publiBbdd.putPublicacion(publi);
	}
	
	public ListaMensaje borraPubli(Publi publi){
		return publiBbdd.borraPublicacion(publi);
	}
}