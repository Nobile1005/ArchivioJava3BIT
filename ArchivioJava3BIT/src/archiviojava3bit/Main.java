package archiviojava3bit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Si occupa dell'interfaccia utente con un menu.
 * Qui si può usare println
 * @author Nobile Thierry
 */

public class Main 
    {
    public static void main(String[] args) 
        {
        Archivio archivio;
        archivio = new Archivio();
        Scanner tastiera;
        tastiera = new Scanner(System.in);
        int scelta;

        do 
            {
            System.out.println("--- Gestione negozio di animali ---");
            System.out.println("1) Visualizza elenco animali");
            System.out.println("2) Inserisci animale");
            System.out.println("3) Elimina animale");
            System.out.println("4) Cerca animale in base al prezzo");
            System.out.println("5) Cerca animale in base alla razza");
            System.out.println("6) Modifica animale");
            System.out.println("7) Esci");
            System.out.print("Scegli l'operazione (1-7): ");

            scelta = Integer.parseInt(tastiera.nextLine());

            switch (scelta) 
                {
                case 1:
                ArrayList<Animale> elencoAnimali;
                elencoAnimali = archivio.elencoAnimali();
                visualizzaElencoAnimali(elencoAnimali);
                break;

                case 2:        
                System.out.print("Inserisci il codice: ");
                String codice = tastiera.nextLine();
                System.out.print("Inserisci la quantita: ");
                int quantita = Integer.parseInt(tastiera.nextLine());
                System.out.print("Inserisci il prezzo: ");
                float prezzo = Float.parseFloat(tastiera.nextLine());
                System.out.print("Inserisci la razza: ");
                String razza = tastiera.nextLine();
                System.out.print("Inserisci la dimensione: ");
                String dimensione = tastiera.nextLine();
                System.out.print("Inserisci il colore: ");
                String colore = tastiera.nextLine();

                Animale animale = new Animale(codice, quantita, prezzo, razza, dimensione, colore);

                if (archivio.aggiungiAnimale(animale)) 
                    {
                    System.out.print("Animale inserito correttamente");
                    } 
                else 
                    {
                    System.out.print("Esiste gia un animale con lo stesso codice !");
                    }
                break;

                case 3:        
                System.out.print("Inserisci il codice: ");
                codice = tastiera.nextLine();
       
                if (archivio.elimina(codice))
                    {
                    System.out.println("Animale eliminato correttamente.");
                    } 
                else 
                    {
                    System.out.println("Eliminazione non riuscita.");
                    }
                break;

                case 4:
                System.out.print("Inserisci il prezzo minimo: ");
                float prezzoMinimo = Float.parseFloat(tastiera.nextLine());
                System.out.print("Inserisci il prezzo massimo: ");
                float prezzoMassimo = Float.parseFloat(tastiera.nextLine());

                elencoAnimali = archivio.cercaAnimale(prezzoMinimo, prezzoMassimo);

                visualizzaElencoAnimali(elencoAnimali);
          
                break;

                case 5:
                System.out.print("Inserisci la razza: ");
                razza = tastiera.nextLine();

                elencoAnimali = archivio.cercaAnimalePerRazza(razza);

                visualizzaElencoAnimali(elencoAnimali);
                break;
                case 6:
                System.out.print("Inserisci il codice: ");
                codice = tastiera.nextLine();
                System.out.print("Inserisci la quantità: ");
                quantita = Integer.parseInt(tastiera.nextLine());
                System.out.print("Inserisci il prezzo: ");
                prezzo = Float.parseFloat(tastiera.nextLine());
                System.out.print("Inserisci la razza: ");
                razza = tastiera.nextLine();
                System.out.print("Inserisci la dimensione: ");
                dimensione = tastiera.nextLine();
                System.out.print("Inserisci il colore: ");
                colore = tastiera.nextLine();

                if (archivio.modificaAnimale(codice, quantita, prezzo, razza, dimensione, colore)) 
                    {
                    System.out.println("Modifica animale avvenuta correttamente.");
                    } 
                else 
                    {
                    System.out.println("Non è stato possibile modificare l'animale.");
                    }
                break;
                } 

            }while (scelta != 7);

        }

private static void visualizzaElencoAnimali(ArrayList<Animale> elencoAnimali) 
    {
    System.out.println("N°\tCodice\t\tQuantità\tPrezzo\t\tRazza\t\t\tDimensione\tColore");
    for (int i = 0; i < elencoAnimali.size(); i++) 
        {
        System.out.print(i + 1);
        System.out.print("\t" + elencoAnimali.get(i).getCodice());
        System.out.print("\t\t" + elencoAnimali.get(i).getQuantita());
        System.out.print("\t\t" + elencoAnimali.get(i).getPrezzo());
        System.out.print("\t\t" + elencoAnimali.get(i).getRazza());
        System.out.print("\t\t" + elencoAnimali.get(i).getDimensione());
        System.out.print("\t\t" + elencoAnimali.get(i).getColore());
        System.out.println("\n");
        }
    System.out.println("\n");
    }
    
    }
