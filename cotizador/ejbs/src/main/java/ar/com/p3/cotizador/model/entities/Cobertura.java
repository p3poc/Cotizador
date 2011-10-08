package ar.com.p3.cotizador.model.entities;

public class Cobertura {
	
	private ValorComercial valorComercial;
	private ValorEspecifico valorEspecifico;
	private ValorPuro valorPuro;
	private Factor factor;
	
	public ValorComercial getValorComercial() {
		return valorComercial;
	}
	
	public void setValorComercial(ValorComercial valorComercial) {
		this.valorComercial = valorComercial;
	}
	
	public ValorEspecifico getValorEspecifico() {
		return valorEspecifico;
	}
	
	public void setValorEspecifico(ValorEspecifico valorEspecifico) {
		this.valorEspecifico = valorEspecifico;
	}
	
	public ValorPuro getValorPuro() {
		return valorPuro;
	}
	
	public void setValorPuro(ValorPuro valorPuro) {
		this.valorPuro = valorPuro;
	}
	
	public Factor getFactor() {
		return factor;
	}
	
	public void setFactor(Factor factor) {
		this.factor = factor;
	}

}
