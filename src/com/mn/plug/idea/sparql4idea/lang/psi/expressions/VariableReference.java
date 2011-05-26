package com.mn.plug.idea.sparql4idea.lang.psi.expressions;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Variable reference
 *
 * @author Matt Nathan
 */
public class VariableReference extends VariableBase {

  public VariableReference(@NotNull ASTNode node) {
    super(node);
  }
}
