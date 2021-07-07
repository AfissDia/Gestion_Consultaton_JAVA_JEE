  package web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import tdsi.MedcinTdsi;
import tdsi.MedcinTdsiImpl;
import metier.entities.Medcin;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
	public class ControlServlet extends HttpServlet {
		MedcinTdsi metier;
@Override
public void init() throws ServletException {
		metier = new MedcinTdsiImpl();
	}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
String path=request.getServletPath();
	
	if (path.equals("/index.do")) {
		request.getRequestDispatcher("Medcins.jsp").forward(request,response);
	}
	else if (path.equals("/chercher.do"))
	{
		String motCle=request.getParameter("motCle");
		
		MedcinModel model= new MedcinModel();
		model.setMotCle(motCle);
		List<Medcin> prods = metier.medcinsParMC(motCle);
		model.setMedcins(prods);
		request.setAttribute("model", model);
	request.getRequestDispatcher("Medcins.jsp").forward(request,response);
	}
	
	else if (path.equals("/saisie.do") )
	{
	request.getRequestDispatcher("SaisieMedcin.jsp").forward(request,response);
	}
	else if (path.equals("/save.do") && request.getMethod().equals("POST"))
	{
		String nom=request.getParameter("nom");
		String matricul = request.getParameter("matricul");
		Medcin p = metier.save(new Medcin(nom,matricul));
		request.setAttribute("produit", p);
		request.getRequestDispatcher("Confirmation.jsp").forward(request,response);
	}
	else if (path.equals("/supprimer.do"))
	{
		Long id= Long.parseLong(request.getParameter("id"));
		metier.deleteMedcin(id);
		response.sendRedirect("chercher.do?motCle=");
	}
	else if (path.equals("/editer.do") )
	{
		Long id= Long.parseLong(request.getParameter("id"));
		Medcin p = metier.getMedcin(id);
		request.setAttribute("produit", p);
		request.getRequestDispatcher("editerMedcin.jsp").forward(request,response);
	}
	else if (path.equals("/update.do") )
	{
		Long id = Long.parseLong(request.getParameter("id"));
		String nom=request.getParameter("nom");
		String matricul = request.getParameter("matricul");
		Medcin p = new Medcin();
		p.setIdMedcin(id);
		p.setNomMedcin(nom);
		p.setMatricul(matricul);
		metier.updateMedcin(p);
		request.setAttribute("produit", p);
		request.getRequestDispatcher("Confirmation.jsp").forward(request,response);
	}
	else
	{
		response.sendError(Response.SC_NOT_FOUND);
	}
	}
@Override
protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}
}
