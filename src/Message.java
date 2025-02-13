import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public String text;

    public String sender;

    public String receiver;

    public Message(String text, String sender, String receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return sender + " -> " + receiver + ": " + text;
    }
}
