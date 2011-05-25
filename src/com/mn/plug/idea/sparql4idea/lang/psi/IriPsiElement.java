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
    final PsiElement iri = findChildByType(SparqlTokenTypes.LIT_IRI_BODY);
    if (iri == null) {
      return "";
    }
    return iri.getText();
  }

  @Override
  public String toString() {
    return "IriElement(" + getIri() + ")";
  }
}
