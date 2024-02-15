package sortingSongCollection.songs;

/** A class representing a song with the given title and artist. */
public class Song implements Comparable<Song> {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }


    public String toString() {
        return title + ", " + artist + ";";
    }

    @Override
    public int compareTo(Song o) {
        // FILL IN CODE: compare songs by title

        return 0;
    }
}

