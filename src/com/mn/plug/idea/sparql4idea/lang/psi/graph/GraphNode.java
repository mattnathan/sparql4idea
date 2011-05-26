package com.mn.plug.idea.sparql4idea.lang.psi.graph;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Graph node
 *
 * @author Matt Nathan
 */
public class GraphNode extends ASTWrapperPsiElement {

  public GraphNode(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return "GraphNode(" + Arrays.toString(getChildren()) + ")";
  }
}
