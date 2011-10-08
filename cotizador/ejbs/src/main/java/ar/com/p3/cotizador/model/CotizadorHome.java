package ar.com.p3.cotizador.model;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;

public interface CotizadorHome extends EJBHome {
		
	public CotizadorObject create () throws RemoteException, CreateException;
}
