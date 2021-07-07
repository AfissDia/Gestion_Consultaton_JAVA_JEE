package metier.entities;

import java.io.Serializable;

public class Medcin implements Serializable{
	private Long idMedcin;
	private String nomMedcin;
	private String matricul;
	public Medcin() {
		super();
		}
	public Medcin(String nomMedcin, String matricul) {
		super();
		this.nomMedcin = nomMedcin;
		this.matricul = matricul;
		}
	public Long getIdMedcin() {
		return idMedcin;
		}
	public void setIdMedcin(Long idMedcin) {
		this.idMedcin = idMedcin;
		}
	public String getNomMedcin() {
		return nomMedcin;
		}
	public void setNomMedcin(String nomMedcin) {
		this.nomMedcin = nomMedcin;
		}
	public String getMatricul() {
		return matricul;
		}
	public void setMatricul(String matricul) {
		this.matricul = matricul;
		}
	@Override
	public String toString() {
		return "Medcin [idMedcin=" + idMedcin + ", nomMedcin=" + nomMedcin + ", matricul=" + matricul + "]";
	}
		

}
