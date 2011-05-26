package com.mn.plug.idea.sparql4idea.lang.psi.graph;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.mn.plug.idea.sparql4idea.lang.psi.expressions.VariableDeclaration;
import org.jetbrains.annotations.NotNull;

/**
 * Triples block
 *
 * @author Matt Nathan
 */
public class TripleBlock extends ASTWrapperPsiElement {

  public TripleBlock(@NotNull ASTNode node) {
    super(node);
  }

  public VariableDeclaration getSubject() {
    return findChildByClass(VariableDeclaration.class);
  }

  @Override
  public String toString() {
    return "TriplesBlock(" + getSubject() + " ...)";
  }
}
