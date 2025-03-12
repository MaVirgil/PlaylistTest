public class Main {
    public static void main(String[] args) {

        Playlist chill = new Playlist("Chill");
        Playlist exciting = new Playlist("Exciting");

        Song test = new Song("Very Funny", 152);
        Song test2 = new Song("Moonlight", 143);
        Song test3 = new Song("Brave", 123);

        chill.addSong(test).addSong(test2).addSong(test3);

        Menu.mainMenu();

    }
}
