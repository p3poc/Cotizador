package ar.com.p3.cotizador.model;

import javax.ejb.EJBObject;

import ar.com.p3.cotizador.model.entities.Cobertura;

public interface CotizadorObject extends EJBObject {
	
	public String cotizar(Cobertura cobertura);

}
