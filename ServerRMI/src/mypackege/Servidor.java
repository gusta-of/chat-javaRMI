package mypackege;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends Servico {

	public static void main(String[] args) {

		try {

			Servico servico = new Servico();
			String local = "local";

			IServico stub = (IServico) UnicastRemoteObject.exportObject(servico, 0);

			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind(local, stub);

			System.out.println("Servidor pronto!");
			
		} catch (RemoteException e) {
			System.out.println("[!] Erro no servidor: " + e.getMessage());
		} catch (AlreadyBoundException e) {
			System.out.println("[!] Erro no bind: " + e.getMessage());
		}

	}

}
