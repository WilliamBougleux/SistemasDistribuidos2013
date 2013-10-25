package sistemas.atividade1;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Cliente {
	
	public static void main(String[] args) {
		float x, y;
		int  opc = 0, z;
		String ip;
		
		ip = JOptionPane.showInputDialog(null, "Informe o IP", "Atividade", JOptionPane.INFORMATION_MESSAGE);
		
		try {
			AcessarSocket acessarSocket = new AcessarSocket(ip);
			do{
				opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a opção:\n1 - Somar;\n2 - Produto;\n3 - Fatorial;\n0 - SAIR;", 
										"Atividade", JOptionPane.INFORMATION_MESSAGE));
				try {
					switch (opc) {
					case 1:
						x = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de x","Atividade", JOptionPane.INFORMATION_MESSAGE));
						y = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de y","Atividade", JOptionPane.INFORMATION_MESSAGE));
						JOptionPane.showMessageDialog(null, "O valor da soma de " + x + " + "+ y + ": " + acessarSocket.soma(x, y), "Atividade", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						x = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de x","Atividade", JOptionPane.INFORMATION_MESSAGE));
						y = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor de y","Atividade", JOptionPane.INFORMATION_MESSAGE));
						JOptionPane.showMessageDialog(null, "O valor do Produto de " + x + " * "+ y + ": " + acessarSocket.produto(x, y), "Atividade", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 3:
						z = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor de x","Atividade", JOptionPane.INFORMATION_MESSAGE));
						JOptionPane.showMessageDialog(null, "O valor do fatorial de " + z + ": " + acessarSocket.fatorial(z), "Atividade", JOptionPane.INFORMATION_MESSAGE);
						break;

					default:
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}while(opc != 0);
			acessarSocket.desconectar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
