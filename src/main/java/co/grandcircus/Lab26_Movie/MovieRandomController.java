package co.grandcircus.Lab26_Movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies/random")
public class MovieRandomController {
	
	@Autowired
	MovieDao mDao;
	
	@RequestMapping("")
	public Movie randSingle(
			@RequestParam(required=false) String genre
			) {
		List<Movie> movieList = new ArrayList<>();
		
		if(genre == null || genre.isEmpty()) {
			movieList = mDao.findAll();
		} else {
			movieList = mDao.findByGenreContainingIgnoreCase(genre);
		}
		if (movieList.size() == 0) {
			return new Movie();
		}
		int rand = (int) (Math.random() * (movieList.size()));
		return movieList.get(rand);
	}
	
	@RequestMapping("/list")
	public List<Movie> randList(
			@RequestParam(required=false) Integer max
			){
		List<Movie> movieList = mDao.findAll();
		int listSize = movieList.size();
		int rand = 0;
		List<Movie> returnList = new ArrayList<>();
		for(int i = 0; i < max; i++) {
			rand = (int) (Math.random() * (listSize));
			returnList.add(movieList.get(rand));
		}
		return returnList;
	}
}
