package com.mn.plug.idea.sparql4idea.lang.psi.query;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Where clause
 *
 * @author Matt Nathan
 */
public class WhereClause extends ASTWrapperPsiElement {

  public WhereClause(@NotNull ASTNode node) {
    super(node);
  }
}
