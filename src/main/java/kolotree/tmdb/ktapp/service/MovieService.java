package kolotree.tmdb.ktapp.service;

import java.util.List;

import kolotree.tmdb.ktapp.model.Movie;

public interface MovieService {

	Movie save(Movie movie);

	List<Movie> findAll();

	void delete(String id);
}
