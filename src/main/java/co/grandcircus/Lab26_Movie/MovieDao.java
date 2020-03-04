package co.grandcircus.Lab26_Movie;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieDao extends JpaRepository<Movie, Long> {

	public List<Movie> findByGenreContainingIgnoreCase(String genre);
	
	@Query("SELECT DISTINCT genre FROM Movie")
	public List<String> findGenres();
	
	public List<Movie> findByTitleContainingIgnoreCase(String title);
}
