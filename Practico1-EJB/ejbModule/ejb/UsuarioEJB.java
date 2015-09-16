package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entidades.Usuario;

/**
 * Session Bean implementation class UsuarioEJB
 */
@Stateless
@LocalBean
public class UsuarioEJB implements UsuarioEJBRemote, UsuarioEJBLocal {

	@PersistenceContext
	private EntityManager em;
    
	public Usuario registrarUsuario(Usuario usuario){
		em.persist(usuario);
		return usuario;
	}
	
	public Usuario loginUser(String nick,String password){
		TypedQuery<Usuario> loginUser=em.createNamedQuery("usuario.SelectByName",Usuario.class);
		loginUser.setParameter("nick", nick);
		try{
			Usuario usuario=loginUser.getSingleResult();
			if(usuario.getPassword().equals(password)){
				return usuario;
			}
			else return null;
		}catch(Exception e){
			return null;
		}
		
	}

}
