package archiviojava3bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contiene gli oggetti del programma.
 * Implementata tramite un ArrayList.
 * Ci permette di inserire gli oggetti,
 * effettuare ricerche e
 * aggiungere/rimuovere/modificare un oggetto.
 * @author Nobile Thierry
 */

public class Archivio 
    {
    private ArrayList<Animale> archivio;

    public Archivio() 
        {
        archivio = new ArrayList(0);
        archivio = leggiDaFile();
        }

    public ArrayList<Animale> elencoAnimali() 
        {
        return archivio;
        }
    public boolean aggiungiAnimale(Animale animale) 
        {
        if (Archivio.this.cercaAnimale(animale.getCodice()) != null)
            {
            return false;
            }
        archivio.add(animale);
        salvaSuFile();
        return true;
        }

    private Animale cercaAnimale(String codice) 
        {
        for (int i = 0; i < archivio.size(); i++) 
            {
            if (archivio.get(i).getCodice().equals(codice)) 
                {
                return archivio.get(i);
                }
            }
        return null;
        }

    public boolean elimina(String codice) 
        {
        Animale animale;
        animale = Archivio.this.cercaAnimale(codice);

        if (animale != null) 
            {
            archivio.remove(animale);
            salvaSuFile();
            return true;
            }
        return false;
        }

    public boolean modificaAnimale(String codice, int quantita, float prezzo, String razza, String dimensione, String colore) 
        {
        Animale animale;
        animale = Archivio.this.cercaAnimale(codice);
        if (animale != null)
            {
            animale.setQuantita(quantita);
            animale.setPrezzo(prezzo);
            animale.setRazza(razza);
            animale.setDimensione(dimensione);
            animale.setColore(colore);
            salvaSuFile();
            return true;
            } 
        return false;
        }

    public ArrayList<Animale> cercaAnimale(float prezzoMinimo, float prezzoMassimo) 
        {
        ArrayList<Animale> animaliTrovati = new ArrayList(0);

        for (int i = 0; i < archivio.size(); i++) 
            {
            if (archivio.get(i).getPrezzo() >= prezzoMinimo
                && archivio.get(i).getPrezzo() <= prezzoMassimo) 
                {
                animaliTrovati.add(archivio.get(i));
                }
            }
        return animaliTrovati;
        }
    
    public ArrayList<Animale> cercaAnimalePerRazza(String razza) 
        {
        ArrayList<Animale> animaliTrovati = new ArrayList(0);
        String razzaDaCercareMinuscolo = razza.toLowerCase();

        for (int i = 0; i < archivio.size(); i++) 
            {
            String razzaMinuscolo = archivio.get(i).getRazza().toLowerCase();

            if (razzaMinuscolo.contains(razzaDaCercareMinuscolo)) 
                {
                animaliTrovati.add(archivio.get(i));
                }
            }
        return animaliTrovati;
        }
  
    @Override
    public String toString() 
        {
        String s="";

        for(int i=0; i<archivio.size(); i++) 
            {
            Animale animale;
            animale = archivio.get(i);
            s += animale.toString();
            s += "\r\n";
            }
        return s;
        }

    private ArrayList<Animale> leggiDaFile()
        {
        ArrayList<Animale> animali;
        animali = new ArrayList();
        FileReader fileReader;
        try 
            {
            fileReader = new FileReader ("archivio.csv");
            BufferedReader in;
            in = new BufferedReader(fileReader);
            String linea;
            String campi[];
        
            while((linea = in.readLine()) != null)
                {
                campi = linea.split(",");
                int quantita = Integer.parseInt(campi[1]);
                float prezzo = Float.parseFloat(campi[2]);
                Animale animale = new Animale(campi[0], quantita, prezzo, campi[3], campi[4], campi[5]);
                animali.add(animale);
                }
            } 
        catch (FileNotFoundException ex) 
            {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (IOException ex) 
            {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
            }
        return animali;
        }

    private void salvaSuFile()
        {
        FileWriter out;
        try 
            {
            out = new FileWriter("archivio.csv");
            String sArchivio;
            sArchivio = toString();
            out.write(sArchivio);
            out.close();
            } 
        catch (IOException ex) 
            {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }