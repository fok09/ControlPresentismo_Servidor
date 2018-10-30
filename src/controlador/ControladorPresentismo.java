package controlador;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;
import bean.Cliente;
import bean.Empleado;
import bean.Factura;
import bean.Fichada;
import bean.PersonaFisica;
import bean.PersonaJuridica;
import dto.*;
import interfaces.SistemaPresentismo;

public class ControladorPresentismo implements SistemaPresentismo {

    @SuppressWarnings("unused")
	private Cliente cliente;

    private static ControladorPresentismo INSTANCE = new ControladorPresentismo();

    private ControladorPresentismo(){
        this.cliente = new Cliente();
    }

    public static ControladorPresentismo getInstance() {
        return INSTANCE;
    }

	@Override
	public void crearClienteJuridico(PersonaJuridicaDTO personaJuridicaDTO) throws RemoteException {
		PersonaJuridica personaJuridica = new PersonaJuridica(
				personaJuridicaDTO.getCuit_cuil(),
				personaJuridicaDTO.getDomicilio(),
				personaJuridicaDTO.getTelefono(),
				personaJuridicaDTO.getMail(),
				personaJuridicaDTO.getHoraEntrada(),
				personaJuridicaDTO.getHoraSalida(),
				personaJuridicaDTO.getRazonSocial()
				);
		srv.ClienteSrv.grabarPersonaJuridica(personaJuridica);
		//return personaJuridica.getId();
	}

	@Override
	public void crearClienteFisico(PersonaFisicaDTO personaFisicaDTO) throws RemoteException {
	PersonaFisica personaFisica = new PersonaFisica(
				personaFisicaDTO.getCuit_cuil(),
				personaFisicaDTO.getDomicilio(),
				personaFisicaDTO.getTelefono(),
				personaFisicaDTO.getMail(),
				personaFisicaDTO.getHoraEntrada(),
				personaFisicaDTO.getHoraSalida(),
				personaFisicaDTO.getNombre(),
				personaFisicaDTO.getApellido()
				);
		srv.ClienteSrv.grabarPersonaFisica(personaFisica);
		//return personaFisica.getId();
	}

	@Override
	public void crearFactura(FacturaDTO facturaDTO) throws RemoteException {
		Factura factura = new Factura(
				facturaDTO.getMonto(),
				facturaDTO.getTipo(),
				facturaDTO.getCliente()
				);
		srv.FacturaSrv.grabarFactura(factura);
	}

	@Override
	public void eliminarCliente(String cuit_cuil) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void modificarCliente(String cuit_cuil, String domicilio, String telefono, String mail, Time horaEntrada,
//			Time horaSalida) throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void agregarEmpleado(EmpleadoDTO empleadoDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaFichada(FichadaDTO fichadaDTO) throws RemoteException {
		Fichada fichada = new Fichada(
				fichadaDTO.getTipo(),
				fichadaDTO.getEmpleado()
				);
		srv.FichadaSrv.grabarFichada(fichada);		
	}

//	@Override
//	public void crearFacturaSemanal(FacturaDTO facturaDTO) throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void crearFacturaEventual(FacturaDTO facturaDTO) throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void registrarPago(int nroFactura) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	private Empleado dtoToEmpleado(EmpleadoDTO empleado){
        return new Empleado(
        		empleado.getNombre(),
        		empleado.getApellido(),
        		empleado.getMail(),
        		empleado.getDni(),
        		empleado.getTelefono(),
        		empleado.getFechaNac(),
        		empleado.getLegajo()
        );
    }

	@Override
	public void modificarCliente(ClienteDTO clienteDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
