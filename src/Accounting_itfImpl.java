import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public  class Accounting_itfImpl extends UnicastRemoteObject implements Accounting_itf {

	public Accounting_itfImpl() throws RemoteException {
        super();
    }

    public void numberOfCalls(int number) throws RemoteException{
        // try{
		// 	System.out.println("Number of calls: " + number);
		// } catch (RemoteException e){
		// 	e.printStackTrace();
		// }
		System.out.println("Number of calls: " + number);
    }
}