package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Band {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String genre;
	private String manager;
	
	public Band() {
		super();
	}
	
	public Band(String name, String genre, String manager) {
		super();
		this.name = name;
		this.genre = genre;
		this.manager = manager;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getManager() {
		return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	@Override
	public String toString() {
		return "Band [id=" + id + "name=" + name + ", genre=" + genre + ", manager=" + manager + "]";
	}

}