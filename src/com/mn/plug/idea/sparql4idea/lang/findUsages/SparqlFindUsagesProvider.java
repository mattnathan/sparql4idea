package com.mn.plug.idea.sparql4idea.lang.findUsages;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlLexer;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypeSets;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.psi.PNameNsDeclaration;
import org.jetbrains.annotations.NotNull;

/**
 * Find usages provider
 *
 * @author Matt Nathan
 */
public class SparqlFindUsagesProvider implements FindUsagesProvider {

  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner(new SparqlLexer(),
            TokenSet.create(SparqlTokenTypes.LIT_PNAME_LN, SparqlTokenTypes.LIT_PNAME_NS, SparqlTokenTypes.VAR),
            SparqlTokenTypeSets.COMMENTS,
            TokenSet.create());
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof PNameNsDeclaration;
  }

  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    return "";
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof PsiNamedElement) {
      final String name = ((PsiNamedElement) element).getName();
      return name == null ? element.toString() : name;
    }
    return element.toString();
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    return element.toString();
  }
}
