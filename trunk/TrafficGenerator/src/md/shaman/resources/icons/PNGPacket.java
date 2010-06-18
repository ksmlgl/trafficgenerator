package md.shaman.resources.icons;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

public class PNGPacket {

    public static PNGPacket NetworkUtility = new PNGPacket("NetworkUtility");
    public static PNGPacket iSync = new PNGPacket("iSync");
    public static PNGPacket SystemPreferences = new PNGPacket("SystemPreferences");

    
    private List<ImageIcon> images = new LinkedList<ImageIcon>();

    public List<ImageIcon> getImageIcons() {
        return images;
    }

    public List<Image> getImages()
    {
        List<Image> i = new LinkedList<Image>();
         for (ImageIcon img : getImageIcons())
             i.add(img.getImage());
         return i;
    }

    public ImageIcon getX16() {
        return images.get(0);
    }

    public ImageIcon getX32() {
        return images.get(1);
    }

    public ImageIcon getX48() {
        return images.get(2);
    }

    public ImageIcon getX128() {
        return images.get(3);
    }

    public ImageIcon getX256() {
        return images.get(4);
    }

    public PNGPacket(final String name) {
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_16.png")));
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_32.png")));
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_48.png")));
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_128.png")));
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_256.png")));
    }

    public static void main(String[] args) {
        PNGPacket pp = PNGPacket.NetworkUtility;
        for (ImageIcon img : pp.getImageIcons()) {
            System.out.println(img.getIconHeight());
        }

    }
}
