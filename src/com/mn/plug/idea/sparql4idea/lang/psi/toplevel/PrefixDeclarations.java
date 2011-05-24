package com.mn.plug.idea.sparql4idea.lang.psi.toplevel;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Prefixes
 *
 * @author Matt Nathan
 */
public class PrefixDeclarations extends ASTWrapperPsiElement {

  public PrefixDeclarations(@NotNull ASTNode node) {
    super(node);
  }

  public PrefixDeclaration[] getPrefixDeclarations() {
    return findChildrenByClass(PrefixDeclaration.class);
  }
}
