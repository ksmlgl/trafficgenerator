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
public class GeneralTrafficWizardDescriptor extends WizardPanelDescriptor{
    public static final String IDENTIFIER = "GENERAL_TRAFFIC_PANEL";

    public GeneralTrafficWizardDescriptor()
    {
        super(IDENTIFIER, new GeneralTrafficWizardPanel());
    }
    @Override
    public Object getNextPanelDescriptor() {
        return FINISH;
    }

    @Override
    public Object getBackPanelDescriptor() {
        return GeneralSendReceiveWizardDescriptor.IDENTIFIER;
    }
}
