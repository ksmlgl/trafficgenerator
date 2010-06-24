package md.shaman.resources.icons;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

public class PNGPacket {

    public static PNGPacket Network = new PNGPacket("network");
    public static PNGPacket Plus = new PNGPacket("plus");
    public static PNGPacket Settings = new PNGPacket("settings");
    public static PNGPacket Info = new PNGPacket("info");
    
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

    public ImageIcon getX64() {
        return images.get(3);
    }

    public PNGPacket(final String name) {
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_16.png")));
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_32.png")));
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_48.png")));
        images.add(new ImageIcon(PNGPacket.class.getResource(name + "_64.png")));
    }

    public static void main(String[] args) {
        PNGPacket pp = PNGPacket.Network;
        for (ImageIcon img : pp.getImageIcons()) {
            System.out.println(img.getIconHeight());
        }

    }
}
