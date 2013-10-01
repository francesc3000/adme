package com.luremesoftware.adme.bbdd;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.luremesoftware.adme.constantes.Constante.ConstantePubli;
import com.luremesoftware.adme.constantes.Constante.ConstanteUsuario;
import com.luremesoftware.adme.constantes.NombreTabla;
import com.luremesoftware.adme.modelo.Mensaje;
import com.luremesoftware.adme.modelo.Propietario;
import com.luremesoftware.adme.modelo.Publi;
import com.luremesoftware.adme.modelo.lista.ListaMensaje;
import com.luremesoftware.adme.modelo.lista.ListaMetadato;
import com.luremesoftware.adme.modelo.lista.ListaPubli;

public class PubliBbdd extends Bbdd{

	private DatastoreService datastore = null;
	private Query query = null;
	
	public PubliBbdd(){
		datastore = DatastoreServiceFactory.getDatastoreService();
		query = new Query(NombreTabla.PUBLICACION.toString());
	}
	
	public ListaMensaje crearPublicacion(Publi publi){
		ListaMensaje listaMensaje = new ListaMensaje();
		Entity entPublicacion = new Entity(NombreTabla.PUBLICACION.toString());

		entPublicacion.setProperty(ConstantePubli.PROPIETARIO.toString(), publi.getPropietarioId());
		entPublicacion.setProperty(ConstantePubli.TITULO.toString(), publi.getTitulo());
		entPublicacion.setProperty(ConstantePubli.CIUDAD.toString(), publi.getCiudad());
		entPublicacion.setProperty(ConstantePubli.DESCRIPCION.toString(), publi.getDescripcion());
			
		Key key = datastore.put(entPublicacion);
		
		if(key == null){
			listaMensaje.add(new Mensaje(Mensaje.ERROR,"No se pudo crer la Publicación!"));
		}else{
			listaMensaje.add(new Mensaje(Mensaje.OK,"Publicación creada!"));
		}
		
		return listaMensaje;
	}
	
	public ListaPubli getListaPubli(Propietario propietario){
		ListaPubli listaPubli = new ListaPubli();
		
		query.setFilter(new FilterPredicate(ConstantePubli.PROPIETARIO.toString(),FilterOperator.EQUAL,propietario.getId()));
		
		// PreparedQuery contains the methods for fetching query results
		// from the datastore
		PreparedQuery pq = datastore.prepare(query);
		
		for (Entity result : pq.asIterable()) {
		    listaPubli.add(rellenaPubli(result, propietario));
		}
		return listaPubli;
	}
	
	public ListaPubli getListaPubli(ListaMetadato listaMetadato){
		ListaPubli listaPubli = new ListaPubli();
		
		this.buildQuery(this.query, listaMetadato);
		
		PreparedQuery pq = datastore.prepare(query);
		
		UsuarioBbdd usuarioBbdd = new UsuarioBbdd();

		for (Entity result : pq.asIterable()) {	
			Propietario propietario = usuarioBbdd.getUsuario((String) result.getProperty(ConstanteUsuario.CORREO.toString()));
			
			if(propietario!=null){
				listaPubli.add(rellenaPubli(result, propietario));
			}
		}
		
		return listaPubli;
	}
	
	private Publi rellenaPubli(Entity result, Propietario propietario){

		    return new Publi(propietario,
				   			(String) result.getProperty(ConstantePubli.TITULO.toString()),
				   			(String) result.getProperty(ConstantePubli.CIUDAD.toString()),
				   			(String) result.getProperty(ConstantePubli.DESCRIPCION.toString()));
	}
}
