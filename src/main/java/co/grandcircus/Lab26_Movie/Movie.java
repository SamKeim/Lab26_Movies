package co.grandcircus.Lab26_Movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String title;
	private String genre;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", title=" + title + ", genre=" + genre + "]";
	}
	
}
