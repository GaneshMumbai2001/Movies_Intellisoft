package dev.ganeshmumbai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id; // MongoDB unique identifier
    private String imdbId; // IMDb unique ID
    private String title; // Movie title
    private String releaseDate; // Release date of the movie
    private String trailerLink; // Link to the trailer
    private String poster; // Poster image URL
    private List<String> backdrops; // List of backdrop image URLs
    private List<String> genres; // List of genres
    @DocumentReference
    private List<Review> reviews; // References to Review documents

    // Constructor without reviews field for convenience
    public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster,
            List<String> backdrops, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
    }
}
