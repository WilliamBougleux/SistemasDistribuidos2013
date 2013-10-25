package sistemas.atividade1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AcessarSocket {
	private Socket socket;
	private ObjectOutputStream  saida;
	private ObjectInputStream entrada;
	
	public AcessarSocket(String ip)throws IOException{
		socket = new Socket( ip, 1404);

		saida = new ObjectOutputStream(socket.getOutputStream());
		entrada = new ObjectInputStream(socket.getInputStream());
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
	

	public void desconectar()throws IOException{
		saida.writeInt(4);
		saida.flush();
		saida.close();
		entrada.close();
		socket.close();
	}

}