public class Song {
    private String name;
    private final int duration; //in seconds

    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String toString() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }
}
