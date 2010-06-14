package com.shaman.icons;

import java.io.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public class PNGPacket {
	private static File dir = new File(PNGPacket.class.getResource("").getPath());
	private Image[] images = new Image[5];

	public Image[] getImages() {
		return images;
	}
	
	public Image getX16() {
		return images[0];
	}
	public Image getX32() {
		return images[1];
	}
	public Image getX48() {
		return images[2];
	}
	public Image getX128() {
		return images[3];
	}
	public Image getX256() {
		return images[4];
	}
	
	public PNGPacket(final String name) {
		images[0] = new Image(Display.getCurrent(), new ImageData(Icon.class.getResourceAsStream(name+"_16.png")));
		images[1] = new Image(Display.getCurrent(), new ImageData(Icon.class.getResourceAsStream(name+"_32.png")));
		images[2] = new Image(Display.getCurrent(), new ImageData(Icon.class.getResourceAsStream(name+"_48.png")));
		images[3] = new Image(Display.getCurrent(), new ImageData(Icon.class.getResourceAsStream(name+"_128.png")));
		images[4] = new Image(Display.getCurrent(), new ImageData(Icon.class.getResourceAsStream(name+"_256.png")));
	}
	
	
	public static void main(String[] args){
		PNGPacket pp = new PNGPacket("NetworkUtility");
		for (Image img : pp.getImages()) {
			System.out.println(img.getImageData().height);
		}
		
	}

}
