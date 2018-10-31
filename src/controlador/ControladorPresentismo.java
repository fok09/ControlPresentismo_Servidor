package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Vector;
import bean.Cliente;
import bean.Contratacion;
import bean.Empleado;
import bean.Factura;
import bean.Fichada;
import bean.PersonaFisica;
import bean.PersonaJuridica;
import bean.Servicio;
import dto.ClienteDTO;
import dto.ContratacionDTO;
import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.FichadaDTO;
import dto.PersonaFisicaDTO;
import dto.PersonaJuridicaDTO;
import interfaces.SistemaPresentismo;
import srv.ClienteSrv;
import srv.ContratacionSrv;
import srv.FacturaSrv;
import srv.FichadaSrv;

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

	public void crearContratacion(ContratacionDTO contratacionDTO) throws RemoteException {

		float montoFinal = contratacionDTO.getServicio().getMonto()+contratacionDTO.getCantEmpleados()*contratacionDTO.getServicio().getAdicionalEmpleado();
		
		Contratacion contratacion = new Contratacion(
					contratacionDTO.getServicio(),
					contratacionDTO.getCliente(),
					contratacionDTO.getCantHoras(),
					contratacionDTO.getCantEmpleados(),
					contratacionDTO.getFechaInicial(),
					contratacionDTO.getFechaFinal(),
					contratacionDTO.getTipoFactura(),
					montoFinal
					);
		
		
		int ultimo = srv.ContratacionSrv.grabarContratacion(contratacion);
		Contratacion aux = srv.ContratacionSrv.getById(ultimo);
		
		FacturaDTO fDTO = new FacturaDTO (montoFinal, contratacionDTO.getTipoFactura(),contratacionDTO.getCliente(), aux);
		crearFactura(fDTO);
			//return personaFisica.getId();
	}
	
	@Override
	public void agregarEmpleado(EmpleadoDTO empleadoDTO, String cuit_cuil) throws RemoteException {
		// MovCCDAO.save(ClienteDAO.getById(dni), dtoToModel(movimientoCCDTO));
		Empleado empleado = new Empleado(
				empleadoDTO.getNombre(),
				empleadoDTO.getApellido(),
				empleadoDTO.getMail(),
				empleadoDTO.getDni(),
				empleadoDTO.getTelefono(),
				empleadoDTO.getFechaNac(),
				empleadoDTO.getLegajo()
				);
		Cliente cliente = srv.ClienteSrv.getClienteByCuit(cuit_cuil);
		cliente.setEmpleado(empleado);
		srv.ClienteSrv.grabarCliente(cliente);
	}
	
	@Override
	public void crearFactura(FacturaDTO facturaDTO) throws RemoteException {
		Factura factura = new Factura(facturaDTO.getMonto(),
				facturaDTO.getTipo(),
				facturaDTO.getCliente(),
				facturaDTO.getContratacion());
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
	public void altaFichada(FichadaDTO fichadaDTO) throws RemoteException {
		Fichada fichada = new Fichada(
				fichadaDTO.getTipo(),
				fichadaDTO.getEmpleado(),
				fichadaDTO.getHora(),
				fichadaDTO.getFecha()
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
		Factura factura = srv.FacturaSrv.getFacturaByNro(nroFactura);
		factura.setPagado(true);
		srv.FacturaSrv.grabarFactura(factura);
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

	
	public Vector<Vector<String>> getHorasTrabajadasTotales(String cuit_cuil, Date fechaInicio, Date fechaFin, Contratacion c) throws RemoteException {
		Vector<Vector<String>> vectorTabla = new Vector<Vector<String>>();
		Cliente cliente = ClienteSrv.getClienteByCuit(cuit_cuil);
		List<Fichada> fichadas = FichadaSrv.getFichadasByCliente(cliente, fechaInicio, fechaFin);
		List<Empleado> empleados = cliente.getEmpleados();
		
		
		LocalTime contE = LocalTime.of(0, 0);
		LocalTime contS = LocalTime.of(0, 0);
		int horasTotalesE = 0;
		int minutosTotalesE = 0;
		int horasTotalesS = 0;
		int minutosTotalesS = 0;
		int horasResultado = 0;
		int minutosResultado = 0;
		int minutosAusentes = 0;
		int horasAusentes = 0;
		
		for (Empleado e : empleados)
		{
			Vector<String> strs = new Vector<String>();
			
			for(Fichada f: fichadas) {
				if(f.getEmpleado().getId() == e.getId()) {		
//					if ((f.getFecha().compareTo(fechaInicio)<0) && (fechaFin.compareTo(f.getFecha()) < 0) 
//							|| (fechaInicio == f.getFecha()) || (f.getFecha() == fechaFin))  
//					{
					int horas = f.getHora().getHour();
					int minutos = f.getHora().getMinute();
					
						if(f.getTipo().equals("E")) {
							
//							contE.plusHours(horas);
//							contE.plusMinutes(minutos);
							horasTotalesE += horas;
							minutosTotalesE += minutos;
						}
						else {
//							contS.plusHours(horas);
//							contS.plusMinutes(minutos);
							horasTotalesS += horas;
							minutosTotalesS += minutos;
						}
							
//					}
				}
			}
//			Ac� tenemos en contE y contS el total de horas de entrada y de salida para el empleado buscado
				horasResultado = horasTotalesS - horasTotalesE;
				minutosResultado = minutosTotalesS - minutosTotalesE;
				
				if (minutosResultado>=60) {
					horasResultado +=(minutosResultado/60);
					minutosResultado = (minutosResultado%60);
					
				}else if (minutosResultado<0) {
					if (minutosResultado<-60) {
						horasResultado+=(minutosResultado/60);
						minutosResultado = 60 + (minutosResultado%60);
						horasResultado = horasResultado-1;
						
					}else if (minutosResultado==-60) {
						horasResultado+=(minutosResultado/60);
						minutosResultado = (minutosResultado%60);
					}else {
						horasResultado = horasResultado-1;
						minutosResultado = 60 + minutosResultado;
						
					}
				}
				
				
//				contS.minusHours(contE.getHour());
//				contS.minusMinutes(contE.getMinute());
				
				strs.add(String.valueOf(e.getLegajo()));
				strs.add(String.valueOf(e.getApellido() + " " + e.getNombre()));
				strs.add(String.valueOf(horasResultado + ":" +minutosResultado));
				
				horasAusentes = c.getCantHoras() - horasResultado;
				if (minutosResultado>0) {
					minutosAusentes = 60 - minutosResultado;
					horasAusentes -=1;
				}
				
				strs.add(String.valueOf(horasAusentes + ":" +minutosAusentes));
				vectorTabla.add(strs);
		}
		
		return vectorTabla;
	}

	@Override
	public List<Contratacion> getContratacionesCliente(String cuitEmpresa) {
		List<Contratacion> todas = ContratacionSrv.getContrataciones();
		Cliente cliente = ClienteSrv.getClienteByCuit(cuitEmpresa);
		List<Contratacion> result = new ArrayList<Contratacion>();
			
		for (Contratacion c : todas) {
			if (c.getCliente().getId()==cliente.getId()) {
				result.add(c);
			}
		}
				
		return result;
	}

}
