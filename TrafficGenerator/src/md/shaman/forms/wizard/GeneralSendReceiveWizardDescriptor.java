/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.shaman.forms.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import md.shaman.custom.wizard.WizardPanelDescriptor;

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

    @Override
    public void displayingPanel() {
        getWizard().setNextFinishButtonEnabled(gsrwp.isValidate());
    }

    @Override
    public Object getNextPanelDescriptor() {
        return GeneralTrafficWizardDescriptor.IDENTIFIER;
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
