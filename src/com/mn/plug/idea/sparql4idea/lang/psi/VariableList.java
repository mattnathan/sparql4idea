package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.mn.plug.idea.sparql4idea.lang.psi.expressions.VariableBase;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class VariableList extends ASTWrapperPsiElement {

  public VariableList(@NotNull ASTNode node) {
    super(node);
  }

  public VariableBase[] getVariables() {
    return findChildrenByClass(VariableBase.class);
  }

  @Override
  public String toString() {
    return "VariableList(" + Arrays.toString(getVariables()) + ")";
  }
}
