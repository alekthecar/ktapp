package kolotree.tmdb.ktapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kolotree.tmdb.ktapp.model.Movie;
import kolotree.tmdb.ktapp.persistence.MovieRepository;
import kolotree.tmdb.ktapp.service.MovieService;

@Service
public class MongoMovieService implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie save(Movie movie) {
		int apiId = movie.getTmdbId();
		if (movieRepository.findByTmdbId(apiId) == null) {
			return movieRepository.save(movie);
		}
		return null;
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public void delete(String id) {
		Optional<Movie> toBeDeleted = movieRepository.findById(id);
		if (toBeDeleted.isPresent()) {
			movieRepository.deleteById(id);
		}
	}
}
