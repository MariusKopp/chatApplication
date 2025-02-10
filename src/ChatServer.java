
import java.rmi.*; 
import java.rmi.server.*; 
import java.rmi.registry.*;
import java.util.List;

public class HelloServer {

 	public static void  main(String [] args) {

		try {
			// Create a Hello remote object
			HelloImpl h = new HelloImpl ("Hello world !");
			// Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);
			Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);

			Registry_itfImpl r = new Registry_itfImpl ();
			Registry_itf r_stub = (Registry_itf) UnicastRemoteObject.exportObject(r, 0);

			HelloImpl2 h2 = new HelloImpl2("Hello world!");
			Hello2 h2_stub = (Hello2) UnicastRemoteObject.exportObject(h2, 0);

			// Register the remote object in RMI registry with a given identifier
			Registry registry = null;
			if (args.length>0)
				registry= LocateRegistry.getRegistry(Integer.parseInt(args[0])); 
			else
				registry = LocateRegistry.getRegistry();
			registry.rebind("HelloService", h_stub);
			registry.rebind("RegisterService", r_stub);
			registry.rebind("Hello2Service", h2_stub);

			System.out.println ("Server ready");
			System.out.println("h_stub below:\n" + h_stub);


		} catch (Exception e) {
			System.err.println("Error on server :" + e) ;
			e.printStackTrace();
		}
  	}
}
