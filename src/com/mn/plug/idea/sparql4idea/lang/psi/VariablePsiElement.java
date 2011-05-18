package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class VariablePsiElement extends ASTWrapperPsiElement {

  public VariablePsiElement(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return "Variable(" + getVarName() + ")";
  }

  public String getVarName() {
    return getText() == null ? "" : getText().substring(1);
  }
}
