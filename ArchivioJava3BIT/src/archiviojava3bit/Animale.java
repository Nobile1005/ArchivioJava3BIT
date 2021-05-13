package archiviojava3bit;

/**
 * Classe utilizzata per l'oggetto da contenere nella collezione.
 * Contiene le variabili di istanza, il metodo costruttore, i setter/getter
 * e eventuali altri metodi
 * @author Nobile Thierry
 */
public class Animale {
private String codice;
private int quantita;
private float prezzo;
private String razza;
private String dimensione;
private String colore;

public Animale(String codice, int quantita, float prezzo, String razza, String dimensione, String colore) {
this.codice = codice;
this.quantita = quantita;
this.prezzo = prezzo;
this.razza = razza;
this.dimensione = dimensione;
this.colore = colore;
}

public String getCodice() {
return codice;
}

public int getQuantita() {
return quantita;
}

public float getPrezzo() {
return prezzo;
}

public String getRazza() {
return razza;
}

public String getDimensione() {
return dimensione;
}

public String getColore() {
return colore;
}

public void setCodice(String codice) {
this.codice = codice;
}

public void setQuantita(int quantita) {
this.quantita = quantita;
}

public void setPrezzo(float prezzo) {
this.prezzo = prezzo;
}

public void setRazza(String razza) {
this.razza = razza;
}

public void setDimensione(String dimensione) {
this.dimensione = dimensione;
}

public void setColore(String colore) {
this.colore = colore;
}

@Override
public String toString() {
String s;
s = codice;
s += ",";
s += Integer.toString(quantita) ;
s += ",";
s += Float.toString(prezzo);
s = razza;
s += ",";
s = dimensione;
s += ",";
s = colore;
return s;
}

}
