package entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

@NamedQueries({
	@NamedQuery(name = "usuario.SelectByName", query= "SELECT u FROM Usuario u WHERE u.Nick = :nick")
})
public class Usuario implements Serializable {

	   
	@Id
	private int Id;
	private String Nick;
	private String Password;
	private String Mail;
	private String NombreCompleto;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getNick() {
		return this.Nick;
	}

	public void setNick(String Nick) {
		this.Nick = Nick;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public String getMail() {
		return this.Mail;
	}

	public void setMail(String Mail) {
		this.Mail = Mail;
	}   
	public String getNombreCompleto() {
		return this.NombreCompleto;
	}

	public void setNombreCompleto(String NombreCompleto) {
		this.NombreCompleto = NombreCompleto;
	}
   
}
