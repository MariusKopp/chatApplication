
import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public  class ChatImpl implements Chat {

	private List<Message> messageList;
 
	public ChatImpl() {
		this.messageList = new ArrayList<Message>();
	}

	@Override
	public void send(String reciever, String sender, String message) {
		Message msg = new Message(message, sender, reciever);
		messageList.add(msg);
	}

	@Override
	public List<Message> recieve(String username) {
		List<Message> recievedMessages = messageList.stream()
			.filter(msg -> msg.reciever.equals(username))
			.collect(Collectors.toList());

		return recievedMessages;
	}

}

