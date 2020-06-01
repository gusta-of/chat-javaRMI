package mypackege;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServico extends Remote {
	
	public void AlteraAtributo(String atributo) throws RemoteException;
	public String getAtributo() throws RemoteException;
	public boolean ehNovaMenssagem() throws RemoteException;
}
