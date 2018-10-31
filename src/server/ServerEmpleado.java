package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import interfaces.CargaEmpleado;
import remoteObjects.CargaEmpleadoRO;

public class ServerEmpleado {
    
	CargaEmpleado objetoRemoto;
	
	public static void main(String[] args)
	{
		new ServerEmpleado();
	}
	
	public ServerEmpleado() {
		iniciar();
	}
	
    public void iniciar() {
    	try {
    		LocateRegistry.createRegistry(1099);	
            CargaEmpleado carga = new CargaEmpleadoRO();
            Naming.rebind ("//localhost/CargaEmpleado", carga);
            System.out.println("Fijado en //localhost/CargaEmpleado");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
