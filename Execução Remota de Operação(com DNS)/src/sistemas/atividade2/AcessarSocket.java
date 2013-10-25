package sistemas.atividade2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class AcessarSocket {
	private Socket socket;
	private ObjectOutputStream  saida;
	private ObjectInputStream entrada;
	private ArrayList<String> ips;
	private boolean conectado = false;
	
	public AcessarSocket(String chave)throws IOException, ClassNotFoundException{
		socket = new Socket( "10.3.1.20", 1404);

		saida = new ObjectOutputStream(socket.getOutputStream());
		entrada = new ObjectInputStream(socket.getInputStream());
		
		saida.writeUTF(chave);
		saida.flush();
		
		ips = (ArrayList<String>) entrada.readObject();
		
		saida.close();
		entrada.close();
		socket.close();
		
		AcessarSocketMetodo(ips);
	}
	
	public void AcessarSocketMetodo(ArrayList<String> ips){
		for (String ip:ips){
			try {
				socket = new Socket( ip, 1405);
				saida = new ObjectOutputStream(socket.getOutputStream());
				entrada = new ObjectInputStream(socket.getInputStream());
				conectado = true;
				break;
			} catch (NoRouteToHostException e) {
				conectado = false;
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
			
	}

	public Float soma(float x, float y) throws IOException {
		Float resposta = null;
		saida.writeInt(1);
		saida.flush();

		if(entrada.readBoolean()){
			saida.writeFloat(y);
			saida.flush();
			saida.writeFloat(x);
			saida.flush();
			resposta = entrada.readFloat();
			
		}
		return resposta;		
	}
	
	public Float produto(float x, float y) throws IOException {
		Float resposta = null;
		saida.writeInt(2);
		saida.flush();

		if(entrada.readBoolean()){
			saida.writeFloat(x);
			saida.flush();
			saida.writeFloat(y);
			saida.flush();
			resposta = entrada.readFloat();
			
		}
		return resposta;		
	}
	
	public Float fatorial(int x) throws IOException {
		Float resposta = null;
		saida.writeInt(3);
		saida.flush();

		if(entrada.readBoolean()){
			saida.writeInt(x);
			saida.flush();
			resposta = entrada.readFloat();
			
		}
		return resposta;		
	}	
	
	

	public boolean isConectado() {
		return conectado;
	}

	public void desconectar()throws IOException{
		saida.writeInt(4);
		saida.flush();
		saida.close();
		entrada.close();
		socket.close();
	}

}