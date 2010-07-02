/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman.forms.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import md.shaman.custom.wizard.WizardPanelDescriptor;

/**
 *
 * @author AlexandruC
 */
public class GeneralWizardDescriptor extends WizardPanelDescriptor{
    public static final String IDENTIFIER = "GENERAL_PANEL";
    Object NEXT_IDENTIFIER;
    GeneralWizardPanel gwp;
    public GeneralWizardDescriptor() {
        gwp = new GeneralWizardPanel();

        NEXT_IDENTIFIER = GeneralSendReceiveWizardDescriptor.IDENTIFIER;

        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(gwp);
    }

    @Override
    public Object getNextPanelDescriptor() {
        return GeneralSendReceiveWizardDescriptor.IDENTIFIER;
    }

    @Override
    public Object getBackPanelDescriptor() {
        return null;
    }
}
