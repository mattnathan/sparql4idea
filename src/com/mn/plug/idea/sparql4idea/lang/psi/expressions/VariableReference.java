package com.mn.plug.idea.sparql4idea.lang.psi.expressions;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.search.PsiElementProcessor;
import com.intellij.psi.util.PsiElementFilter;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Variable reference
 *
 * @author Matt Nathan
 */
public class VariableReference extends VariableBase {

  public VariableReference(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public PsiReference getReference() {
    return new PsiPolyVariantReferenceBase<VariableReference>(this, new TextRange(0, getTextLength()), false) {
      @NotNull
      @Override
      public ResolveResult[] multiResolve(boolean incompleteCode) {
        final PsiElementProcessor.CollectFilteredElements<VariableDeclaration> processor =
                new PsiElementProcessor.CollectFilteredElements<VariableDeclaration>(new PsiElementFilter() {
                  @Override
                  public boolean isAccepted(PsiElement element) {
                    return element instanceof VariableDeclaration &&
                            ((VariableDeclaration) element).getVarName().equals(getVarName());
                  }
                });
        PsiTreeUtil.processElements(getContainingFile(), processor);
        final Collection<VariableDeclaration> collection = processor.getCollection();
        ResolveResult[] result = new ResolveResult[collection.size()];
        int i = 0;
        for (VariableDeclaration variableDeclaration : collection) {
          result[i++] = new PsiElementResolveResult(variableDeclaration);
        }
        return result;
      }

      @NotNull
      @Override
      public Object[] getVariants() {
        final PsiElementProcessor.CollectFilteredElements<VariableDeclaration> processor =
                new PsiElementProcessor.CollectFilteredElements<VariableDeclaration>(new PsiElementFilter() {
                  @Override
                  public boolean isAccepted(PsiElement element) {
                    return element instanceof VariableDeclaration;
                  }
                });
        PsiTreeUtil.processElements(getContainingFile(), processor);
        final Collection<VariableDeclaration> collection = processor.getCollection();
        return collection.toArray(new Object[collection.size()]);
      }
    };
  }
}
