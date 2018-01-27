package cl.comp.inspeccion.vo;

import java.io.Serializable;
//import javax.persistence.*;


/**
 * The persistent class for the alerta database table.
 * 
 */
//@Entity
//@NamedQuery(name="Alerta.findAll", query="SELECT a FROM Alerta a")
public class Alerta implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlerta;

	private String emailFrom;

	private String emailTo;

	private String subject;

	private String text;

	public Alerta() {
	}

	public int getIdAlerta() {
		return this.idAlerta;
	}

	public void setIdAlerta(int idAlerta) {
		this.idAlerta = idAlerta;
	}

	public String getEmailFrom() {
		return this.emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return this.emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}