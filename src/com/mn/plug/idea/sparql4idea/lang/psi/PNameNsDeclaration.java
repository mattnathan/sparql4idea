package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * PNameNs declaration (i.e. 'my:' )
 *
 * @author Matt Nathan
 */
public class PNameNsDeclaration extends ASTWrapperPsiElement implements PsiNamedElement {

  public PNameNsDeclaration(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String getName() {
    return getText().substring(0, getText().length() - 1);
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    return null;
  }

  @Override
  public String toString() {
    return "PNameNs(" + getName() + ")";
  }
}
