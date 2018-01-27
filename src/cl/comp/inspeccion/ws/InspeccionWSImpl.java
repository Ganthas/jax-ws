package cl.comp.inspeccion.ws;

import java.sql.Connection;
import java.sql.SQLException;

import javax.jws.WebService;

import cl.comp.inspeccion.dao.InspeccionDAO;
import cl.comp.inspeccion.domain.Inspeccion;
import cl.comp.inspeccion.dto.InspeccionResponseDTO;
import cl.comp.inspeccion.util.DataSourceFactory;
import cl.comp.inspeccion.util.Utils;

@WebService(endpointInterface = "cl.comp.inspeccion.ws.InspeccionWS", portName = "InspeccionWSPort", serviceName = "inspeccionWS")
public class InspeccionWSImpl implements InspeccionWS {

	@Override
	public InspeccionResponseDTO inspeccion(String inspeccionId,
			String inspeccionFoto,
			String inspeccionFotoNro,
			String inspeccionFotoDesc,
			String usuarioRut,
			String inspeccionGeoDireccion,
			String inspeccionGeoLatitud,
			String inspeccionGeoLongitud,
			String inspeccionIndice,
			String inspeccionTotal,
			String token) {
		InspeccionResponseDTO response = new InspeccionResponseDTO();
		
		if (inspeccionId.equals("") || inspeccionId.equals("?")) {	
			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar inspeccionId");		
			
		} else if (inspeccionFoto.equals("") || inspeccionFoto.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar foto");
			
		} else if (inspeccionFotoNro.equals("") || inspeccionFotoNro.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar numero de foto");		
			
		} else if (null == inspeccionFotoDesc) {			
			inspeccionFotoDesc=" ";	
			
		} else if (usuarioRut.equals("") || usuarioRut.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar rut de usuario");		
			
		} else if (inspeccionGeoDireccion.equals("") || inspeccionGeoDireccion.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar direccion");		
			
		}  else if (inspeccionGeoLatitud.equals("") || inspeccionGeoLatitud.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar latitud");		
			
		}  else if (inspeccionGeoLongitud.equals("") || inspeccionGeoLongitud.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar longitud");		
			
		}  else if (inspeccionIndice.equals("") || inspeccionIndice.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar indice");		
			
		}  else if (inspeccionTotal.equals("") || inspeccionTotal.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar total de fotos");		
			
		}  else if (token.equals("") || token.equals("?")) {			
			response.setResultCode("1");
			response.setResultDesc("Debe especificar token");		
			
		} else {
			Connection con = DataSourceFactory.getConnection();
			if(con != null) {
				try {
					
					Inspeccion inspeccion = new Inspeccion();
					inspeccion.setInspeccionId(inspeccionId);
					inspeccion.setInspeccionFoto(inspeccionFoto);
					inspeccion.setInspeccionFotoDesc(inspeccionFotoDesc);
					inspeccion.setInspeccionFotoNro(inspeccionFotoNro);
					inspeccion.setUsuarioRut(usuarioRut);
					inspeccion.setInspeccionGeoDireccion(inspeccionGeoDireccion);
					inspeccion.setInspeccionGeoLatitud(inspeccionGeoLatitud);
					inspeccion.setInspeccionGeoLongitud(inspeccionGeoLongitud);
					inspeccion.setInspeccionIndice(inspeccionIndice);
					inspeccion.setInspeccionTotal(inspeccionTotal);
					inspeccion.setToken(token);
					response = InspeccionDAO.executeStoredProcedure(inspeccion, response, con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				DataSourceFactory.closeConnection(con);
			}else{
				response.setResultDesc("conexion base de datos erronea");
			}
		}
		
		return response;
	}

}
