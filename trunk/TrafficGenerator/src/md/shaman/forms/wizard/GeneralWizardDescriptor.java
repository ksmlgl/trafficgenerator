/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package md.shaman.forms.wizard;

import md.shaman.custom.wizard.WizardPanelDescriptor;
import md.shaman.protocols.ProtocolConfig;

/**
 *
 * @author AlexandruC
 */
public class GeneralWizardDescriptor extends WizardPanelDescriptor{
    public static final String IDENTIFIER = "GENERAL_PANEL";
    GeneralWizardPanel gwp;
    public GeneralWizardDescriptor() {
        gwp = new GeneralWizardPanel();

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
    public void aboutToHidePanel() {
        ProtocolConfig.setDirection(gwp.directionComboBox.getSelectedItem().toString());
        ProtocolConfig.setType(gwp.protocolTypeComboBox.getSelectedItem().toString());
    }
}
