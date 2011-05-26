package com.mn.plug.idea.sparql4idea.lang.psi.processors;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;
import com.mn.plug.idea.sparql4idea.lang.psi.PNameNsDeclaration;
import com.mn.plug.idea.sparql4idea.lang.psi.toplevel.PrefixDeclaration;

/**
 * Finds a prefix declaration that matches the given namespace reference.
 *
 * @author Matt Nathan
 */
public class PrefixResolver extends BaseScopeProcessor {

  private PrefixDeclaration prefixDeclaration;
  private final PNameNsDeclaration targetType;

  public PrefixResolver(PNameNsDeclaration targetType) {
    this.targetType = targetType;
  }

  @Override
  public boolean execute(PsiElement element, ResolveState state) {
    if (element instanceof PrefixDeclaration) {
      if (targetType.getText().equals(((PrefixDeclaration) element).getNsValue())) {
        this.prefixDeclaration = (PrefixDeclaration) element;
        return false;
      }
    }

    return true;
  }

  public PNameNsDeclaration getResolvedNs() {
    return prefixDeclaration == null ? null : prefixDeclaration.getNs();
  }

  public PrefixDeclaration getResolvedPrefixDeclaration() {
    return prefixDeclaration;
  }
}
