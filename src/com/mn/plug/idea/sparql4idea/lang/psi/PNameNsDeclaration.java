package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.ObjectPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.scope.util.PsiScopesUtil;
import com.intellij.util.IncorrectOperationException;
import com.mn.plug.idea.sparql4idea.lang.psi.processors.PrefixCollector;
import com.mn.plug.idea.sparql4idea.lang.psi.processors.PrefixResolver;
import com.mn.plug.idea.sparql4idea.lang.psi.toplevel.PrefixDeclaration;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PNameNs declaration (i.e. 'my':local )
 *
 * @author Matt Nathan
 */
public class PNameNsDeclaration extends ASTWrapperPsiElement implements PsiNamedElement {

  public PNameNsDeclaration(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String getName() {
    return getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    return null;
  }

  @Override
  public String toString() {
    return "PNAME NS(" + getName() + ")";
  }

  @Override
  public PsiReference getReference() {
    PsiElement parent = getParent();
    while (parent != null) {
      if (parent instanceof PrefixDeclaration) {
        return super.getReference();
      }
      parent = parent.getParent();
    }
    return new NsReference();
  }

  private class NsReference implements PsiReference {

    public NsReference() {
    }

    @Override
    public PNameNsDeclaration getElement() {
      return PNameNsDeclaration.this;
    }

    @Override
    public TextRange getRangeInElement() {
      return new TextRange(0, getElement().getTextLength());
    }

    @Override
    public PNameNsDeclaration resolve() {
      PrefixResolver resolver = new PrefixResolver(getElement());
      if (!PsiScopesUtil.treeWalkUp(resolver, getElement(), getElement().getContainingFile())) {
        return resolver.getResolvedNs();
      }
      return null;
    }

    @NotNull
    @Override
    public String getCanonicalText() {
//      System.out.println("PNameNsDeclaration$NsReference.getCanonicalText");
      final PNameNsDeclaration reference = getElement();
      return reference == null ? "" : reference.toString();
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
//      System.out.println("PNameNsDeclaration$NsReference.handleElementRename");
      /* @todo Auto-generated method body */
      return null;
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
//      System.out.println("PNameNsDeclaration$NsReference.bindToElement");
      /* @todo Auto-generated method body */
      return null;
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
//      System.out.println("PNameNsDeclaration$NsReference.isReferenceTo");
      return element.getText().equals(getElement().getText()) && element == resolve();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
//      System.out.println("PNameNsDeclaration$NsReference.getVariants");
      PrefixCollector collector = new PrefixCollector();
      PsiScopesUtil.treeWalkUp(collector, getElement(), getElement().getContainingFile());
      return collector.getVariants();
    }

    @Override
    public boolean isSoft() {
      return false;
    }
  }
}
