import java.util.*;

class Song {
    private String title;
    private String artist;
    private int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Duration: " + duration;
    }
}

 public class PlaylistManager {
    private HashMap<Integer, Song> playlist;

    public PlaylistManager() {
        playlist = new HashMap<>();
    }

    public int getNextId() {
        if (playlist.isEmpty()) {
            return 1;
        } else {
            return Collections.max(playlist.keySet()) + 1;
        }
    }

    public void addSong(int id, String title, String artist, int duration) {
        playlist.put(id, new Song(title, artist, duration));
    }

    public void removeSong(int id) {
        playlist.remove(id);
    }

    public void updateSong(int id, String title, String artist, int duration) {
        playlist.put(id, new Song(title, artist, duration));
    }

    public List<Song> searchByTitleOrArtist(String keyword) {
        List<Song> result = new ArrayList<>();
        for (Song song : playlist.values()) {
            if (song.getTitle().contains(keyword) || song.getArtist().contains(keyword)) {
                result.add(song);
            }
        }
        return result;
    }

    public List<Song> displaySortedByTitle() {
        List<Song> sortedList = new ArrayList<>(playlist.values());
        sortedList.sort(Comparator.comparing(Song::getTitle));
        return sortedList;
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (Song song : playlist.values()) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }

    public static void main(String[] args) {
        PlaylistManager manager = new PlaylistManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Playlist Manager Menu =====");
            System.out.println("1. Add a new song");
            System.out.println("2. Remove a song");
            System.out.println("3. Search for a song by title or artist");
            System.out.println("4. Display all songs sorted by title");
            System.out.println("5. Display total duration of all songs");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title of the song: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist of the song: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration of the song (in seconds): ");
                    int duration = scanner.nextInt();
                    manager.addSong(manager.getNextId(), title, artist, duration);
                    System.out.println("Song added successfully!");
                    break;
                case 2:
                    System.out.print("Enter the ID of the song to remove: ");
                    int idToRemove = scanner.nextInt();
                    manager.removeSong(idToRemove);
                    System.out.println("Song removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter keyword to search by title or artist: ");
                    String keyword = scanner.nextLine();
                    List<Song> searchResults = manager.searchByTitleOrArtist(keyword);
                    if (searchResults.isEmpty()) {
                        System.out.println("No matching songs found!");
                    } else {
                        System.out.println("Search Results:");
                        for (Song song : searchResults) {
                            System.out.println(song);
                        }
                    }
                    break;
                case 4:
                    List<Song> sortedList = manager.displaySortedByTitle();
                    System.out.println("Sorted Playlist:");
                    for (Song song : sortedList) {
                        System.out.println(song);
                    }
                    break;
                case 5:
                    System.out.println("Total Duration: " + manager.getTotalDuration() + " seconds");
                    break;
                case 6:
                    System.out.println("Exiting Playlist Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
}
