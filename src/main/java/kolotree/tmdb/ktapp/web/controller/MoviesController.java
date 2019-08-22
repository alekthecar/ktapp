package kolotree.tmdb.ktapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kolotree.tmdb.ktapp.model.Movie;
import kolotree.tmdb.ktapp.service.MovieService;
import kolotree.tmdb.ktapp.support.MovieDTOToMovie;
import kolotree.tmdb.ktapp.support.MovieToMovieDTO;
import kolotree.tmdb.ktapp.web.dto.MovieDTO;

@RestController
@RequestMapping("movies/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MoviesController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieDTOToMovie toMovie;

	@Autowired
	private MovieToMovieDTO toMovieDto;

	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<MovieDTO> insertMovie(@RequestBody MovieDTO newFavoriteMovie) {
		Movie persisted = movieService.save(toMovie.convert(newFavoriteMovie));
		if (persisted == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(toMovieDto.convert(persisted));
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<MovieDTO>> getAllMovies() {
		return ResponseEntity.ok(toMovieDto.convert(movieService.findAll()));
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable String id) {
		movieService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
