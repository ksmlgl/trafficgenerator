/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.shaman.custom;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;
import md.shaman.resources.icons.PNGPacket;

/**
 *
 * @author AlexandruC
 */
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

    Hashtable<String, ImageIcon> icoH = new Hashtable<String, ImageIcon>() {

        {
//STATUS
// NEW
// RUNNABLE
// BLOCKED
// WAITING
// TIMED_WAITING
// TERMINATED
//PROTOCOL
// TCP
// UDP
// MULTICAST
            put("ALL", PNGPacket.Network.getX16());
            put("LABEL", PNGPacket.Label.getX16());
            put("NO LABEL", PNGPacket.LabelDisabled.getX16());
        }
    };

    @Override
    public Component getTreeCellRendererComponent(JTree tree,
            Object value, boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value,
                selected, expanded, leaf, row, hasFocus);

        JLabel label = (JLabel) this;
        label.setIcon(icoH.get(value.toString()));
        //label.setIcon(PNGPacket.Label.getX16());

        return this;
    }
}
