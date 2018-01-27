package cl.comp.inspeccion.dto;

public class InspeccionResponseDTO {
	private String resultCode;
	private String resultDesc;
	private String token;
	private String inspeccionId;
	private String inspeccionFotoNro;
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getInspeccionId() {
		return inspeccionId;
	}

	public void setInspeccionId(String inspeccionId) {
		this.inspeccionId = inspeccionId;
	}

	public String getInspeccionFotoNro() {
		return inspeccionFotoNro;
	}

	public void setInspeccionFotoNro(String inspeccionFotoNro) {
		this.inspeccionFotoNro = inspeccionFotoNro;
	}

	public InspeccionResponseDTO() {
		super();
	}

	public InspeccionResponseDTO(String resultCode, String resultDesc, String token, String inspeccionId,
			String inspeccionFotoNro) {
		super();
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
		this.token = token;
		this.inspeccionId = inspeccionId;
		this.inspeccionFotoNro = inspeccionFotoNro;
	}
	
}
