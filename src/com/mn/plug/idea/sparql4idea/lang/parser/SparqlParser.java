package com.mn.plug.idea.sparql4idea.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import org.jetbrains.annotations.NotNull;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.LIT_IRI;
import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.LIT_PNAME_NS;
import static com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes.BASE_DECL;
import static com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes.PREFIX_DECL;

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

    parseQuery(builder);

    while (!builder.eof()) {
      builder.advanceLexer();
    }
    mark.done(root);

    return builder.getTreeBuilt();
  }

  private void parseQuery(PsiBuilder builder) {
    parsePrologue(builder);
  }

  private void parsePrologue(PsiBuilder builder) {
    if (builder.getTokenType() == SparqlTokenTypes.KW_BASE) {
      final PsiBuilder.Marker baseDecl = builder.mark();
      builder.advanceLexer();
      parseIriRef(builder);
      baseDecl.done(BASE_DECL);
    }

    while (builder.getTokenType() == SparqlTokenTypes.KW_PREFIX) {
      final PsiBuilder.Marker prefixDecl = builder.mark();
      builder.advanceLexer();
      parsePnameNs(builder);
      parseIriRef(builder);
      prefixDecl.done(PREFIX_DECL);
    }
  }

  private void parseIriRef(PsiBuilder builder) {
    if (builder.getTokenType() == LIT_IRI) {
      builder.advanceLexer();
    } else {
      builder.error("Expecting IRI_REF");
    }
  }

  private void parsePnameNs(PsiBuilder builder) {
    if (builder.getTokenType() == LIT_PNAME_NS) {
      builder.advanceLexer();
    } else {
      builder.error("Expecting PNAME_NS");
    }
  }
}
