package md.shaman.test;

import md.shaman.custom.wizard.WizardPanelDescriptor;
import md.shaman.custom.wizard.*;

import java.awt.*;
import javax.swing.*;


public class TestPanel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "INTRODUCTION_PANEL";
    
    public TestPanel1Descriptor() {
        super(IDENTIFIER, new TestPanel1());
    }
    
    public Object getNextPanelDescriptor() {
        return TestPanel2Descriptor.IDENTIFIER;
    }
    
    public Object getBackPanelDescriptor() {
        return null;
    }  
    
}
