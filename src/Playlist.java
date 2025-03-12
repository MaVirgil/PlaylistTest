import java.util.ArrayList;
import java.util.List;

public class Playlist {

    //Static arrayList for keeping track of playlists
    private static ArrayList<Playlist> playlists = new ArrayList<>();

    //instance fields:
    private ArrayList<Song> songs = new ArrayList<>();
    private String name;
    private int totalDuration;

    //playlist constructor
    public Playlist(String name) {
        this.name = name;
        Playlist.add(this);
    }

    //non-static methods:

    public Playlist addSong(Song song) {

        for (Song s : this.songs) {
            if (song.toString().equalsIgnoreCase(s.toString())) {
                throw new IllegalArgumentException(song + " is already in playlist");
            }
        }
        this.songs.add(song);
        totalDuration += song.getDuration();
        return this;
    }

    public void removeSong(int songIndex) {
        this.songs.remove(songIndex);
    }

    public String getList() {
        int i = 1;
        String output = "";

        for (Song song : this.songs) {
            output += i + ": ";
            output += song + "\n";
            i++;
        }

        return output;
    }

    public String getSongName(int index) {
        return this.songs.get(index).toString();
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public int getNumberOfSongs() {
        return this.songs.size();
    }

    public int getSongIndex(String songName) {
        //returns index of song or -1 if song isn't found

        boolean hasSong = false;
        int songIndex = -1;

        for (Song s : songs) {
            if (songName.equalsIgnoreCase(s.toString())) {
                hasSong = true;
                songIndex = songs.indexOf(s);
            }
        }

        return songIndex;
    }

    public String toString() {
        return this.name;
    }

    //Static methods for keeping track of how many different playlists:
    public static void remove(Playlist pl) {
        if (!playlists.contains(pl)) {
            System.out.println(pl.name + " not found!");
        }
        playlists.remove(pl);
    }

    public static void add(Playlist pl) {
        if (playlists.contains(pl)) {
            System.out.println("Playlist " + pl + "already exists!");
            return;
        }
        playlists.add(pl);
    }

    public static String getPlaylistsString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < playlists.size(); i++) {
            output.append((i + 1)).append(": ").append(playlists.get(i));
            if (i != playlists.size()-1) output.append("\n");
        }
        return output.toString();
    }

    public static int getSize() {
        return playlists.size();
    }

    public static List<Playlist> getArrayList() {
        return List.copyOf(playlists);
    }
}
