package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class VariablePsiElement extends ASTWrapperPsiElement implements PsiNamedElement {

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

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    return null;
  }

  @Override
  public String getName() {
    return getVarName();
  }
}
