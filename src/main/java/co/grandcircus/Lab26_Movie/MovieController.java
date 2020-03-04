package co.grandcircus.Lab26_Movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieDao mDao;

	@RequestMapping("")
	public List<Movie> showAll(@RequestParam(required = false) String genre,
			@RequestParam(required = false) String title) {

		boolean emptyGenre = genre == null || genre.isEmpty();
		boolean emptyTitle = title == null || title.isEmpty();
	
		if (emptyGenre && emptyTitle) {
			return mDao.findAll();
		} else if (!emptyGenre && !emptyTitle) {
			List<Movie> movieByGenre = mDao.findByGenreContainingIgnoreCase(genre);
			List<Movie> returnList = new ArrayList<>();
			title = title.toUpperCase();
			for (Movie movie : movieByGenre) {
				if (movie.getTitle().toUpperCase().contains(title)) {
					returnList.add(movie);
				}
			}
			return returnList;
		} else if (!emptyTitle) {
			return mDao.findByTitleContainingIgnoreCase(title);
		} else if (!emptyGenre){
			return mDao.findByGenreContainingIgnoreCase(genre);
		} else {
			return null;
		}
	}

	@RequestMapping("/genres")
	public List<String> showGenres() {
		return mDao.findGenres();
	}

}
