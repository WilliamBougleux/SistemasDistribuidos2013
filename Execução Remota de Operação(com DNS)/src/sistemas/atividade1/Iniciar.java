package sistemas.atividade1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Iniciar {

	private final Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private final float SOMA = 1, PRODUTO = 2, FATORIAL = 3, FECHAR = 4;
	private boolean fechar = false;
	
	public Iniciar(Socket socket)throws IOException {
		this.socket = socket;
		in = new ObjectInputStream(this.socket.getInputStream());
		out = new ObjectOutputStream(this.socket.getOutputStream());
		while(!fechar)
			Opcao();
	}

	public void Opcao() throws IOException {
		float opc, x, y;
		int z;
		opc = in.readInt();
		
		if(opc == SOMA){
			out.writeBoolean(true);
			out.flush();
			x = in.readFloat();
			y = in.readFloat();
			out.writeFloat(soma(x,y));
			out.flush();
		}else
		if(opc == PRODUTO){
			out.writeBoolean(true);
			out.flush();
			x = in.readFloat();
			y = in.readFloat();
			out.writeFloat(produto(x,y));
			out.flush();
		}else
		if(opc == FATORIAL){
			out.writeBoolean(true);
			out.flush();
			z = in.readInt();
			out.writeFloat(fatorial(z));
			out.flush();
		}else
		if(opc == FECHAR){
			fechar();
		}else
		{
			out.writeBoolean(false);
			out.flush();
		}
		
	}

	public void fechar()throws IOException{
		in.close();
		out.close();
		socket.close();
		fechar = true;
	}
	
	public float soma(float x, float y){
		return x + y;
	}
	
	public float produto(float x, float y){
		return x * y;
	}
	
	public Float fatorial(int x){
		float resposta= 1;
		for(int i = x; i >= 1; i--)
			resposta = resposta * i;
		
		return resposta;
	}

}