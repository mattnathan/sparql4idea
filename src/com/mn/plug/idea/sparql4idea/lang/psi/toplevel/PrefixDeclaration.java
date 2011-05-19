package com.mn.plug.idea.sparql4idea.lang.psi.toplevel;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
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
    final PNameNsDeclaration ns = findChildByClass(PNameNsDeclaration.class);
    return ns == null ? "" : ns.getName();
  }

  public String getIri() {
    final IriPsiElement iriElem = findChildByClass(IriPsiElement.class);
    return iriElem == null ? "" : iriElem.getIri();
  }

  @Override
  public String toString() {
    return "PrefixDeclaration(" + getNsLabel() + ", " + getIri() + ")";
  }
}
