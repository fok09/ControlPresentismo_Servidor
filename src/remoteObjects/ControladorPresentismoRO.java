package remoteObjects;

import controlador.ControladorPresentismo;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.FacturaDTO;
import dto.FichadaDTO;
import dto.PersonaFisicaDTO;
import dto.PersonaJuridicaDTO;
import interfaces.SistemaPresentismo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControladorPresentismoRO extends UnicastRemoteObject implements SistemaPresentismo {


    public ControladorPresentismoRO() throws RemoteException {
        super();
    }

	@Override
	public void crearClienteJuridico(PersonaJuridicaDTO personaJuridicaDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearClienteFisico(PersonaFisicaDTO personaFisicaDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
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
	public void agregarEmpleado(EmpleadoDTO empleadoDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaFichada(FichadaDTO fichadaDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearFacturaMensual(FacturaDTO facturaDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearFacturaSemanal(FacturaDTO facturaDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearFacturaEventual(FacturaDTO facturaDTO) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarPago(int nroFactura) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

//    @Override
//    public void crearArticulo(ArticuloDTO articuloDTO) throws RemoteException {
//        ControladorArticulo.getInstance().crearArticulo(articuloDTO);
//    }
//
//    @Override
//    public ArticuloDTO obtenerArticulo(Integer id) throws RemoteException {
//        return ControladorArticulo.getInstance().obtenerArticulo(id);
//    }
//
//    @Override
//    public List<ArticuloDTO> obtenerArticulosFaltantes() throws RemoteException {
//        return ControladorArticulo.getInstance().obtenerArticulosFaltantes();
//    }
//
//    @Override
//    public List<ArticuloDTO> obtenerArticulos() throws RemoteException {
//        return ControladorArticulo.getInstance().obtenerArticulos();
//    }
//
//    @Override
//    public void generarMovimientoPorRotura(Integer loteId, MovimientoPorEliminacionDTO movimientoPorEliminacionDTO) throws RemoteException {
//        ControladorArticulo.getInstance().generarMovimientoPorRotura(loteId,movimientoPorEliminacionDTO);
//    }
//
//    @Override
//    public void generarMovimientoPorAjustePositivo(Integer loteId, MovimientoPorAjusteDTO movimientoPorAjusteDTO) throws RemoteException {
//        ControladorArticulo.getInstance().generarMovimientoPorAjustePositivo(loteId, movimientoPorAjusteDTO);
//    }
//
//    @Override
//    public void generarMovimientoPorAjusteNegativo(Integer loteId, MovimientoPorAjusteDTO movimientoPorAjusteDTO) throws RemoteException {
//        ControladorArticulo.getInstance().generarMovimientoPorAjusteNegativo(loteId,movimientoPorAjusteDTO);
//    }
}
