package mypackege;

import java.rmi.Naming;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

	private static IServico servico = null;
	private static Scanner scan;

	public static void main(String[] args) {
		String local = "local";

		scan = new Scanner(System.in);

		System.out.println("Escreva seu nome para Iniciar o chat: ");
		String nome = scan.nextLine();

		String mensagem = "";

		while (!nome.isEmpty()) {
			try {

				servico = (IServico) Naming.lookup(local);
				
				if(mensagem.isEmpty()) {
					System.out.println("[ " + nome.toUpperCase() + " ]: " + "Entrou no chat!");
				}
				
				System.out.println("Digite algo: ");
				mensagem = scan.nextLine();
				
				servico.AlteraAtributo("[" + nome + "] disse: " + mensagem);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "[!] Erro no Client :" + e.getMessage());
			}

		}
	}

}
