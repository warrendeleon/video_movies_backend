package videomovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import videomovies.model.Movie;
import videomovies.repositories.MovieRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	private MovieRepository movieRepository;


	@RequestMapping(method = POST)
	@ResponseStatus(HttpStatus.CREATED)
	private Movie save (@RequestBody Movie movie){

		Movie movieToSave = movieRepository.save(movie);

		return movieToSave;

	}

	@RequestMapping(value = "/{id}",method = PUT)
	@ResponseStatus(HttpStatus.OK)
	private Movie update (@PathVariable Long id, @RequestBody Movie movie) {
		if(movieRepository.findOne(id) == null){
			throw new RuntimeException("La pelicula no existe");
		}

		Movie movieToUpdate = movieRepository.save(movie);

		return movieToUpdate;

	}

	//We return NO_CONTENT http://stackoverflow.com/questions/2342579/http-status-code-for-update-and-delete
	@RequestMapping(value = "/{id}", method = DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void delete(@PathVariable Long id) {

		Movie movie = movieRepository.findOne(id);

		movieRepository.delete(movie);

	}


	@RequestMapping(method = GET)
	private List<Movie> getAllMovies(){
		Iterator<Movie> iterator = movieRepository.findAll().iterator();
		List<Movie> movies = new ArrayList<>();

		while(iterator.hasNext()){
			Movie movie = iterator.next();
			movies.add(movie);
		}

		if(movies.size()>0) {
			return movies;
		} else {
			return new ArrayList<>();
		}
	}

	@RequestMapping(value = "/{id}", method = GET)
	private Movie getMovie(@PathVariable Long id){
		Movie movie = movieRepository.findOne(id);
		if (movie == null){
			throw new RuntimeException("La pelicula no existe");
		}
		return movie;
	}

}
