package repository;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepository {
	private List<Usuario> usuarios;

	public UsuarioRepository() {
		super();
		usuarios = new ArrayList<>();
		usuarios.add(new Usuario("001", "jioh", "123456"));
		usuarios.add(new Usuario("002", "mtoro", "987654"));
		usuarios.add(new Usuario("003", "mbusta", "456103"));
	}
	
	public List<Usuario> getAll() {
		return usuarios;
	}
	
	public Usuario getById(String id) {
		//return usuarios.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
		for(Usuario user: usuarios) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	public Usuario getByUsername(String username) {
		for(Usuario user: usuarios) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
