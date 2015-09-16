package ejb;

import javax.ejb.Local;

import entidades.Usuario;

@Local
public interface UsuarioEJBLocal {
	public Usuario loginUser(String nickname,String password);
	public Usuario registrarUsuario(Usuario usuario);
}
