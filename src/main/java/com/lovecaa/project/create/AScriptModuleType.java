package com.lovecaa.project.create;

import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.jetbrains.python.icons.PythonIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public final class AScriptModuleType extends ModuleType<AScriptModuleBuilder> {

    private static final String ID = "A_SCRIPT_MODULE_TYPE";

    AScriptModuleType() {
        super(ID);
    }

    public static AScriptModuleType getInstance() {
        return (AScriptModuleType) ModuleTypeManager.getInstance().findByID(ID);
    }

    @NotNull
    @Override
    public AScriptModuleBuilder createModuleBuilder() {
        return new AScriptModuleBuilder();
    }

    @NotNull
    @Override
    public String getName() {
        return "AScript";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Create an AScript Project";
    }

    @Override
    public @NotNull Icon getIcon() {
        return PythonIcons.Python.PythonClosed;
    }

    @NotNull
    @Override
    public Icon getNodeIcon(@Deprecated boolean b) {
        return PythonIcons.Python.PythonClosed;
    }
}