package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * GroupGraphPattern block
 *
 * @author Matt Nathan
 */
public class GroupGraphPattern {
  public static void parse(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LCURLY, "Expecting '{'")) {

      parseTriplesBlock(builder); // optional triples block

      ParserUtils.getToken(builder, SparqlTokenTypes.OP_RCURLY, "Expecting '}'");
    }
  }

  private static boolean parseTriplesBlock(PsiBuilder builder) {
    // TriplesSameSubject

    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_DOT)) {
      // TriplesBlock
    }
    return true;
  }
}
