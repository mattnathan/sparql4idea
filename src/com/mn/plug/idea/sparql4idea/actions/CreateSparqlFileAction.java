package com.mn.plug.idea.sparql4idea.actions;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.ui.SizedIcon;
import com.mn.plug.idea.sparql4idea.SparqlIcons;
import com.mn.plug.idea.sparql4idea.lang.psi.SparqlFileImpl;

import javax.swing.*;

/**
 * File template action for sparql queries
 *
 * @author Matt Nathan
 */
public class CreateSparqlFileAction extends CreateFileFromTemplateAction {

  public CreateSparqlFileAction() {
    super("New SPARQL Query File", "Create a new SPARQL query file", SparqlIcons.XQUERY_ICON_16x16);
  }

  @Override
  protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
    builder.setTitle("SPARQL Query")
            .addKind("Select Query", SparqlIcons.XQUERY_ICON_16x16, FileTemplateManager.INTERNAL_HTML_TEMPLATE_NAME);
  }

  @Override
  protected String getActionName(PsiDirectory directory, String newName, String templateName) {
    return "SPARQL Query";
  }
}
