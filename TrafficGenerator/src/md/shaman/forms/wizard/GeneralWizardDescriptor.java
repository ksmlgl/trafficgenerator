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

    public Object getNextPanelDescriptor() {
        return FINISH;
    }

    public Object getBackPanelDescriptor() {
        return null;
    }

}
