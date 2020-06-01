package mypackege;

import java.rmi.RemoteException;

public class Servico implements IServico  {

	private String Atributo = "";
	private boolean novaMenssagem = false;
	
	@Override
	public void AlteraAtributo(String atributo) throws RemoteException {
		Atributo = atributo;
		this.novaMenssagem = true;
	}

	@Override
	public String getAtributo() throws RemoteException {
		this.novaMenssagem = false;
		return Atributo;
	}

	@Override
	public boolean ehNovaMenssagem() throws RemoteException {
		return novaMenssagem;
	}
}
