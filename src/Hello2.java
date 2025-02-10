import java.rmi.*;

public interface Hello2 extends Remote {
	// public String sayHello(String clientName)  throws RemoteException;
	public String sayHello(Accounting_itf client)  throws RemoteException;
}
