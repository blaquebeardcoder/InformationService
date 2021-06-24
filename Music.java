public class Music extends ServiceCommunicator{
    public Music(String serviceURL, String song_artist ) {
        super(serviceURL + song_artist);
    }
    //test code
    public static void main(String[] args) {
        Music song = new Music("https://itunes.apple.com/search?term=","Usher"+ "&limit=1");
        System.out.println(song.get());
    }
}
