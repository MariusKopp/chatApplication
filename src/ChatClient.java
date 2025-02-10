import java.rmi.*;
import java.rmi.registry.*;

public class HelloClient {
  	public static void main(String [] args) {
		
		try {
			if (args.length < 2) {
				System.out.println("Usage: java HelloClient <rmiregistry host> <rmiregistry port>");
				return;
			}

			String host = args[0];
			int port = Integer.parseInt(args[1]);

			Registry registry = LocateRegistry.getRegistry(host, port); 
			System.out.println("Registry\n" + registry);
			Hello h = (Hello) registry.lookup("HelloService");
			Accounting_itf acc = new Accounting_itfImpl();

			// register
			Registry_itf r = (Registry_itf) registry.lookup("RegisterService");
			r.register(acc);

			Hello2 h2 = (Hello2) registry.lookup("Hello2Service");
			// Remote method invocation
			// String res = h.sayHello("client Honza");
			Info_itf clientInfo = new Info_itfImpl();
			String res = h.sayHello(clientInfo);
			System.out.println(res);

			String res2 = h2.sayHello(acc);
			System.out.println(res2);

		} catch (Exception e)  {
	//		System.err.println("Error on client: " + e);
			e.printStackTrace();
		}
	}
}
