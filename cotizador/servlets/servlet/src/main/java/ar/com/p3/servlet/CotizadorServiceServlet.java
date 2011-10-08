package ar.com.p3.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.p3.cotizador.model.CotizadorBean;
import ar.com.p3.cotizador.model.CotizadorHome;
import ar.com.p3.cotizador.model.CotizadorObject;
import ar.com.p3.cotizador.model.entities.Cobertura;

public class CotizadorServiceServlet extends HttpServlet {

	private static final long serialVersionUID = 3031665322987189909L;

	private CotizadorHome cotizador = null;

	public CotizadorServiceServlet() {
		final Context context;
		try {
			context = new InitialContext();
			System.out.println("voy a buscar el bean");
			System.out.println("--------- bean --------" + context
					.lookup("CotizadorBean"));
			cotizador = (CotizadorHome) context
					.lookup("CotizadorBean");
			System.out.println("recupere el bean del cotizador");
			

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		final PrintWriter out = res.getWriter();

		// final String cotizacion = req.getParameter("ids a cotizar");

		CotizadorObject cotizadorObject = null;
		
		try {
			cotizadorObject = cotizador.create();
		} catch (CreateException e) {
			System.out.println("se rompio en la creacion");
			e.printStackTrace();
		} 
		
		Cobertura cobertura = new Cobertura();
		
		String cotizacion = cotizadorObject.cotizar(cobertura);
		System.out.println("---------->" + cotizacion);
		
		out.println(cotizacion);

	}
}