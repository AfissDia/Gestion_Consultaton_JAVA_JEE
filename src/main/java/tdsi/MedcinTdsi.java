package tdsi;

//package dao;

import java.util.List;
import metier.entities.Medcin;

public interface MedcinTdsi {
public Medcin save(Medcin p);
public List<Medcin> medcinsParMC(String mc);
public Medcin getMedcin(Long id); 
public Medcin updateMedcin(Medcin p);
public void deleteMedcin(Long id);
}