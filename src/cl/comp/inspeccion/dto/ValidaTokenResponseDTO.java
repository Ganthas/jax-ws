package cl.comp.inspeccion.dto;

public class ValidaTokenResponseDTO {
	private Integer resultCode;
	private String resultDesc;
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	public ValidaTokenResponseDTO(Integer resultCode, String resultDesc) {
		super();
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
	}
	public ValidaTokenResponseDTO() {
		super();
	}


}
