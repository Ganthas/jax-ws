package cl.comp.inspeccion.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import cl.comp.inspeccion.domain.Inspeccion;
import cl.comp.inspeccion.dto.InspeccionResponseDTO;
import cl.comp.inspeccion.dto.ValidaTokenResponseDTO;
import cl.comp.inspeccion.util.SendEmailGmail;
import cl.comp.inspeccion.util.Utils;
import cl.comp.inspeccion.vo.Alerta;

public class InspeccionDAO {
	public static InspeccionResponseDTO executeStoredProcedure(Inspeccion inspeccion,
			InspeccionResponseDTO response, 
			Connection con)
			throws SQLException {
		Integer resultCode = null;
		String resultDesc = null;
		String query = "{call SP_INSPECCION(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		ValidaTokenResponseDTO validaToken = new ValidaTokenResponseDTO();

		CallableStatement cStmt = null;
		try {
			validaToken = validaTokenUsuario(inspeccion.getUsuarioRut(), inspeccion.getToken(), con);
			if(validaToken.getResultCode()==0){
				cStmt = con.prepareCall(query);			
				
				cStmt.setString(1, inspeccion.getInspeccionId());
				cStmt.setString(2, inspeccion.getInspeccionFoto());
				cStmt.setString(3, inspeccion.getInspeccionFotoNro());
				cStmt.setString(4, inspeccion.getInspeccionFotoDesc());
				cStmt.setString(5, inspeccion.getUsuarioRut());
				cStmt.setString(6, inspeccion.getInspeccionGeoDireccion());
				cStmt.setString(7, inspeccion.getInspeccionGeoLatitud());
				cStmt.setString(8, inspeccion.getInspeccionGeoLongitud());
				cStmt.setString(9, inspeccion.getInspeccionIndice());
				cStmt.setString(10, inspeccion.getInspeccionTotal());
				cStmt.registerOutParameter(11, Types.INTEGER);
				cStmt.registerOutParameter(12, Types.VARCHAR);

				boolean hadResults = cStmt.execute();
				System.out.println("hadResults : " + hadResults);
						
				resultCode = cStmt.getInt(11); // index-based
				resultDesc = cStmt.getString(12);
				System.out.println("resultCode : " + resultCode);
				System.out.println("resultDesc : " + resultDesc);
				response.setResultCode(Integer.toString(resultCode));
				response.setResultDesc(resultDesc);
				response.setInspeccionId(inspeccion.getInspeccionId());
				response.setInspeccionFotoNro(inspeccion.getInspeccionFotoNro());
				response.setToken(inspeccion.getToken());
			}else{
				response.setResultCode(Integer.toString(validaToken.getResultCode()));
				response.setResultDesc(validaToken.getResultDesc());
				response.setInspeccionId(inspeccion.getInspeccionId());
				response.setInspeccionFotoNro(inspeccion.getInspeccionFotoNro());
				response.setToken(inspeccion.getToken());
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (cStmt != null) {
					cStmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return response;
	}
	
	public static ValidaTokenResponseDTO validaTokenUsuario(String usuarioRut, String token, Connection con) throws SQLException {
		Integer resultCode = null;
		String resultDesc = null;
		String query = "{call SP_VALIDATOKEN(?, ?, ?, ?)}";
		CallableStatement cStmt = null;
		ValidaTokenResponseDTO response = new ValidaTokenResponseDTO();
		try {
			cStmt = con.prepareCall(query);
			cStmt.setString(1, usuarioRut);
			cStmt.setString(2, token);
			cStmt.registerOutParameter(3, Types.INTEGER);
			cStmt.registerOutParameter(4, Types.VARCHAR);
			
			boolean hadResults = cStmt.execute();
			System.out.println("hadResults : " + hadResults);
			
			
			resultCode = cStmt.getInt(3); // index-based
			resultDesc = cStmt.getString(4); // index-based
			
			response.setResultCode(resultCode);
			response.setResultDesc(resultDesc);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (cStmt != null) {
					cStmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return response;
	}
	
}
