package com.mn.plug.idea.sparql4idea.lang.psi.toplevel;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.mn.plug.idea.sparql4idea.lang.psi.IriPsiElement;
import com.mn.plug.idea.sparql4idea.lang.psi.PNameExpression;
import com.mn.plug.idea.sparql4idea.lang.psi.PNameNsDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Prefix element
 *
 * @author Matt Nathan
 */
public class PrefixDeclaration extends ASTWrapperPsiElement {

  public PrefixDeclaration(@NotNull ASTNode node) {
    super(node);
  }

  @NotNull
  public String getNsValue() {
    final PNameNsDeclaration ns = getNs();
    return ns == null ? "" : ns.getText();
  }

  @Nullable
  public PNameNsDeclaration getNs() {
    final PNameExpression pname = findChildByClass(PNameExpression.class);
    return pname == null ? null : pname.getNamespace();
  }

  @NotNull
  public String getIriValue() {
    final IriPsiElement iriElem = getIri();
    return iriElem == null ? "" : iriElem.getIri();
  }

  @Nullable
  private IriPsiElement getIri() {
    return findChildByClass(IriPsiElement.class);
  }

  @Override
  public String toString() {
    return "PrefixDeclaration(" + getNsValue() + ", " + getIriValue() + ")";
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return processor.execute(this, state);
  }
}
