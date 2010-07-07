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
public class GeneralStartWizardDescriptor extends WizardPanelDescriptor{
    public static final String IDENTIFIER = "GENERAL_START_PANEL";
    GeneralStartWizardPanel gswp;
    public GeneralStartWizardDescriptor() {
        gswp = new GeneralStartWizardPanel();

        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(gswp);
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
        ProtocolConfig.setDirection(gswp.directionComboBox.getSelectedItem().toString());
        ProtocolConfig.setType(gswp.protocolTypeComboBox.getSelectedItem().toString());
    }
}
