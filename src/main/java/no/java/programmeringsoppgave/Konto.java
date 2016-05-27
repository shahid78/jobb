/**
 * @author Shahid Idrees
 * 
 */
package no.java.programmeringsoppgave;

public class Konto {

	private int kontrollSiffer;
	private String kontoNummer;
	private String formatertKontoNummer;
	private boolean gyldigKontoNummer;

	public Konto(String kontoNummer) {
		this.setKontoNummer(kontoNummer);
	}

	public int getKontrollSiffer() {
		return kontrollSiffer;
	}

	public void setKontrollSiffer(int kontrollSiffer) {

		this.kontrollSiffer = kontrollSiffer;
	}

	public String getKontoNummer() {
		return kontoNummer;
	}

	public void setKontoNummer(String kontoNummer) {
		this.kontoNummer = kontoNummer;
	}

	public boolean isGyldigKontoNummer() {
		return gyldigKontoNummer;
	}

	public void setGyldigKontoNummer(boolean gyldigKontoNummer) {
		this.gyldigKontoNummer = gyldigKontoNummer;
	}

	public String getFormatertKontoNummer() {
		return formatertKontoNummer;
	}

	public void setFormatertKontoNummer(String formatertKontoNummer) {
		this.formatertKontoNummer = formatertKontoNummer;
	}

}
