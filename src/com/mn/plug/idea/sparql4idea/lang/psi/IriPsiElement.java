package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class IriPsiElement extends ASTWrapperPsiElement {

  public IriPsiElement(@NotNull ASTNode node) {
    super(node);
  }

  public String getIri() {
    final PsiElement iri = findChildByType(SparqlTokenTypes.LIT_IRI);
    if (iri == null) {
      return "";
    }
    final String text = iri.getText();
    return text.substring(1, text.length() - 1);
  }

  @Override
  public String toString() {
    return "IriElement(" + getIri() + ")";
  }
}
