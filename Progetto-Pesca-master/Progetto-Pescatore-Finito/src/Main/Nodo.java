package Main;

public class Nodo 
{
	private Pescatore info;
	private Nodo link;
	
	public Nodo(Pescatore persona)
	{
		setInfo(persona);
		link=null;
	}

	public Pescatore getInfo() 
	{
		return info;
	}

	public void setInfo(Pescatore info) 
	{
		this.info = info;
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}