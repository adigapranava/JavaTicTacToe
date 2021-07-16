import frontEnds.players;
import music.musicPlayer;


public class App {
    public static void main(String[] args) throws Exception {
        musicPlayer mus = new musicPlayer();
        mus.playSong();
        players p = new players();
        p.showButtonDemo();
    }
}
