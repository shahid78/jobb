/**
 * @author Shahid Idrees
 * 
 */

package no.java.programmeringsoppgave.service;

import static org.junit.Assert.*;

import org.junit.Test;

import no.java.programmeringsoppgave.domain.Konto;
import no.java.programmeringsoppgave.service.KontonummerSjekk;

public class KontonummerSjekkTest {

	private static final String KONTO_NR_GYLDIG = "1504.82.17882";
	private static final int KONTO_NR_GYLDIG_KONTROLLSIFFER = 2;
	private static final String KONTO_NR_GYLDIG_FORMATERT = "8871284051";

	private static final String KONTO_NR_UGYLDIG = "1504.82.17884";
	private static final int KONTO_NR_UGYLDIG_KONTROLLSIFFER = 4;
	private static final String KONTO_NR_UGYLDIG_FORMATERT = "8871284051";

	@Test
	public void testAvDefinerKontrollSiffer() {

		Konto konto = new Konto(KONTO_NR_GYLDIG);
		KontonummerSjekk kontonummerSjekk = new KontonummerSjekk(konto);
		kontonummerSjekk.definerKontrollSiffer(konto);

		assertEquals(KONTO_NR_GYLDIG_KONTROLLSIFFER, konto.getKontrollSiffer());

	}

	@Test
	public void testAvFormaterKontoNummer() {

		Konto konto = new Konto(KONTO_NR_GYLDIG);
		KontonummerSjekk kontonummerSjekk = new KontonummerSjekk(konto);
		kontonummerSjekk.formaterKontoNummer(konto);

		assertEquals(KONTO_NR_GYLDIG_FORMATERT, konto.getFormatertKontoNummer());

	}

	@Test
	public void testAvSjekkGyldighetMedGyldigKontoNummer() {

		Konto konto = new Konto(KONTO_NR_GYLDIG);
		KontonummerSjekk kontonummerSjekk = new KontonummerSjekk(konto);

		konto.setFormatertKontoNummer(KONTO_NR_GYLDIG_FORMATERT);
		konto.setKontrollSiffer(KONTO_NR_GYLDIG_KONTROLLSIFFER);

		kontonummerSjekk.sjekkGyldighet(konto);

		assertTrue(konto.isGyldigKontoNummer());

	}

	@Test
	public void testAvSjekkGyldighetMedUgyldigKontoNummer() {

		Konto konto = new Konto(KONTO_NR_UGYLDIG);
		KontonummerSjekk kontonummerSjekk = new KontonummerSjekk(konto);

		konto.setFormatertKontoNummer(KONTO_NR_UGYLDIG_FORMATERT);
		konto.setKontrollSiffer(KONTO_NR_UGYLDIG_KONTROLLSIFFER);

		kontonummerSjekk.sjekkGyldighet(konto);

		assertFalse(konto.isGyldigKontoNummer());

	}

}
