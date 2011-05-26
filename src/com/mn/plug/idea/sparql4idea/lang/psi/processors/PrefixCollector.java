package com.mn.plug.idea.sparql4idea.lang.psi.processors;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;
import com.mn.plug.idea.sparql4idea.lang.psi.PNameNsDeclaration;
import com.mn.plug.idea.sparql4idea.lang.psi.toplevel.PrefixDeclaration;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds a prefix declaration that matches the given namespace reference.
 *
 * @author Matt Nathan
 */
public class PrefixCollector extends BaseScopeProcessor {

  private List<LookupElement> variants = new ArrayList<LookupElement>();

  public PrefixCollector() {
  }

  @Override
  public boolean execute(PsiElement element, ResolveState state) {
    if (element instanceof PrefixDeclaration) {
      final PrefixDeclaration prefixDeclaration = (PrefixDeclaration) element;
      final PNameNsDeclaration ns = prefixDeclaration.getNs();
      if (ns != null) {
        variants.add(LookupElementBuilder.create(ns));
      }
    }

    return true;
  }

  public Object[] getVariants() {
    return variants.toArray(new Object[variants.size()]);
  }
}
