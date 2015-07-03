package videomovies.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import videomovies.model.Movie;


public interface MovieRepository extends PagingAndSortingRepository<Movie,Long> {
}
