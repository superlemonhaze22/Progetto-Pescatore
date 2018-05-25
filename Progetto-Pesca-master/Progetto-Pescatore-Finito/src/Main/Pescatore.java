package Main;
import java.io.*;
import java.time.LocalDateTime;


public class Pescatore  implements Serializable 
{
	private int numeroTrote;
	private int codiceIdentificativo;
	private String nome;
	private String cognome;
	private LocalDateTime dataOraIngresso;
	private LocalDateTime dataOraUscita;
	private Boolean noleggioAttrezzatura;
    
		
	public Pescatore(int codiceIdentificativo, String nome, String cognome, Boolean noleggioAttrezzatura) 
	{		
		this.codiceIdentificativo = codiceIdentificativo;
		this.nome = nome;
		this.cognome = cognome;
		this.noleggioAttrezzatura = noleggioAttrezzatura;
	}

	public Pescatore() 
	{
		dataOraIngresso = LocalDateTime.now();
	}

	public int getNumeroTrote() 
	{
		return numeroTrote;
	}

	public void setNumeroTrote(int numeroTrote) 
	{
		this.numeroTrote = numeroTrote;
	}
	
	public int getCodiceIdentificativo() 
	{
		return codiceIdentificativo;
	}
	
	public void setCodiceIdentificativo(int codiceIdentificativo) 
	{
		this.codiceIdentificativo = codiceIdentificativo;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getCognome() 
	{
		return cognome;
	}
	
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	
	public LocalDateTime getDataOraIngresso() 
	{
		return dataOraIngresso;
	}
	
	public void setDataOraIngresso(LocalDateTime dataOraIngresso) 
	{
		this.dataOraIngresso = dataOraIngresso;
	}
	
	public LocalDateTime getDataOraUscita() 
	{
		return dataOraUscita;
	}
	
	public void setDataOraUscita(LocalDateTime dataOraUscita) 
	{
		this.dataOraUscita = dataOraUscita;
	}
	
	public Boolean getNoleggioAttrezzatura() 
	{
		return noleggioAttrezzatura;
	}
	
	public void setNoleggioAttrezzatura(Boolean noleggioAttrezzatura) 
	{
		this.noleggioAttrezzatura = noleggioAttrezzatura;
	}
	
	public String toString() 
	{
		return "Pescatore [numeroTrote=" + numeroTrote + ", codiceIdentificativo=" + codiceIdentificativo + ", nome="+ nome + ", cognome=" + cognome + ", dataOraIngresso=" + dataOraIngresso + ", noleggioAttrezzatura=" + noleggioAttrezzatura + "]";
	}	
	
	public String toString(int posizione) 
	{
		return "Pescatore in posizione " + posizione +"[numeroTrote=" + numeroTrote + ", codiceIdentificativo=" + codiceIdentificativo + ", nome="+ nome + ", cognome=" + cognome + ", dataOraIngresso=" + dataOraIngresso + ", noleggioAttrezzatura=" + noleggioAttrezzatura + "]";
	}
	
	public void StringToFileTeo() throws IOException 
	{		
		PrintWriter file_output =new PrintWriter ( new BufferedWriter (new FileWriter ("Dati da salvare.txt", true )));
		dataOraUscita = LocalDateTime.now();
		file_output.print(dataOraIngresso + " ");
		file_output.println(dataOraUscita +  " Numero trote pescate = " + numeroTrote);
		file_output.println("--------------------------------------------------"); System.out.println();		//spazio per separare la lista degli elementi con annessi 50 puntini di separazione
		file_output . close ();
	}

	public void StampaScontrinoSuFile() throws IOException
	{
		PrintWriter file_output =new PrintWriter ( new BufferedWriter (new FileWriter ("Scontrini .txt", true )));
		dataOraUscita = LocalDateTime.now();
		file_output.println(this.toString());
		if (this.noleggioAttrezzatura == true) 
		{
			file_output.println("Il totale da pagare è: " + this.numeroTrote*10 + "€ + costo noleggio = 20€");
		}
		else
		{
			file_output.println("Il totale da pagare è: " + this.numeroTrote*10 + "€ + costo noleggio = 0€");
		}
		
		file_output.println("--------------------------------------------------"); System.out.println();		//spazio per separare la lista degli elementi con annessi 50 puntini di separazione
		file_output . close ();
	}
	
	
	
}
