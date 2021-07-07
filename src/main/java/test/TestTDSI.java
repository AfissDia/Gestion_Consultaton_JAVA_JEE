package test;

import java.util.List;

import metier.entities.Medcin;
import tdsi.MedcinTdsiImpl;

public class TestTDSI {
	
	public static void main(String[] args) {
		MedcinTdsiImpl pdao= new MedcinTdsiImpl();
		
		Medcin prod= pdao.save(new Medcin("Penda","210D"));
		System.out.println(prod);
		List<Medcin> prods =pdao.medcinsParMC("HP");
		for (Medcin p : prods)
		System.out.println(p);
}
}