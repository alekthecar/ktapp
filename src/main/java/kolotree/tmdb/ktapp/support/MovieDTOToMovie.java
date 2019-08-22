package kolotree.tmdb.ktapp.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kolotree.tmdb.ktapp.model.Movie;
import kolotree.tmdb.ktapp.web.dto.MovieDTO;

@Component
public class MovieDTOToMovie implements Converter<MovieDTO, Movie> {

	@Override
	public Movie convert(MovieDTO movieDto) {

		Movie movie = new Movie();

		movie.setTmdbId(movieDto.getId());
		movie.setTitle(movieDto.getTitle());
		movie.setPosterPath(movieDto.getPoster_path());
		movie.setOverview(movieDto.getOverview());
		movie.setGenres(movieDto.getGenres());
		movie.setReleaseDate(movieDto.getRelease_date());
		movie.setVideoUrl(movieDto.getVideo_url());

		return movie;
	}
}
