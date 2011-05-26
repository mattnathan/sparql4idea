package com.mn.plug.idea.sparql4idea.lang.psi.expressions;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Variable Declaration
 *
 * @author Matt Nathan
 */
public class VariableDeclaration extends VariableBase {

  public VariableDeclaration(@NotNull ASTNode node) {
    super(node);
  }
}
