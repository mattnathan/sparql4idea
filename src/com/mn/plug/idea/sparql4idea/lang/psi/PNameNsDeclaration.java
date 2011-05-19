package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import com.mn.plug.idea.sparql4idea.lang.psi.toplevel.PrefixDeclaration;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * PNameNs declaration (i.e. 'my:' )
 *
 * @author Matt Nathan
 */
public class PNameNsDeclaration extends ASTWrapperPsiElement implements PsiNamedElement, PsiReference {

  public PNameNsDeclaration(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String getName() {
    return getText().substring(0, getText().length() - 1);
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    return null;
  }

  @Override
  public String toString() {
    return "PNameNs(" + getName() + ")";
  }

  @Override
  public PsiReference getReference() {
    System.out.println("PNameNsDeclaration.getReference");
    final SparqlFileImpl containingFile = (SparqlFileImpl) getContainingFile();
    final PrefixDeclaration[] prefixDeclarations = containingFile.getPrefixDeclarations();
    for (PrefixDeclaration prefixDeclaration : prefixDeclarations) {
      if (prefixDeclaration.getNs() != this && prefixDeclaration.getNsLabel().equals(getName())) {
        return this;
      }
    }
    return super.getReference();
  }

  @Override
  public PsiElement getElement() {
    return this;
  }

  @Override
  public TextRange getRangeInElement() {
    return new TextRange(0, getText().length() - 1);
  }

  @Override
  public PsiElement resolve() {
    System.out.println("PNameNsDeclaration.resolve");
    final SparqlFileImpl containingFile = (SparqlFileImpl) getContainingFile();
    final PrefixDeclaration[] prefixDeclarations = containingFile.getPrefixDeclarations();
    for (PrefixDeclaration prefixDeclaration : prefixDeclarations) {
      if (prefixDeclaration.getNs() != this && prefixDeclaration.getNsLabel().equals(getName())) {
        return prefixDeclaration.getNs();
      }
    }
    return null;
  }

  @NotNull
  @Override
  public String getCanonicalText() {
    final String name = getName();
    return name == null ? "" : name;
  }

  @Override
  public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
    /* @todo Auto-generated method body */
    return null;
  }

  @Override
  public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
    /* @todo Auto-generated method body */
    return null;
  }

  @Override
  public boolean isReferenceTo(PsiElement element) {
    if (element instanceof PNameNsDeclaration) {
      final String name = ((PNameNsDeclaration) element).getName();
      return name == null ? getName() == null : name.equals(getName());
    }
    return false;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[] {getName()};
  }

  @Override
  public boolean isSoft() {
    return false;
  }
}
