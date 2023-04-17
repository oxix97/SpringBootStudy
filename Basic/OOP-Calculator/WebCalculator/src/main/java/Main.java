import server.ApplicationServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new ApplicationServer(8080).start();
    }
}
