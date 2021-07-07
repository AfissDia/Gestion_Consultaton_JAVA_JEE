package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Medcin;

public class MedcinModel {
private String motCle;
List<Medcin> medcins = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Medcin> getMedcins() {
return medcins;
}
public void setMedcins(List<Medcin> medcins) {
this.medcins = medcins;
}
}