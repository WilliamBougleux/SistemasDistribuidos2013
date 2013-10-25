package sistemas.atividade2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(1405);
	
		System.out.println("Server running on 1404 ...");
		
		while(true){
			final Socket socket = serverSocket.accept(); 
			
			new Thread(){
				public void run(){
					try {
						new Iniciar(socket);
					} catch (IOException e) {
						System.out.println("Servidor: ");
						e.printStackTrace();
					}
				}
			}.start();
			//tratar finalidade
			//serverSocket.close();	
		}
	}

}
