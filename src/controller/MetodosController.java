package controller;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class MetodosController extends Thread {
	private JTextField vencedor;
	private JTextField perdedor;
	private int velocidade;
	private Random aleatorio = new Random();
	private int distancia = 350;
	private int caminhoAndado = 24;
	static int lugar;
	private JLabel carro1;
	private JLabel carro2;
	private String nome;

	public MetodosController(String nome, JTextField vencedor, JLabel carro1, JLabel carro2, JTextField perdedor) {
		this.perdedor = perdedor;
		this.vencedor = vencedor;
		this.carro1 = carro1;
		this.carro2 = carro2;
		this.nome = nome;

	}

	@Override
	public void run() {
		Corrida();

	}

	private void Corrida() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		while (caminhoAndado < distancia) {
			try {
				velocidade = aleatorio.nextInt((10) + 1);
				caminhoAndado += velocidade;

				carro1.setBounds(caminhoAndado + velocidade, 53, 70, 14);
				velocidade = aleatorio.nextInt((10) + 1);
				caminhoAndado += velocidade;
				carro2.setBounds(caminhoAndado + velocidade, 122, 70, 14);

				Thread.sleep(80);

				System.out.println("VELOCIDADE " + velocidade + "caminho andado " + caminhoAndado);

				if (caminhoAndado >= distancia) {
					lugar++;
					if (lugar == 1) {
						vencedor.setText(nome);
					} else if (lugar == 2){
						perdedor.setText(nome);
					}
					System.out.println(nome+  " "+ lugar + "º Lugar");
				} 

			

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}
	}

}