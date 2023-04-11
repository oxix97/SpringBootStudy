package server;

import calculator.OOPCalculator;
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

                    HttpRequest httpRequest = new HttpRequest(br);

                    if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                        int result = OOPCalculator.calculate(operand1, operand2, operator);
                        byte[] body = String.valueOf(result).getBytes();


                        HttpResponse response = new HttpResponse(dos);
                        response.response200Header("application/json",body.length);
                        response.responseBody(body);
                    }
                }
            }
        }
    }

}
