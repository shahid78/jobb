## Synopsis

Programmet validerer et vilk�rlig 11-sifret kontonummer vha av kontrollsiffer.
Valideringen gj�res vha modulus11 metodikk.

## Installasjon

Bygges/kj�res lokalt med maven. Kontonummer som �nskes testes, sendes som et maven parameter (se eksempel under)
> mvn clean install
> mvn exec:java -Dexec.mainClass="no.java.programmeringsoppgave.KontonummerSjekk" -Dexec.args="0540.46.02227"

## IDE
Prosjektet kan settes opp i eclipse som et maven prosjekt gjennom import funksjon.

## API Referanse
Javadoc er generert i eclipse, og vedlagt i prosjektet

## Tester

Prosjektet best�r av 4 JUnit tester. Disse kan kj�res eksplisit med maven;
>  mvn  -Dtest=no.java.programmeringsoppgave.KontonummerSjekkTest test 
