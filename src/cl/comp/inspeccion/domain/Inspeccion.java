package cl.comp.inspeccion.domain;

public class Inspeccion {
	private String inspeccionId;
	private String inspeccionFoto;
	private String inspeccionFotoNro;
	private String inspeccionFotoDesc;
	private String usuarioRut;
	private String inspeccionGeoDireccion;
	private String inspeccionGeoLatitud;
	private String inspeccionGeoLongitud;
	private String token;
	private String inspeccionIndice;
	private String inspeccionTotal;

	public Inspeccion() {
		super();
	}

	public String getInspeccionIndice() {
		return inspeccionIndice;
	}

	public void setInspeccionIndice(String inspeccionIndice) {
		this.inspeccionIndice = inspeccionIndice;
	}

	public String getInspeccionTotal() {
		return inspeccionTotal;
	}

	public void setInspeccionTotal(String inspeccionTotal) {
		this.inspeccionTotal = inspeccionTotal;
	}

	public String getInspeccionId() {
		return inspeccionId;
	}

	public void setInspeccionId(String inspeccionId) {
		this.inspeccionId = inspeccionId;
	}

	public String getInspeccionFoto() {
		return inspeccionFoto;
	}

	public void setInspeccionFoto(String inspeccionFoto) {
		this.inspeccionFoto = inspeccionFoto;
	}

	public String getInspeccionFotoNro() {
		return inspeccionFotoNro;
	}

	public void setInspeccionFotoNro(String inspeccionFotoNro) {
		this.inspeccionFotoNro = inspeccionFotoNro;
	}

	public String getInspeccionFotoDesc() {
		return inspeccionFotoDesc;
	}

	public void setInspeccionFotoDesc(String inspeccionFotoDesc) {
		this.inspeccionFotoDesc = inspeccionFotoDesc;
	}

	public String getUsuarioRut() {
		return usuarioRut;
	}

	public void setUsuarioRut(String usuarioRut) {
		this.usuarioRut = usuarioRut;
	}

	public String getInspeccionGeoDireccion() {
		return inspeccionGeoDireccion;
	}

	public void setInspeccionGeoDireccion(String inspeccionGeoDireccion) {
		this.inspeccionGeoDireccion = inspeccionGeoDireccion;
	}

	public String getInspeccionGeoLatitud() {
		return inspeccionGeoLatitud;
	}

	public void setInspeccionGeoLatitud(String inspeccionGeoLatitud) {
		this.inspeccionGeoLatitud = inspeccionGeoLatitud;
	}

	public String getInspeccionGeoLongitud() {
		return inspeccionGeoLongitud;
	}

	public void setInspeccionGeoLongitud(String inspeccionGeoLongitud) {
		this.inspeccionGeoLongitud = inspeccionGeoLongitud;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Inspeccion(String inspeccionId, String inspeccionFoto, String inspeccionFotoNro, String inspeccionFotoDesc,
			String usuarioRut, String inspeccionGeoDireccion, String inspeccionGeoLatitud, String inspeccionGeoLongitud,
			String token, String inspeccionIndice, String inspeccionTotal) {
		super();
		this.inspeccionId = inspeccionId;
		this.inspeccionFoto = inspeccionFoto;
		this.inspeccionFotoNro = inspeccionFotoNro;
		this.inspeccionFotoDesc = inspeccionFotoDesc;
		this.usuarioRut = usuarioRut;
		this.inspeccionGeoDireccion = inspeccionGeoDireccion;
		this.inspeccionGeoLatitud = inspeccionGeoLatitud;
		this.inspeccionGeoLongitud = inspeccionGeoLongitud;
		this.token = token;
		this.inspeccionIndice = inspeccionIndice;
		this.inspeccionTotal = inspeccionTotal;
	}




}
