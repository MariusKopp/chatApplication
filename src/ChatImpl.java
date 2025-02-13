
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
	private String filename = "msgHistory.dat";
 
	public ChatImpl() throws RemoteException {
		// this.messageList = new ArrayList<Message>();
		// try{
			this.messageList = FileUtils.loadListFromFile(this.filename);
		// } catch(Exception e){
		if (this.messageList == null)
			this.messageList = new ArrayList<Message>();
		// }
	}

	@Override
	public void send(String receiver, String sender, String message) throws RemoteException{
		// try{
			Message msg = new Message(message, sender, receiver);
			this.messageList.add(msg);
			FileUtils.saveListToFile(this.messageList, this.filename);
			// for(Message m : this.messageList){
			// 	System.out.println(m);
			// }
		// } catch (RemoteException e){
		// 	e.printStackTrace();
		// }
	}

	@Override
	public void sendAll(String sender, String message) throws RemoteException{
		this.send("all", sender, message);
	}

	@Override
	public List<Message> recieve(String username) throws RemoteException {
		List<Message> recievedMessages = null;//new ArrayList<>();

		// for (Message msg : this.messageList){
		// 	if(msg.receiver.equals(username)){
		// 		recievedMessages.add(msg);
		// 	}
		// }
		// try{
			recievedMessages = this.messageList.stream()
			.filter(msg -> msg.receiver.equals(username) || msg.receiver.equals("all"))
			.collect(Collectors.toList());
		// } catch (RemoteException e){
		// 	e.printStackTrace();
		// }
		return recievedMessages;
	}

}

