
import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

public  class HelloImpl implements Hello {

	private String message;
 
	public HelloImpl(String s) {
		message = s ;
	}

	// public String sayHello(String clientName) throws RemoteException {
	public String sayHello(Info_itf client){
		// try{
		// 	String client = RemoteServer.getClientHost();
		// 	System.out.println("Method called from: " + client + " with parameter: " + clientName);
		// } catch (ServerNotActiveException e){
		// 	e.printStackTrace();
		// }
		try{
			System.out.println("from client: " + client.getName());
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return message ;
	}

}

