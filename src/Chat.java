import java.rmi.*;
import java.util.List;

public interface Chat extends Remote {

	public void send(String reciever, String sender, String message);

	public List<Message> recieve(String username);
}
