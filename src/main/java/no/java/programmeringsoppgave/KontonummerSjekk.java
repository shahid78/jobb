/**
 * @author Shahid Idrees
 * 
 */

package no.java.programmeringsoppgave;

public class KontonummerSjekk {

	Konto konto;
	private static final int[] VEKTTALL = { 2, 3, 4, 5, 6, 7, 2, 3, 4, 5 };
	private static final int DIVISOR = 11;

	/**
	 * Constructor
	 * 
	 * @param konto
	 */
	public KontonummerSjekk(Konto konto) {
		this.konto = konto;

	}

	/**
	 * Metode for å skille ut kontrollsiffer , verdien settes til felt på
	 * domeneobjektet.
	 * 
	 * @param konto
	 */
	public void definerKontrollSiffer(Konto konto) {
		String kontonummer = konto.getKontoNummer();
		char sisteSiffer = kontonummer.charAt(kontonummer.length() - 1);
		konto.setKontrollSiffer(Character.getNumericValue(sisteSiffer));

	}

	/***
	 * Metode for å klargjøring av kontonummer for videre bruk. Følgende
	 * operasjoner utføres fjerner ".", fjerner siste kontrollsifferet,
	 * reverserer
	 * 
	 * @param konto
	 *
	 */
	public void formaterKontoNummer(Konto konto) {
		String kontoNummer = konto.getKontoNummer();
		String kNummerUtenSkilletegn;
		String kNummerUtenSkilletegnOgKSiffer;
		String formatertKontoNummerReversert;

		kNummerUtenSkilletegn = kontoNummer.replace(".", "");
		kNummerUtenSkilletegnOgKSiffer = kNummerUtenSkilletegn.substring(0, kNummerUtenSkilletegn.length() - 1);
		formatertKontoNummerReversert = new StringBuilder(kNummerUtenSkilletegnOgKSiffer).reverse().toString();

		konto.setFormatertKontoNummer(formatertKontoNummerReversert);

	}

	/**
	 * Metode for validering av et gitt kontonummer vha modulus11 metodikk.
	 * 
	 * Resultatet av valideringen settes som et boolean verdi på kontoobjektet
	 * 
	 * @param konto Et vilkårlig konto objekt
	 */
	public void sjekkGyldighet(Konto konto) {
		int totalSum = 0;
		int rest = 0;
		int kontrollSiffer;

		String kontoNummerFormatert = konto.getFormatertKontoNummer();
		int kontoNummerLengde = kontoNummerFormatert.length();
		int sifferIKontoNummer[] = new int[kontoNummerLengde];

		// Lager en tall-array basert på sifrene i det formaterte kontonummeret
		for (int i = 0; i < kontoNummerLengde; i++)
			sifferIKontoNummer[i] = Character.getNumericValue(kontoNummerFormatert.charAt(i));
		
		/**
		 *  Sifre i tall-arryet multlipliseres henholdsvis med sifre i vektallssamlingen
		 *  Delproduktene legges sammen til en totalsum
		 */
		for (int i = 0; i < sifferIKontoNummer.length; i++)
			totalSum += (sifferIKontoNummer[i] * VEKTTALL[i]);

		/**
		 * Totalsummen deles med 11 slik at vi får en restverdi som vi vil evaluere videre.
		 * 
		 * Dersom restverdien er 1 vil tallet forkastes, ved at kontrollsiffer settes til -1.
		 * Hvis restverdien er 0, settes kontrollsiffer til denne verdien.
		 * For andre verdier for rest, vil verdien til kontrollsiffer settes etter formelen: 11 - restverdi.
		 * 
		 */
		rest = totalSum % DIVISOR;
		
		switch (rest) {
		case 0:
			kontrollSiffer = 0;
			break;
		case 1:
			kontrollSiffer = -1;
			break;
		default:
			kontrollSiffer = DIVISOR - rest;
		}

		/**
		 * Kontonummeret vil være gyldig dersom kontrollsifferet beregnet ovenfor 
		 * samsvarer med kontrollsiffer i kontonummeret. 
		 */
		if (kontrollSiffer == konto.getKontrollSiffer()) 
			konto.setGyldigKontoNummer(true);
		else 
			konto.setGyldigKontoNummer(false);
			
		System.out.println("Kontonummer: "+  konto.getKontoNummer() + "\n isGyldig: " + konto.isGyldigKontoNummer());
	}

    /***
     * Main metode for å testkjøre programmet med et 11-sifret nummer
     * @param args
     */
	public static void main(String[] args) {	
		Konto konto;
		
		if (args.length !=0) konto = new Konto(args[0]);	
		else konto	= new Konto("0540.46.02227");
		
		KontonummerSjekk kontonummerSjekk = new KontonummerSjekk(konto);
		kontonummerSjekk.definerKontrollSiffer(konto);
		kontonummerSjekk.formaterKontoNummer(konto);
		kontonummerSjekk.sjekkGyldighet(konto);
	}

}
