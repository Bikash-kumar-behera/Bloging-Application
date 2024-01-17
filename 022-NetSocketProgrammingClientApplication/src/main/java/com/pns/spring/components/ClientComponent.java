package com.pns.spring.components;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientComponent implements ApplicationRunner {

	private static final String SERVER_ADDRESS = "localhost";
	private static final int PORT = 4507;

	private void connectServer() {
		try (Socket server = new Socket(SERVER_ADDRESS, PORT);
				DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
				DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
				Scanner scanner = new Scanner(System.in)) {
			System.out.println("Client Connected: Type 'exit' to stop");

			//thread to write to server
			new Thread(() -> {
				while (!server.isClosed()) {
					try {
						String outMessage = scanner.nextLine();
						dataOutputStream.writeUTF(outMessage);
						if (outMessage.equalsIgnoreCase("exit"))
							server.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}).start();
			
			//thread to listen from server
			new Thread(()->{
				while (!server.isClosed()) {
					try {
						String inMessage = dataInputStream.readUTF();
						System.out.println("Server-->" + inMessage);
						if (inMessage.equalsIgnoreCase("exit")) {
							System.err.println("Server has disconnected");
							server.close();
						}
					} catch (Exception e) {
						System.err.println("Server has disconnected");
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
		connectServer();
	}
}
