public class Menu {

    private static String userString;
    private static int userInt;

    public static void mainMenu() {

        while(true) {
            System.out.println("Please select a playlist: ");
            System.out.println(Playlist.getPlaylistsString());
            System.out.println((Playlist.getArrayList().size() + 1) + ": Exit");

            userInt = IO.getUserInt(Playlist.getSize() + 1);

            if (userInt == 3) return;

            playlistMenu(Playlist.getArrayList().get(userInt - 1));
        }

    }

    public static void playlistMenu(Playlist pl) {

        while(true) {
            System.out.println("You are now editing " + pl + "\n" +
                    "1: Add song\n" +
                    "2: Remove song\n" +
                    "3: Show songs\n" +
                    "4: Find song\n" +
                    "5: Back to main menu");

            userInt = IO.getUserInt(5);

            switch (userInt) {
                case 1:
                    addSongMenu(pl);
                    break;
                case 2:
                    removeSongMenu(pl);
                    break;
                case 3:
                    showSongsMenu(pl);
                    break;
                case 4:
                    findSongMenu(pl);
                    break;
                case 5:
                    return;
                default:
                    throw new IllegalArgumentException("Illegal state of user input: " + userInt);
            }
        }
    }

    public static void addSongMenu(Playlist pl) {

        System.out.println("Enter song name: ");

        userString = IO.getUserString();

        System.out.println(userString);
        System.out.println("Enter song duration (in seconds):");

        userInt = IO.getUserInt();

        Song userSong = new Song(userString, userInt);

        try {
            pl.addSong(userSong);
        } catch (Exception e) {
            System.out.println(userSong + " is already in playlist");
            return;
        }

        System.out.println(userSong + " added to " + pl);
    }

    public static void removeSongMenu(Playlist pl) {
        System.out.println("select a song to remove or press " + (pl.getNumberOfSongs()+1) + " to exit:");
        System.out.println(pl.getList());

        userInt = IO.getUserInt(pl.getNumberOfSongs()+1);

        if (userInt == pl.getNumberOfSongs()+1) return;

        String songName = pl.getSongName(userInt-1);

        pl.removeSong(userInt-1);

        System.out.println("removed " + songName + " from playlist " + pl);
    }

    public static void showSongsMenu(Playlist pl) {
        System.out.println("Songs in " + pl + ":");
        System.out.println(pl.getList());
        System.out.println("press 1 to return to playlist menu");

        userInt = IO.getUserInt(1);

        //returns automatically once 1 is entered, no need for a return statement
    }

    public static void findSongMenu(Playlist pl) {

        System.out.println("Enter song name: ");

        userString = IO.getUserString();

        int songIndex = pl.getSongIndex(userString);

        if (songIndex != -1) {
            System.out.println(pl.getSongName(songIndex) + " is song number " + (songIndex+1) + " on " + pl);
            return;
        }

        System.out.println("Song \"" + userString + "\" not found in playlist " + pl);
    }

}
