import java.rmi.*;
import java.rmi.registry.*;

public class ChatClient {
  	public static void main(String [] args) {
		
		try {
			if (args.length < 2) {
				System.out.println("Usage: java ChatClient <rmiregistry host> <rmiregistry port>");
				return;
			}

			String host = args[0];
			int port = Integer.parseInt(args[1]);

			Registry registry = LocateRegistry.getRegistry(host, port); 
			System.out.println("Registry\n" + registry);
			Chat h = (Chat) registry.lookup("ChatService");


			while(true) {

			}
			
			String res = h.sayHello(clientInfo);
			System.out.println(res);

		} catch (Exception e)  {
	//		System.err.println("Error on client: " + e);
			e.printStackTrace();
		}
	}
}
