import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.util.Map;

public  class Registry_itfImpl implements Registry_itf {

	public Registry_itfImpl() throws RemoteException {
        super();
    }

    public void register(Accounting_itf client) throws RemoteException{
        // try{
		// 	ClientRegistry.registerClient(client);
		// 	// System.out.println("from client: " + client.getName());
		// } catch (RemoteException e){
		// 	e.printStackTrace();
		// }
		ClientRegistry.registerClient(client);
    }
}