package com.mn.plug.idea.sparql4idea.lang.psi.graph;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Triple property
 *
 * @author Matt Nathan
 */
public class TripleProperty extends ASTWrapperPsiElement {

  public TripleProperty(@NotNull ASTNode node) {
    super(node);
  }

  public PsiElement getPredicate() {
    return getFirstChild();
  }

  @Override
  public String toString() {
    return "TripleProperty(" + getPredicate() + " ...)";
  }
}
