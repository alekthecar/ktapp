package kolotree.tmdb.ktapp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kolotree.tmdb.ktapp.model.Movie;
import kolotree.tmdb.ktapp.web.dto.MovieDTO;

@Component
public class MovieToMovieDTO implements Converter<Movie, MovieDTO> {

	@Override
	public MovieDTO convert(Movie movie) {

		MovieDTO movieDto = new MovieDTO();

		movieDto.setId(movie.getTmdbId());
		movieDto.setMongo_id(movie.getId());
		movieDto.setTitle(movie.getTitle());
		movieDto.setPoster_path(movie.getPosterPath());
		movieDto.setOverview(movie.getOverview());
		movieDto.setGenres(movie.getGenres());
		movieDto.setRelease_date(movie.getReleaseDate());
		movieDto.setVideo_url(movie.getVideoUrl());

		return movieDto;
	}

	public List<MovieDTO> convert(List<Movie> movies) {

		List<MovieDTO> moviesDto = new ArrayList<>();

		for (Movie movie : movies) {
			moviesDto.add(convert(movie));
		}
		return moviesDto;
	}
}
