package com.mn.plug.idea.sparql4idea.highlight;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Brace matcher
 *
 * @author Matt Nathan
 */
public class SparqlBraceMatcher implements PairedBraceMatcher {

  private static final BracePair[] PAIRS = {
          new BracePair(SparqlTokenTypes.OP_LCURLY, SparqlTokenTypes.OP_RCURLY, true),
          new BracePair(SparqlTokenTypes.OP_LROUND, SparqlTokenTypes.OP_RROUND, true),
          new BracePair(SparqlTokenTypes.OP_LSQUARE, SparqlTokenTypes.OP_RSQUARE, false),
  };

  @Override
  public BracePair[] getPairs() {
    return PAIRS;
  }

  @Override
  public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
    return true;
  }

  @Override
  public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
    return openingBraceOffset;
  }
}
