package com.mn.plug.idea.sparql4idea.lang.psi.expressions;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import com.mn.plug.idea.sparql4idea.lang.psi.VariableList;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public abstract class VariableBase extends ASTWrapperPsiElement implements PsiNamedElement {

  public VariableBase(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" + getVarName() + ")";
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
