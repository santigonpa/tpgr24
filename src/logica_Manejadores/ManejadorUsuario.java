package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;

import logica.ManejadorUsuario;
import logica.Usuario;
import logica_Entidades.Empresa;

public class ManejadorUsuario {
	
	private Map<String, Usuario> usuarios;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuarios = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNickname();
        usuarios.put(nick, usu);
    }

    public Usuario obtenerUsuario(String nick) {
        return ((Usuario) usuarios.get(nick));
    }

}
