package com.mn.plug.idea.sparql4idea.lang.psi.toplevel;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.mn.plug.idea.sparql4idea.lang.psi.IriPsiElement;
import com.mn.plug.idea.sparql4idea.lang.psi.PNameNsDeclaration;
import org.jetbrains.annotations.NotNull;

/**
 * Prefix element
 *
 * @author Matt Nathan
 */
public class PrefixDeclaration extends ASTWrapperPsiElement {

  public PrefixDeclaration(@NotNull ASTNode node) {
    super(node);
  }

  public String getNsLabel() {
    final PNameNsDeclaration ns = getNs();
    return ns == null ? "" : ns.getName();
  }

  public PNameNsDeclaration getNs() {
    return findChildByClass(PNameNsDeclaration.class);
  }

  public String getIriValue() {
    final IriPsiElement iriElem = getIri();
    return iriElem == null ? "" : iriElem.getIri();
  }

  private IriPsiElement getIri() {
    return findChildByClass(IriPsiElement.class);
  }

  @Override
  public String toString() {
    return "PrefixDeclaration(" + getNsLabel() + ", " + getIriValue() + ")";
  }
}
