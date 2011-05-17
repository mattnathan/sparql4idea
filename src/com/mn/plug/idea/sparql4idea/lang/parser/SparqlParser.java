package com.mn.plug.idea.sparql4idea.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Parser implementation for SPARQL files
 *
 * @author Matt Nathan
 */
public class SparqlParser implements PsiParser {

  @NotNull
  @Override
  public ASTNode parse(IElementType root, PsiBuilder builder) {
    PsiBuilder.Marker mark = builder.mark();
    while (!builder.eof()) {
      builder.advanceLexer();
    }
    mark.done(root);

    return builder.getTreeBuilt();
  }
}