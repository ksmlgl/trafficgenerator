/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman.forms.wizard;

import md.shaman.custom.wizard.WizardPanelDescriptor;

/**
 *
 * @author AlexandruC
 */
public class GeneralWizardDescriptor extends WizardPanelDescriptor{
    public static final String IDENTIFIER = "GENERAL_PANEL";

    public GeneralWizardDescriptor() {
        super(IDENTIFIER, new GeneralWizardPanel());
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
