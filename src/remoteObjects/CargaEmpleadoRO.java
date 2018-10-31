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
import dto.FacturaDTO;
import dto.FichadaDTO;
import dto.PersonaFisicaDTO;
import dto.PersonaJuridicaDTO;
import interfaces.CargaEmpleado;
import interfaces.SistemaPresentismo;

public class CargaEmpleadoRO extends UnicastRemoteObject implements CargaEmpleado {

	private static final long serialVersionUID = 5692338657894292599L;

	public CargaEmpleadoRO() throws RemoteException {
        super();
    }

	@Override
	public void cargaEmpleado(String CUITEmpresa, String legajo, String nombre, String apellido, String mail,
			String dni, String telefono) throws RemoteException {
		EmpleadoDTO empleadoDto = new EmpleadoDTO(nombre,apellido,mail,dni,telefono, new Date(1,1,2018),legajo);
		ControladorPresentismo.getInstance().agregarEmpleado(empleadoDto, CUITEmpresa);
		
	}

	

}
