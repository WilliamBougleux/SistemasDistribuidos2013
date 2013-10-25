package sistemas.atividade2;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Cliente {
	
	public static void main(String[] args) {
		float x, y;
		int  opc = 0, z;
		AcessarSocket acessarSocket;
		
		do{
				opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a opção:\n1 - Somar;\n2 - Produto;\n3 - Fatorial;\n0 - SAIR;", 
										"Atividade", JOptionPane.INFORMATION_MESSAGE));
				try {
					switch (opc) {
					case 1:
						acessarSocket = new AcessarSocket("somar");
						if(acessarSocket.isConectado()){
							x = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de x","Atividade", JOptionPane.INFORMATION_MESSAGE));
							y = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de y","Atividade", JOptionPane.INFORMATION_MESSAGE));
							JOptionPane.showMessageDialog(null, "O valor da soma de " + x + " + "+ y + ": " + acessarSocket.soma(x, y), "Atividade", JOptionPane.INFORMATION_MESSAGE);
							acessarSocket.desconectar();
						}
						acessarSocket = null;
						break;
					case 2:
						acessarSocket = new AcessarSocket("produto");
						if(acessarSocket.isConectado()){
							x = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de x","Atividade", JOptionPane.INFORMATION_MESSAGE));
							y = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de y","Atividade", JOptionPane.INFORMATION_MESSAGE));
							JOptionPane.showMessageDialog(null, "O valor do Produto de " + x + " * "+ y + ": " + acessarSocket.produto(x, y), "Atividade", JOptionPane.INFORMATION_MESSAGE);
							acessarSocket.desconectar();
						}
						acessarSocket = null;
						break;
					case 3:
						acessarSocket = new AcessarSocket("fat");
						if(acessarSocket.isConectado()){
							z = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor de x","Atividade", JOptionPane.INFORMATION_MESSAGE));
							JOptionPane.showMessageDialog(null, "O valor do fatorial de " + z + ": " + acessarSocket.fatorial(z), "Atividade", JOptionPane.INFORMATION_MESSAGE);
							acessarSocket.desconectar();
						}
						acessarSocket = null;
						break;

					default:
						break;
					}
				}catch (IOException e) {
					e.printStackTrace();
					}
				catch (Exception e) {
					
				} 
			}while(opc != 0);
		
	}

}
