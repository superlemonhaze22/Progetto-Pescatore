package Main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;



public class Main {

	public static void main(String[] args) throws PescatoreException, IOException 
	{
		int codiceidentificativo = 0;
		Pescatori Lista = new Pescatori();	
		SaveRestore saverestore = new SaveRestore();
		if (saverestore.loadProject(Lista) == true) 
		{
			System.out.println("Caricamento avvenuto con successo");
			System.out.println();
			System.out.println();
		} 
		else 
		{
			System.out.println("Dati non trovati/esistenti o corrotti");
			System.out.println();
			System.out.println();
		}
		try 
		{
			codiceidentificativo = Lista.getPescatore(Lista.getElementi()).getCodiceIdentificativo();
		} catch (PescatoreException e) 
		{
		}
		
		
		
		Menu menu = new Menu();
		Controlli controlli = new Controlli();
		VisualizzaRiordinato ordina = new VisualizzaRiordinato();
		Scanner tastiera = new Scanner(System.in);
		int controllo = 0;
		int posizione = 0;
		do
		{
			saverestore.saveProject(Lista);
			System.out.println("Voci selezionabili del menu inserendo il numero desiderato: (in caso inserisci un altro numero il programma termina)");
			System.out.println("1)  Aggiungi pescatore");
			System.out.println("2)  Visualizza un pescatore dalla lista");
			System.out.println("3)  Togli un pescatore dalla lista");
			System.out.println("4)  Visualizza tutti i pescatore dalla lista in ordine cronologico");
			System.out.println("5)  Visualizza tutti gli elementi dalla lista in ordine alfabetico");
			
			controllo = controlli.controlloInputInt();

			switch (controllo) 
			{
			case 1:
				menu.voce1(Lista, codiceidentificativo);
				codiceidentificativo++;
				break;
				
			case 2:
				posizione = 0;
				System.out.println("Inserisci la posizione dell'oggetto che ti interessa visualizzare");
				posizione = controlli.controlloInputInt(); 
				menu.voce2(Lista, posizione);
				break;
				
			case 3:
				posizione = 0;
				System.out.println("Inserisci la posizione dell'oggetto che ti interessa eliminare");
				posizione = controlli.controlloInputInt(); 
				menu.voce3(Lista, posizione);
				break;
				
			case 4:
				menu.voce4(Lista);
				break;
				
			case 5:
				ordina.ordineAlfabetico(Lista);
				System.out.println("Premi invio per continuare");
				tastiera.nextLine();
				break;
			
				
			default: 
			System.out.println("Programma terminato");
			controllo = -1;
				break;
			}			
		}while(controllo != -1);
		
		saverestore.saveProject(Lista);
		
		
	}

}
