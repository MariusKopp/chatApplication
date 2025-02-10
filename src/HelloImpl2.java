
import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

public  class HelloImpl2 implements Hello2 {

	private String message;
 
	public HelloImpl2(String s) {
		message = s ;
	}

	// public String sayHello(String clientName) throws RemoteException {
	public String sayHello(Accounting_itf client){
		// try{
		// 	String client = RemoteServer.getClientHost();
		// 	System.out.println("Method called from: " + client + " with parameter: " + clientName);
		// } catch (ServerNotActiveException e){
		// 	e.printStackTrace();
		// }
		try{
            ClientRegistry.incrementCallCount(client);
            client.numberOfCalls(ClientRegistry.getCallCount(client));
			// System.out.println("from client: " + client.numberOfCalls(ClientRegistry.getCallCount(client)));
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return message ;
	}

}

