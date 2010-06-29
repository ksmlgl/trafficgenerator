package md.shaman.resources.icons;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

public class PNGPacket {
    String fileseparator = System.getProperty("file.separator");
    public static PNGPacket Add = new PNGPacket("list-add");
    public static PNGPacket Network = new PNGPacket("network-wired");
    public static PNGPacket HelpAbout = new PNGPacket("help-about");
    public static PNGPacket Preferences = new PNGPacket("preferences-system");
    
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

    public ImageIcon getX72() {
        return images.get(3);
    }
    
    public ImageIcon getX128() {
        return images.get(3);
    }

    public PNGPacket(final String name) {
        images.add(new ImageIcon(PNGPacket.class.getResource("16/"+name+".png")));
        images.add(new ImageIcon(PNGPacket.class.getResource("32/"+name+".png")));
        images.add(new ImageIcon(PNGPacket.class.getResource("48/"+name+".png")));
        images.add(new ImageIcon(PNGPacket.class.getResource("72/"+name+".png")));
        images.add(new ImageIcon(PNGPacket.class.getResource("128/"+name+".png")));
    }

    public static void main(String[] args) {
        PNGPacket pp = PNGPacket.Add;
        for (ImageIcon img : pp.getImageIcons()) {
            System.out.println(img.getIconHeight());
        }

    }
}
