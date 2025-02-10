import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public  class Info_itfImpl extends UnicastRemoteObject implements Info_itf {

	public Info_itfImpl() throws RemoteException {
        super();
    }

	public String getName() throws RemoteException {
		// try{
		// 	String client = RemoteServer.getClientHost();
		// 	System.out.println("Method called from: " + client + " with parameter: " + clientName);
		// } catch (ServerNotActiveException e){
		// 	e.printStackTrace();
		// }

		return "client Name °_°" ;
	}
}