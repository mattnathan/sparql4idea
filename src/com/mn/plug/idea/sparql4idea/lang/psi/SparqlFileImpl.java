package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.*;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.PsiElementProcessor;
import com.mn.plug.idea.sparql4idea.SparqlFileType;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.psi.toplevel.PrefixDeclaration;
import com.mn.plug.idea.sparql4idea.lang.psi.toplevel.PrefixDeclarations;
import org.jetbrains.annotations.NotNull;

/**
 * File implementation for SPARQL.
 *
 * @author Matt Nathan
 */
public class SparqlFileImpl extends PsiFileBase {

  private static final PrefixDeclaration[] PREFIX_DECLARATIONS = new PrefixDeclaration[0];

  public SparqlFileImpl(@NotNull FileViewProvider fileViewProvider) {
    super(fileViewProvider, SparqlFileType.SPARQL_LANGUAGE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return SparqlFileType.SPARQL_FILE_TYPE;
  }

  public PrefixDeclaration[] getPrefixDeclarations() {
    final PrefixDeclarations prefixes = findChildByClass(PrefixDeclarations.class);
    return prefixes == null ? PREFIX_DECLARATIONS : prefixes.getPrefixDeclarations();
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    for (PrefixDeclaration declaration : getPrefixDeclarations()) {
      if (declaration != lastParent) {
        if (!declaration.processDeclarations(processor, state, lastParent, place)) {
          return false;
        }
      }
    }
    return super.processDeclarations(processor, state, lastParent, place);
  }
}
