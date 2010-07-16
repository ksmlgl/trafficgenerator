/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman.forms.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import md.shaman.custom.wizard.WizardPanelDescriptor;
import md.shaman.protocols.ProtocolConfig;

/**
 *
 * @author AlexandruC
 */
public class GeneralFinishWizardDescriptor extends WizardPanelDescriptor implements ActionListener{
    public static final String IDENTIFIER = "GENERAL_FINISH_PANEL";
    GeneralFinishWizardPanel gfwp;
    public GeneralFinishWizardDescriptor() {
        gfwp = new GeneralFinishWizardPanel();

        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(gfwp);
        gfwp.startNowCheckBox.addActionListener(this);
    }

    @Override
    public Object getNextPanelDescriptor() {
        return FINISH;
    }

    @Override
    public Object getBackPanelDescriptor() {
        switch (ProtocolConfig.getDirection()) {
            case SEND:
                return GeneralTrafficWizardDescriptor.IDENTIFIER;
            case RECEIVE:
                return GeneralSendReceiveWizardDescriptor.IDENTIFIER;
            default:
                return GeneralSendReceiveWizardDescriptor.IDENTIFIER;
        }
    }

    public void actionPerformed(ActionEvent e) {
        ProtocolConfig.setStartNow(gfwp.startNowCheckBox.isSelected());
    }
}
