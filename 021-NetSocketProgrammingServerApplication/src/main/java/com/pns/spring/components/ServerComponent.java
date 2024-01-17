package com.pns.spring.components;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServerComponent implements ApplicationRunner {

	private static final int PORT = 4507;

	private void startServer() {
			try (ServerSocket serverSocket = new ServerSocket(PORT);
					Socket client = serverSocket.accept();
					DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
					DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
					Scanner scanner = new Scanner(System.in)) {
				System.out.printf("Client Connected(%s): Type 'exit' to stop\n", client.getRemoteSocketAddress());

				//thread to write to client
				new Thread(() -> {
					while (!client.isClosed()) {
						try {
							String outMessage = scanner.nextLine();
							dataOutputStream.writeUTF(outMessage);
							if (outMessage.equalsIgnoreCase("exit"))
								client.close();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}).start();
				
				//thread to listen from client
				new Thread(()->{
					while (!client.isClosed()) {
						try {
							String inMessage = dataInputStream.readUTF();
							System.out.println("Client-->" + inMessage);
							if (inMessage.equalsIgnoreCase("exit")) {
								System.err.println("Client has disconnected");
								client.close();
							}
						} catch (Exception e) {
							System.err.println("Client has disconnected");
							break;
						}
					}
				}).start();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		startServer();
	}

}
