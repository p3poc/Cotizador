package ar.com.p3.cotizador.model;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

import ar.com.p3.cotizador.model.entities.Cobertura;
import ar.com.p3.cotizador.model.entities.Cotizacion;

public class CotizadorBean implements SessionBean {

	private KnowledgeBase kbase;
	
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}
	
	public String cotizar(Cobertura cobertura){
		
		
		Cotizacion cotizacion = new Cotizacion();
		
		final StatelessKnowledgeSession session = kbase
				.newStatelessKnowledgeSession();
		session.execute(Arrays.asList(new Object[] {
				cobertura.getValorComercial(), cobertura.getValorPuro(),
				cobertura.getValorEspecifico(), cotizacion }));
		
		System.out.println(cotizacion + "---- cotizacion");
		
		return cotizacion.getValor().toString();
		
		
	}

	
	public void ejbCreate () throws RemoteException, CreateException {
		
		System.out.println("---- creating ejb cotizador --------");
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();

		kbuilder.add(
				ResourceFactory.newClassPathResource("cotizador.drl", getClass()),
				ResourceType.DRL);

		if (kbuilder.hasErrors()) {
			System.err.println(kbuilder.getErrors().toString());
		}

		kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		
	}
	
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}

}
