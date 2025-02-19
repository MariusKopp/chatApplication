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
			if(username.equals("all")){
				System.out.println("You cannot log in as 'all'. Choose another username.");
				return;
			}

			Registry registry = LocateRegistry.getRegistry(host, port); 
			Chat ch = (Chat) registry.lookup("ChatService");

			Scanner scanner = new Scanner(System.in);

			while(true) {
				System.out.println("\nChat App Menu (" + username + "):");
				System.out.println("1. List messages");
				System.out.println("2. Send a message");
				System.out.println("3. Send to all");
				System.out.println("4. Exit");
				System.out.print("Choose an option: ");
				
				int choice = scanner.nextInt();
				scanner.nextLine();
				String content = "";
				switch (choice) {
					case 1:
						List<Message> myMessages = ch.recieve(username);
						System.out.println("My messages are\n");
						for (Message msg : myMessages){
							System.out.println(msg);
						}
						break;
					case 2:
						System.out.print("Enter receiver's name: ");
						String receiver = scanner.nextLine();
						
						System.out.print("Enter message content: ");
						content = scanner.nextLine();
						
						ch.send(receiver, username, content);
						System.out.println("Message sent!");
						break;
					case 3:
						System.out.print("Enter message content: ");
						content = scanner.nextLine();
						
						ch.sendAll(username, content);
						System.out.println("Message sent!");
						break;
					case 4:
						System.out.println("Exiting...");
						return;
					default:
						System.out.println("Invalid option, please try again.");
				}
			}
		} catch (Exception e)  {
			e.printStackTrace();
		}
	}
}
