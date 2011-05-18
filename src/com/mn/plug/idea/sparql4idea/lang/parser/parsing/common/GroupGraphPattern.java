package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
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
    if (parseVarOrTerm(builder)) {
      // PropertyListNotEmpty
    } else if (parseTriplesNode(builder)) {
      // PropertyList
    } else {
      return false;
    }

    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_DOT)) {
      // TriplesBlock
    }
    return true;
  }

  private static boolean parseVarOrTerm(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.VAR)) {
      builder.advanceLexer();
      return true;
    } else if (parseGraphTerm(builder)) {
      return true;
    }
    return false;
  }

  private static boolean parseGraphTerm(PsiBuilder builder) {
    return Literals.parseIriRef(builder) ||
            Literals.parseRdfLiteral(builder) ||
            Literals.parseNumericLiteral(builder) ||
            Literals.parseBooleanLiteral(builder) ||
            Literals.parseBlankNode(builder) ||
            Literals.parseNil(builder);
  }

  private static boolean parseTriplesNode(PsiBuilder builder) {
    return false;
  }
}
