package ly.readon.notifier;

import net.frotz.sonos.Discover;
import net.frotz.sonos.Sonos;

/**
 * @author Bernd Verst(@berndverst)
 */
public class SonosPlayer {

    public static void main(String[] args) {

        Discover d = new Discover();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException x) {
        }
        d.done();
        String[] list = d.getList();
        for (int n = 0; n < list.length; n++) {
            Sonos s = new Sonos(list[n]);
            String name = s.getZoneName();
            if (name != null)
                System.out.println(list[n] + " - " + name);
        }

        if (list.length > 0) {
            Sonos speaker = new Sonos(list[0]);
            speaker.setTransportURI("x-rincon-mp3radio://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
            speaker.play();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            speaker.stop();
        }
    }
}
