package mypackege;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class Leitor {

	public static void main(String[] args) {
		
		String mensagem = "";
		while (!"Stop".equalsIgnoreCase(mensagem)) {

			try {

				IServico servico = (IServico) Naming.lookup("local");

				if (servico.ehNovaMenssagem()) {
					System.out.println(servico.getAtributo());
				}

				mensagem = servico.getAtributo();

			} catch (MalformedURLException | RemoteException | NotBoundException e) {

				JOptionPane.showMessageDialog(null, "[!] Erro no Leitor: " + e.getMessage());
			}

		}
	
	}

}
