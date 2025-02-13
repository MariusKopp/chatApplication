import java.io.*;
import java.util.List;

public class FileUtils {
    public static <T> void saveListToFile(List<T> list, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))
            oos.writeObject(list);
            System.out.println("List saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadListFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
        // ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // e.printStackTrace();
            return null;
        }
    }
}