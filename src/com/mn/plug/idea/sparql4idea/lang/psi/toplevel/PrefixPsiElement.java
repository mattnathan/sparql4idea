package com.mn.plug.idea.sparql4idea.lang.psi.toplevel;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.psi.IriPsiElement;
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
    if (nsElem != null) {
      final String text = nsElem.getText();
      return text.substring(0, text.length() - 1);
    }
    return "";
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
