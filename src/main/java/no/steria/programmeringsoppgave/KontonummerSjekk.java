/**
 * @author Shahid Idrees
 * 
 */

package no.steria.programmeringsoppgave;


public class KontonummerSjekk {

	Konto konto;
	private static final int [] VEKTTALL = {2,3,4,5,6,7,2,3,4,5};
	private static final int DIVISOR = 11;
	
	/**
	* Constructor
	* @param konto 
	*/
	public KontonummerSjekk(Konto konto) {
		this.konto = konto;

	}

	/**
	* Metode for å skille ut kontrollsiffer , verdien settes til felt på domeneobjektet.
	* @param konto 
	*/
	public void definerKontrollSiffer(Konto konto) {
		String kontonummer = konto.getKontoNummer();
		char sisteSiffer = kontonummer.charAt(kontonummer.length() - 1);
		konto.setKontrollSiffer(Character.getNumericValue(sisteSiffer));		
		
	}

	/***
	 * Metode for å klargjøring av kontonummer for videre bruk. 
	 * Følgende operasjoner utføres
	 *  fjerner ".",
	 *  fjerner siste kontrollsifferet,
	 *  reverserer 
	 * 
	 * @param konto
	 *
	 */
	public void formaterKontoNummer(Konto konto)
	{
		String kontoNummer = konto.getKontoNummer();
		String kNummerUtenSkilletegn;
		String kNummerUtenSkilletegnOgKSiffer;
		String formatertKontoNummerReversert;
		
		kNummerUtenSkilletegn = kontoNummer.replace(".", "");
		kNummerUtenSkilletegnOgKSiffer = kNummerUtenSkilletegn.substring(0, kNummerUtenSkilletegn.length() - 1);
		formatertKontoNummerReversert= new StringBuilder(kNummerUtenSkilletegnOgKSiffer).reverse().toString();

		konto.setFormatertKontoNummer(formatertKontoNummerReversert) ;
		
	}

	/**
	* Metode for sjekk av et gitt kontonummer vha modulus11. 
	* Resultatet settes som et boolean verdi på kontoobjektet 
	* @param konto Et vilkårlig objekt
	*/
	public void sjekkGyldighet(Konto konto)
	{	
		int totalSum =0;
		int rest=0;
		int kontrollSiffer;
		
		
		String kontoNummerFormatert = konto.getFormatertKontoNummer();
		int kontoNummerLengde = kontoNummerFormatert.length();
		
	    int sifferIKontoNummer [] = new int[kontoNummerLengde];
	    		
		for (int i = 0; i < kontoNummerLengde; i++)
			sifferIKontoNummer[i] = Character.getNumericValue(kontoNummerFormatert.charAt(i));
		
		for (int i = 0; i < sifferIKontoNummer.length; i++) 
			totalSum+=(sifferIKontoNummer[i]*VEKTTALL[i]);
			
		
		rest = totalSum % DIVISOR;
			switch(rest){
			case 0:
				kontrollSiffer=0;
				break;
			case 1:
				kontrollSiffer=-1;
				break;
			default:
				kontrollSiffer = DIVISOR-rest;
		}
			
		if(kontrollSiffer==konto.getKontrollSiffer())
			konto.setGyldigKontoNummer(true);
		else 
			konto.setGyldigKontoNummer(false);
	}

	public static void main(String[] args) {
		Konto konto = new Konto("1504.82.17882");
		KontonummerSjekk kontonummerSjekk = new KontonummerSjekk(konto);
		kontonummerSjekk.definerKontrollSiffer(konto);
		kontonummerSjekk.formaterKontoNummer(konto);		
		kontonummerSjekk.sjekkGyldighet(konto);
	}

	
}
