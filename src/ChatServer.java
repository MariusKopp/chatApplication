
import java.rmi.*; 
import java.rmi.server.*; 
import java.rmi.registry.*;
import java.util.List;

public class ChatServer {

 	public static void  main(String [] args) {

		try {
			// Create a Hello remote object
			ChatImpl h = new ChatImpl ();
			// Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);
			Chat h_stub = (Chat) UnicastRemoteObject.exportObject(h, 0);

			// Register the remote object in RMI registry with a given identifier
			Registry registry = null;
			if (args.length>0)
				registry= LocateRegistry.getRegistry(Integer.parseInt(args[0])); 
			else
				registry = LocateRegistry.getRegistry();
			registry.rebind("ChatService", h_stub);

			System.out.println ("Server ready");
			System.out.println("h_stub below:\n" + h_stub);


		} catch (Exception e) {
			System.err.println("Error on server :" + e) ;
			e.printStackTrace();
		}
  	}
}
