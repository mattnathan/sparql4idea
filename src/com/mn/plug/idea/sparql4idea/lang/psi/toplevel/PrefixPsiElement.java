package com.mn.plug.idea.sparql4idea.lang.psi.toplevel;

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
public class PrefixPsiElement extends ASTWrapperPsiElement {

  public PrefixPsiElement(@NotNull ASTNode node) {
    super(node);
  }

  public String getNsLabel() {
    final PsiElement nsElem = findChildByType(SparqlTokenTypes.LIT_PNAME_NS);
    return nsElem.getText();
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " {" + getNsLabel() + ":<???>}";
  }
}
