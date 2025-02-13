import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ChatClient {
  	public static void main(String [] args) {
		
		try {
			if (args.length < 3) {
				System.out.println("Usage: java ChatClient <rmiregistry host> <rmiregistry port> <username>");
				return;
			}

			String host = args[0];
			int port = Integer.parseInt(args[1]);
			String username = args[2];

			Registry registry = LocateRegistry.getRegistry(host, port); 
			System.out.println("Registry\n" + registry);
			Chat ch = (Chat) registry.lookup("ChatService");

			Scanner scanner = new Scanner(System.in);

			while(true) {
				System.out.println("\nChat App Menu (" + username + "):");
				System.out.println("1. List messages");
				System.out.println("2. Send a message");
				System.out.println("3. Exit");
				System.out.print("Choose an option: ");
				
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				
				switch (choice) {
					case 1:
						// System.out.print("Enter your name to view your messages: ");
						// String user = scanner.nextLine();

						List<Message> myMessages = ch.recieve(username);
						// List<Message> myMessages = new ArrayList<>();
						// myMessages.add(ch.recieve(username));
						System.out.println("My messages are\n");
						for (Message msg : myMessages){
							System.out.println(msg);
						}
						
						// System.out.println("\nMessages for " + user + ":");
						// messages.stream()
						// 		.filter(msg -> msg.getReceiver().equals(user))
						// 		.forEach(System.out::println);
						break;
					case 2:
						// System.out.print("Enter your name: ");
						// String sender = scanner.nextLine();
						
						System.out.print("Enter receiver's name: ");
						String receiver = scanner.nextLine();
						
						System.out.print("Enter message content: ");
						String content = scanner.nextLine();
						
						// Message message = new Message(sender, receiver, content);
						ch.send(username, receiver, content);
						System.out.println("Message sent!");
						break;
					case 3:
						System.out.println("Exiting...");
						return;
					default:
						System.out.println("Invalid option, please try again.");
				}
			}
			
			// String res = h.sayHello(clientInfo);
			// System.out.println(res);

		} catch (Exception e)  {
	//		System.err.println("Error on client: " + e);
			e.printStackTrace();
		}
	}
}
