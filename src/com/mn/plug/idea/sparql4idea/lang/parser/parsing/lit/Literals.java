package com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
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
          builder.error("Expecting IRI Reference");
        }
      } else {
        ParserUtils.getToken(builder, SparqlTokenTypes.LANGTAG);
      }
      return true;
    }
    return false;
  }

  public static boolean parseNumericLiteral(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_INTEGER) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DECIMAL) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.LIT_DOUBLE);
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
}