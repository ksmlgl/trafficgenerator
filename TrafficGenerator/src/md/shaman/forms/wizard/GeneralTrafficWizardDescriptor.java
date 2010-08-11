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
public class GeneralTrafficWizardDescriptor extends WizardPanelDescriptor{
    public static final String IDENTIFIER = "GENERAL_TRAFFIC_PANEL";
    GeneralTrafficWizardPanel gtwp;
    public GeneralTrafficWizardDescriptor()
    {
        gtwp = new GeneralTrafficWizardPanel();
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(gtwp);
    }
    @Override
    public Object getNextPanelDescriptor() {
        return GeneralFinishWizardDescriptor.IDENTIFIER;
    }

    @Override
    public Object getBackPanelDescriptor() {
        return GeneralSendReceiveWizardDescriptor.IDENTIFIER;
    }

    @Override
    public void aboutToHidePanel() {
        ProtocolConfig.setPacketNo(gtwp.packetNoSpinner.getValue().toString());
        ProtocolConfig.setDataSize(gtwp.packetDataSizeSpinner.getValue().toString());
        ProtocolConfig.setDelay(gtwp.packetDelaySpinner.getValue().toString());
    }
}
