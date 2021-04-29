package archiviojava3bit;

import java.util.ArrayList;

/**
 * Contiene gli oggetti del programma.
 * Implementata tramite un ArrayList.
 * Ci permette di inserire gli oggetti,
 * effettuare ricerche e
 * aggiungere/rimuovere/modificare un oggetto.
 * @author INSERISCI_NOME
 */
public class Archivio {
private ArrayList<Animale> archivio;

public Archivio() {
archivio = new ArrayList(0);
}

public void inserisci(Animale animale) {
archivio.add(animale);
}

public Animale ricerca (String codice) {
for(int i=0; i<archivio.size(); i++) {
Animale animale = archivio.get(i);

if(animale.getCodice()==codice) {
return animale;
} 
}
return null;
}
}
