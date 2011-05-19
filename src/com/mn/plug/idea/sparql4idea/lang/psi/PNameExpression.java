package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * PNAME expression
 *
 * @author Matt Nathan
 */
public class PNameExpression extends ASTWrapperPsiElement {

  public PNameExpression(@NotNull ASTNode node) {
    super(node);
  }

  public PNameNsDeclaration getNamespace() {
    return findChildByClass(PNameNsDeclaration.class);
  }

  public PsiElement getLocalName() {
    return null;
  }

  @Override
  public String toString() {
    final PNameNsDeclaration namespace = getNamespace();
    final PsiElement localName = getLocalName();
    return "PNAME(" +
            (namespace == null ? "" : namespace.getName()) +
            " : " +
            (localName == null ? "" : localName.getText()) + ")";
  }
}
