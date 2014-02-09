package zone.adme.gwt.server;

import java.util.ArrayList;
import java.util.List;

import zone.adme.core.modelo.Publi;
import zone.adme.core.modelo.Usuario;
import zone.adme.core.modelo.lista.ListaMetadato;
import zone.adme.gwt.shared.MetadatoGWT;
import zone.adme.gwt.shared.PubliGWT;
import zone.adme.gwt.shared.UsuarioGWT;

public class Dto {

	public Dto(){}
	
	public UsuarioGWT toUsuarioGWT(Usuario usuario){
		if(usuario!=null){
			UsuarioGWT usuarioGWT = new UsuarioGWT(usuario.getCorreo());
			//Proceso de igualación
			
			return usuarioGWT;
		}
		else{
			return null;
		}
	}
	
	public Usuario toUsuario(UsuarioGWT usuarioGWT){
		if(usuarioGWT!=null){
			Usuario usuario = new Usuario(usuarioGWT.getCorreo(),"","","","");
			
			//Proceso de igualación
			
			return usuario;
		}
		else{
			return null;
		}
		
	}
	
	public ListaMetadato toListaMetadato(List<MetadatoGWT> ListaMetadatoGWT){
		
		ListaMetadato listaMetadato = new ListaMetadato();
		
		//Proceso de igualación
		
		return listaMetadato;
	}
	
	public List<PubliGWT> toListaPubliGWT(List<Publi> listaPubli){
		
		List<PubliGWT> listaPubliGWT = new ArrayList<PubliGWT>();
		
		//Proceso de igualación
		
		return listaPubliGWT;
	}
	
public Publi toPubli(PubliGWT publiGWT) {
		
		//Proceso de igualación
		
		Publi publi = new Publi(new Usuario("a@a.com", "", "", "", ""), publiGWT.getTitulo(), publiGWT.getTexto(), "");
		return publi;
	}
}
