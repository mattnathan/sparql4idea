package com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph.GraphNode;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph.Graphs;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Set of literal parsers
 *
 * @author Matt Nathan
 */
public class Literals {

  public static boolean parseIriRef(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.LIT_IRI)) {
      return true;
    } else if (parsePrefixedName(builder)) {
      return true;
    }
    return false;
  }

  private static boolean parsePrefixedName(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.LIT_PNAME_LN)) {
      return true;
    } else if (ParserUtils.getToken(builder, SparqlTokenTypes.LIT_PNAME_NS)) {
      return true;
    }
    return false;
  }

  public static boolean parseRdfLiteral(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.LIT_STRING)) {
      if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_HATHAT)) {
        if (!parseIriRef(builder)) {
          builder.error("Expecting IRIref");
        }
      } else {
        ParserUtils.getToken(builder, SparqlTokenTypes.LANGTAG);
      }
      return true;
    }
    return false;
  }

  public static boolean parseNumericLiteral(PsiBuilder builder) {
    return parseNumericLiteralUnsigned(builder) ||
            parseNumericLiteralNeg(builder) ||
            parseNumericLiteralPos(builder);
  }

  public static boolean parseNumericLiteralUnsigned(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_INTEGER) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DECIMAL) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DOUBLE);
  }

  public static boolean parseNumericLiteralPos(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_INTEGER_POS) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DECIMAL_POS) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DOUBLE_POS);
  }

  public static boolean parseNumericLiteralNeg(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_INTEGER_NEG) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DECIMAL_NEG) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DOUBLE_NEG);
  }

  public static boolean parseBooleanLiteral(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_TRUE) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_FALSE);
  }

  public static boolean parseBlankNode(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_BLANK_NODE) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_ANON);
  }

  public static boolean parseNil(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_NIL);
  }

  public static boolean parseVarOrIriRef(PsiBuilder builder) {
    return parseVar(builder) ||
            parseIriRef(builder);
  }

  public static boolean parseVar(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.VAR);
  }

  public static boolean parseVarOrTerm(PsiBuilder builder) {
    if (parseVar(builder)) {
      return true;
    } else if (Graphs.parseGraphTerm(builder)) {
      return true;
    }
    return false;
  }

  public static boolean parseCollection(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LROUND)) {

      if (GraphNode.parse(builder)) {
        //noinspection StatementWithEmptyBody
        while (GraphNode.parse(builder)) ;
      } else {
        builder.error("Expecting Graph Node");
      }

      ParserUtils.getToken(builder, SparqlTokenTypes.OP_RROUND, "Expecting ')'");
      return true;
    }
    return false;
  }
}
