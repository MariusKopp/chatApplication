
import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.rmi.server.UnicastRemoteObject;

public  class ChatImpl implements Chat {

	private List<Message> messageList;
 
	public ChatImpl() throws RemoteException {
		this.messageList = new ArrayList<Message>();
	}

	@Override
	public void send(String receiver, String sender, String message) throws RemoteException{
		// try{
			Message msg = new Message(message, sender, receiver);
			this.messageList.add(msg);
		// } catch (RemoteException e){
		// 	e.printStackTrace();
		// }
	}

	@Override
	public List<Message> recieve(String username) throws RemoteException {
		List<Message> recievedMessages = null;
		// try{
			recievedMessages = this.messageList.stream()
			.filter(msg -> msg.receiver.equals(username))
			.collect(Collectors.toList());
		// } catch (RemoteException e){
		// 	e.printStackTrace();
		// }
		return recievedMessages;
	}

	// public Message recieve(String username) throws RemoteException{
	// 	return new Message("message delivered", "me", "you");
	// }

}

