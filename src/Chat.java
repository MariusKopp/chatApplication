import java.rmi.*;
import java.util.List;

public interface Chat extends Remote {

	public void send(String receiver, String sender, String message) throws RemoteException;

	public void sendAll(String sender, String message) throws RemoteException;

	public List<Message> recieve(String username) throws RemoteException;
}
