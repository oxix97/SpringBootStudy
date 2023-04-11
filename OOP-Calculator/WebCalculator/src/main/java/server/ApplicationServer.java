package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ApplicationServer {
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationServer.class);

    public ApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("ApplicationServer started {} port.", port);

            Socket clientSocket;
            logger.info("ApplicationServer waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("ApplicationServer client connected!!");

                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    String line;
                    while ((line = br.readLine()) != "") {
                        System.out.println(line);
                    }

                }
            }
        }
    }

}
