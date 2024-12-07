package com.lovecaa.project.create;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class AScriptModuleWizardStep extends ModuleWizardStep {

    @Override
    public JComponent getComponent() {
        return new JLabel("Provide some setting here");
    }

    @Override
    public void updateDataModel() {
        // todo update model according to UI
    }

}