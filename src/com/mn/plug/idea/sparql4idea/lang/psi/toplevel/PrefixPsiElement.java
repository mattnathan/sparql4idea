package com.mn.plug.idea.sparql4idea.lang.psi.toplevel;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Prefix element
 *
 * @author Matt Nathan
 */
public class PrefixPsiElement extends ASTWrapperPsiElement {

  public PrefixPsiElement(@NotNull ASTNode node) {
    super(node);
  }

  public String getNsLabel() {
    final PsiElement nsElem = findChildByType(SparqlTokenTypes.LIT_PNAME_NS);
    final String text = nsElem.getText();
    return text.substring(0, text.length() - 1);
  }

  public String getIri() {
    final PsiElement iriElem = findChildByType(SparqlTokenTypes.LIT_IRI);
    final String text = iriElem.getText();
    return text.substring(1, text.length() - 1);
  }

  @Override
  public String toString() {
    return "PrefixDeclaration(" + getNsLabel() + ", " + getIri() + ")";
  }
}
