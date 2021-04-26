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
private ArrayList<Cane> archivio;

public Archivio() {
archivio = new ArrayList(0);
}

public void inserisci(Cane cane) {
archivio.add(cane);
}

public Cane ricerca (String codice) {
for(int i=0; i<archivio.size(); i++) {
Cane cane = archivio.get(i);

if(cane.getCodice()==codice) {
return cane;
} 
}
return null;
}
}
