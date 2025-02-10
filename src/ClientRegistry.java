import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientRegistry {
    private static final Map<Accounting_itf, Integer> clientCallCount = new ConcurrentHashMap<>();

    public static void registerClient(Accounting_itf clientHost) {
        clientCallCount.putIfAbsent(clientHost, 0);
    }

    public static void incrementCallCount(Accounting_itf clientHost) {
        clientCallCount.put(clientHost, clientCallCount.getOrDefault(clientHost, 0) + 1);
    }

    public static int getCallCount(Accounting_itf clientHost) {
        return clientCallCount.getOrDefault(clientHost, 0);
    }
}