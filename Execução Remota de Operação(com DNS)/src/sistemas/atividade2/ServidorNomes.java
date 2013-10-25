package sistemas.atividade2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorNomes {		

	public static void main(String[] args) throws IOException {
				ServerSocket serverSocket = new ServerSocket(1404);
			
				System.out.println("Server running on 1404 ...");
				
				while(true){
					final Socket socket = serverSocket.accept(); 
					
					new Thread(){
						public void run(){
							try {
								EnviarNomes(socket);
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
	

	public static ArrayList<String> BuscaNome(String chave){
	
		
		ArrayList<String> impFat = new ArrayList<String>();
		impFat.add("10.3.1.19");
		impFat.add("10.3.1.18");
		impFat.add("10.3.1.20");
		
		ArrayList<String> impSoma = new ArrayList<String>();
		impFat.add("10.3.1.19");
		impFat.add("10.3.1.18");
		impFat.add("10.3.1.20");
		
		ArrayList<String> impProd = new ArrayList<String>();
		impFat.add("10.3.1.19");
		impFat.add("10.3.1.18");
		impFat.add("10.3.1.20");
		
		/*for (String ip:impFat){
		//	JOptionPane.showMessageDialog(null, ip);
		}
		*/
		HashMap<String, ArrayList<String>> tabelaNomes = new HashMap<String, ArrayList<String>>();
		tabelaNomes.put("fat", impFat);
		tabelaNomes.put("somar", impSoma);
		tabelaNomes.put("produto", impProd);
				
		
		return tabelaNomes.get(chave);
				
		
	}
	
	public static void EnviarNomes(Socket socket)throws IOException{;
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		String chave;
		Object lista;

		chave = in.readUTF();
		
		lista = BuscaNome(chave);
		out.writeObject(lista);
		out.flush();
		
		in.close();
		out.close();
	}

}
