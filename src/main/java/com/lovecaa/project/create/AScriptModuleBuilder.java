package com.lovecaa.project.create;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.jetbrains.python.module.PythonModuleBuilderBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class AScriptModuleBuilder extends PythonModuleBuilderBase {

    @Override
    public void setupRootModel(@NotNull ModifiableRootModel model) {
        System.out.println(1);
    }

    @Override
    public ModuleType<AScriptModuleBuilder> getModuleType() {
        return AScriptModuleType.getInstance();
    }

    @Nullable
    @Override
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new AScriptModuleWizardStep();
    }

    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
        return new ModuleWizardStep[]{new ModuleWizardStep() {
            @Override
            public JComponent getComponent() {
                return new JLabel("Put your content here");
            }

            @Override
            public void updateDataModel() {

            }
        }};
    }

    @Override
    public boolean isAvailable() {
        return super.isAvailable();
    }
}