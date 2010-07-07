/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.shaman.forms.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import md.shaman.custom.wizard.WizardPanelDescriptor;
import md.shaman.protocols.Protocol;
import md.shaman.protocols.ProtocolConfig;

/**
 *
 * @author AlexandruC
 */
public class GeneralSendReceiveWizardDescriptor extends WizardPanelDescriptor implements KeyListener {

    public static final String IDENTIFIER = "GENERAL_SEND_RECEIVE_PANEL";
    GeneralSendReceiveWizardPanel gsrwp;

    public GeneralSendReceiveWizardDescriptor() {
        gsrwp = new GeneralSendReceiveWizardPanel();

        gsrwp.addValidateEvent(this);

        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(gsrwp);

    }

    public void aboutToHidePanel() {
        ProtocolConfig.setIp(gsrwp.ipTextField.getText());
        ProtocolConfig.setIpPort(gsrwp.ipPortTextField.getText());
        ProtocolConfig.setNic(gsrwp.nicComboBox.getSelectedItem().toString());
        ProtocolConfig.setNicPort(gsrwp.nicPortTextField.getText());
    }

    @Override
    public void displayingPanel() {
        getWizard().setNextFinishButtonEnabled(gsrwp.isValidate());
    }

    @Override
    public void aboutToDisplayPanel() {
        gsrwp.nicComboBox.removeAllItems();
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets)) {
                Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    gsrwp.nicComboBox.addItem(inetAddress.toString().substring(1));
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        if (!ProtocolConfig.getNic().isEmpty()) {
            gsrwp.nicComboBox.setSelectedItem(ProtocolConfig.getNic());
        }
    }

    @Override
    public Object getNextPanelDescriptor() {
        switch (ProtocolConfig.getDirection()) {
            case SEND:
                return GeneralTrafficWizardDescriptor.IDENTIFIER;
            case RECEIVE:
                return FINISH;
            default:
                return FINISH;
        }
    }

    @Override
    public Object getBackPanelDescriptor() {
        return GeneralWizardDescriptor.IDENTIFIER;
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        getWizard().setNextFinishButtonEnabled(gsrwp.isValidate());
    }

    public void keyTyped(KeyEvent e) {
    }
}
