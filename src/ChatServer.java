
import java.rmi.*; 
import java.rmi.server.*; 
import java.rmi.registry.*;
import java.util.List;

public class ChatServer {

 	public static void  main(String [] args) {

		try {
			ChatImpl ch = new ChatImpl ();
			Chat ch_stub = (Chat) UnicastRemoteObject.exportObject(ch, 0);

			Registry registry = null;
			if (args.length>0)
				registry= LocateRegistry.getRegistry(Integer.parseInt(args[0])); 
			else
				registry = LocateRegistry.getRegistry();
			registry.rebind("ChatService", ch_stub);

			System.out.println ("Server ready");
		} catch (Exception e) {
			System.err.println("Error on server :" + e) ;
			e.printStackTrace();
		}
  	}
}
