package zone.adme.gwt.client.sign;

import zone.adme.gwt.shared.UsuarioGWT;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SignServiceAsync {

	void signIn(String correo, String contrasena, AsyncCallback<UsuarioGWT> callback);

	void signOut(String correo, AsyncCallback<Boolean> callback);

	void getUsuarioSession(AsyncCallback<UsuarioGWT> callback);

	void register(String correo, String contrasena, String nombre, String apellido1,
			String apellido2, AsyncCallback<UsuarioGWT> asyncCallback);

}
