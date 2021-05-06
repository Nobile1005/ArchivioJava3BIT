package archiviojava3bit;

import java.util.ArrayList;

/**
 * Contiene gli oggetti del programma.
 * Implementata tramite un ArrayList.
 * Ci permette di inserire gli oggetti,
 * effettuare ricerche e
 * aggiungere/rimuovere/modificare un oggetto.
 * @author Nobile Thierry
 */
public class Archivio {
private ArrayList<Animale> archivio;

public Archivio() {
archivio = new ArrayList(0);
}

public void inserisciAnimale(Animale animale) {
archivio.add(animale);
}

public Animale cercaAnimale(String codice) {
for(int i=0; i<archivio.size(); i++) {
Animale animale = archivio.get(i);

if(animale.getCodice()==codice) {
return animale;
} 
}
return null;
}

public boolean eliminaAnimale(String codice) {
Animale animale;
animale = cercaAnimale(codice);

if (animale != null) {
archivio.remove(animale);
return true;
}
return false;
}

public ArrayList<Animale> cercaAnimali(float prezzoMinimo, float prezzoMassimo){
ArrayList<Animale> animaliTrovati = new ArrayList(0);

for(int i=0; i<archivio.size(); i++) {
Animale animale = archivio.get(i);

if(animale.getPrezzo()>=prezzoMinimo && animale.getPrezzo()<=prezzoMassimo) {
animaliTrovati.add(animale);

}
}
return animaliTrovati;
}

public ArrayList<Animale> cercaAnimaliPerRazza(String razza) {
ArrayList<Animale> animaliTrovati = new ArrayList(0);
String razzaDaCercareMinuscolo = razza.toLowerCase();

for(int i=0; i<archivio.size(); i++){
Animale animale = archivio.get(i);
String razzaMinuscolo = animale.getRazza().toLowerCase();
if (razzaMinuscolo.contains(razzaDaCercareMinuscolo)) {
animaliTrovati.add(animale);

}
}
return animaliTrovati;
}
public String toString() {
String s="";

for(int i=0; i<archivio.size(); i++) {
Animale animale = archivio.get(i);
s += animale.toString();

if(i<archivio.size()-1) {
s += "\r\n";
}
}
return s;
}

public ArrayList<Animale> elencoAnimali() {
return archivio;
}
}