package Main;

import java.io.IOException;
import java.util.Scanner;

public class Menu 
{
	public void voce1(Pescatori lista, int codice) throws PescatoreException 		//aggiugni alla lista
	{
		Controlli controllo = new Controlli();
		Scanner tastiera = new Scanner(System.in);
		Pescatore pescatore = new Pescatore();
		System.out.println("Inserisci il tuo nome");
		pescatore.setNome(tastiera.nextLine());
		System.out.println("Inserisci il tuo cognome");
		pescatore.setCognome(tastiera.nextLine());
		System.out.println("Inserisci 0 se non hai noleggiato e 1 se hai noleggiato l'attrezzatura");
		int a;
		a = controllo.controlloInputInt();
		do 
		{
			if (a<0 || a>1) 
			{
				System.out.println("Riprova furbetto");
				a=tastiera.nextInt();
			}
			else
			{
				break;
			}			
			
		} while (true);
		if (a == 0) 
		{
			pescatore.setNoleggioAttrezzatura(true);
		}
		else
		{
		pescatore.setNoleggioAttrezzatura(true);
		}
		
		pescatore.setCodiceIdentificativo(codice);
		lista.inserisciInPosizione(pescatore, lista.getElementi()+1);
		//--------------------------------------------------
	
		System.out.println("Inserimento avvenuto correttamente");
		System.out.println();
	}
	
	public void voce2(Pescatori lista, int posizione) 		//visualizza elemento dalla lista
	{
		try 
		{
			System.out.println(lista.getPescatore(posizione).toString(posizione));
		} 
		catch (PescatoreException e)
		{
			System.out.println("Posizione non valida, riprova da capo");
		}
	}
	
	
	public void voce3(Pescatori lista,  int posizione) throws IOException 		//togli dalla lista
	{
		try 
		{
			lista.eliminaInPosizione(posizione);
			System.out.println("Eliminazione avvenuta correttamente");
			System.out.println();
		} 
		catch (PescatoreException e) 
		{
			System.out.println("Posizione non valida, riprova da capo");
		}

	}
	
	public void voce4(Pescatori lista) 		//visualizza tutti gli elementi della lista
	{
		Scanner tastiera = new Scanner(System.in);
		Menu menu = new Menu();
		int i=lista.getElementi();
		for (int j = 1; j <= i; j++) 
		{
			menu.voce2(lista, j);
		}
		System.out.println("Visualizzazione completa"); System.out.println();
		System.out.println("Premi invio per continuare");
		tastiera.nextLine();
	}
	

}
