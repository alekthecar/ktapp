package kolotree.tmdb.ktapp.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import kolotree.tmdb.ktapp.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	Movie findByTmdbId(int id);
}
