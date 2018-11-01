package remoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import bean.Contratacion;
import controlador.ControladorPresentismo;
import dto.ClienteDTO;
import dto.ContratacionDTO;
import dto.EmpleadoDTO;
import dto.EmpleadoHorasDTO;
import dto.FacturaDTO;
import dto.FichadaDTO;
import dto.PersonaFisicaDTO;
import dto.PersonaJuridicaDTO;
import interfaces.SistemaPresentismo;

public class ControladorPresentismoRO extends UnicastRemoteObject implements SistemaPresentismo {

	private static final long serialVersionUID = 5692338657894292599L;

	public ControladorPresentismoRO() throws RemoteException {
        super();
    }

	@Override
	public void crearClienteJuridico(PersonaJuridicaDTO personaJuridicaDTO) throws RemoteException {
		ControladorPresentismo.getInstance().crearClienteJuridico(personaJuridicaDTO);
		
	}

	@Override
	public void crearClienteFisico(PersonaFisicaDTO personaFisicaDTO) throws RemoteException {
		ControladorPresentismo.getInstance().crearClienteFisico(personaFisicaDTO);
		
	}

	@Override
	public void eliminarCliente(String cuit_cuil) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCliente(ClienteDTO clienteDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarEmpleado(EmpleadoDTO empleadoDTO, String cuit_cuil) throws RemoteException {
		ControladorPresentismo.getInstance().agregarEmpleado(empleadoDTO, cuit_cuil);
	}

	@Override
	public void altaFichada(FichadaDTO fichadaDTO) throws RemoteException {
		ControladorPresentismo.getInstance().altaFichada(fichadaDTO);
	}

	@Override
	public void crearFactura(FacturaDTO facturaDTO) throws RemoteException {
		ControladorPresentismo.getInstance().crearFactura(facturaDTO);
		
	}
	
	public void crearContratacion(ContratacionDTO contratacionDTO) throws RemoteException{
		ControladorPresentismo.getInstance().crearContratacion(contratacionDTO);
	}
	
	@Override
	public void registrarPago(FacturaDTO facturaDTO) throws RemoteException {
		ControladorPresentismo.getInstance().registrarPago(facturaDTO);		
	}

	@Override
	public Vector<Vector<String>> getHorasTrabajadasTotales(String cuit_cuil, java.util.Date fechaInicio, java.util.Date fechaFin, Contratacion c) throws RemoteException {
		
		return ControladorPresentismo.getInstance().getHorasTrabajadasTotales(cuit_cuil, fechaInicio, fechaFin, c);
	}

	@Override
	public List<Contratacion> getContratacionesCliente(String cuitEmpresa) throws RemoteException  {
		return ControladorPresentismo.getInstance().getContratacionesCliente(cuitEmpresa);
	}

	@Override
	public List<EmpleadoHorasDTO> getHorasTrabajadasTotalesLiqui(String cuit, Date cFechaInicio, Date cFechaFin) {
		return ControladorPresentismo.getInstance().getHorasTrabajadasTotalesLiqui(cuit, cFechaInicio, cFechaFin);
	}

	@Override
	public void enviarHorasTotales(List<EmpleadoHorasDTO> empleados, boolean liqui) {
		ControladorPresentismo.getInstance().enviarHorasTotales(empleados, liqui);
		
	}

}
