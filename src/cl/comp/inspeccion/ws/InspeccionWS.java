package cl.comp.inspeccion.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.xml.bind.annotation.XmlElement;

import com.sun.xml.ws.developer.SchemaValidation;

import cl.comp.inspeccion.dto.InspeccionResponseDTO;

@WebService
@SchemaValidation
public interface InspeccionWS {
	InspeccionResponseDTO inspeccion(
			@WebParam(name = "inspeccionId", mode = Mode.IN) @XmlElement(required = true) String inspeccionId,
			@WebParam(name = "inspeccionFoto", mode = Mode.IN) @XmlElement(required = true) String inspeccionFoto,
			@WebParam(name = "inspeccionFotoNro", mode = Mode.IN) @XmlElement(required = true) String inspeccionFotoNro,
			@WebParam(name = "inspeccionFotoDesc", mode = Mode.IN) @XmlElement(required = false) String inspeccionFotoDesc,
			@WebParam(name = "usuarioRut", mode = Mode.IN) @XmlElement(required = true) String usuarioRut,
			@WebParam(name = "inspeccionGeoDireccion", mode = Mode.IN) @XmlElement(required = true) String inspeccionGeoDireccion,
			@WebParam(name = "inspeccionGeoLatitud", mode = Mode.IN) @XmlElement(required = true) String inspeccionGeoLatitud,
			@WebParam(name = "inspeccionGeoLongitud", mode = Mode.IN) @XmlElement(required = true) String inspeccionGeoLongitud,
			@WebParam(name = "inspeccionIndice", mode = Mode.IN) @XmlElement(required = true) String inspeccionIndice,
			@WebParam(name = "inspeccionTotal", mode = Mode.IN) @XmlElement(required = true) String inspeccionTotal,
			@WebParam(name = "token", mode = Mode.IN) @XmlElement(required = true) String token);

}