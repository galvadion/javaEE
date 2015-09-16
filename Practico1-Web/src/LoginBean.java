import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletException;

import ejb.UsuarioEJBLocal;
import entidades.Usuario;


/**
 * 
 */

/**
 * @author Diego
 *
 */
@ManagedBean
@SessionScoped
public class LoginBean {
	private String nick;
	private String fullName;
	private String e_mail;
	private String password;
	private Usuario user;
	private String message;
	private String passwordrpt;

	@EJB
	private UsuarioEJBLocal UserEJB;

	
	public String getNick() {
		return nick;
	}

	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setNick(String Nick) {
		this.nick = Nick;
	}


	
	public String getFullName() {
		return fullName;
	}


	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	
	public String getE_mail() {
		return e_mail;
	}


	
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}


	
	public String getPassword() {
		return password;
	}


	
	public void setPassword(String password) {
		this.password = password;
	}

	public String log_in(){
		try{	
			user=UserEJB.loginUser(nick, password);
			return ("success");
		}catch(Exception e){
			return("failed");
		}
		
	}

	public String registrarUsuario(){
		if(password!=passwordrpt){
			this.message="Las contrase;as no coinciden";
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage fMessage = new FacesMessage(message);
			context.addMessage(null, fMessage);
			return null;
		}else{
		try{
			Usuario user=new Usuario();
			user.setNick(nick);
			user.setMail(e_mail);
			user.setNombreCompleto(fullName);
			user.setPassword(password);
			UserEJB.registrarUsuario(user);
			return ("login");
		}catch(Exception e){
			return("failure");
		}}
		
	}



	public Usuario getUser() {
		return user;
	}



	public void setUser(Usuario user) {
		this.user = user;
	}



	public String getPasswordrpt() {
		return passwordrpt;
	}



	public void setPasswordrpt(String passwordrpt) {
		this.passwordrpt = passwordrpt;
	}




}
