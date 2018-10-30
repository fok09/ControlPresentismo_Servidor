package server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import interfaces.SistemaPresentismo;
import remoteObjects.ControladorPresentismoRO;

public class Server {
	SistemaPresentismo objetoRemoto;
//TDASistemaCine objetoRemoto;
	
	public static void main(String[] args)
	{
		new Server();
	}
	
	public Server() {
		iniciar();
	}
	
    public void iniciar() {
    	try {
<<<<<<< HEAD
//    		LocateRegistry.createRegistry(1099);	

			//e.printStackTrace();
		}finally {
			
=======
    		LocateRegistry.createRegistry(1099);
    		SistemaPresentismo controladorPresentismo = new ControladorPresentismoRO();
    		Naming.rebind ("//localhost/ControladorPresentismo", controladorPresentismo);
            System.out.println("Fijado en //localhost/ControladorPresentismo");
		} catch (Exception e) {
			e.printStackTrace();
>>>>>>> refs/remotes/origin/master
		}

    }}
