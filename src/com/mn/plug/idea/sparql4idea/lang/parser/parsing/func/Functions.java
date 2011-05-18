package com.mn.plug.idea.sparql4idea.lang.parser.parsing.func;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.expr.Expressions;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class Functions {

  public static boolean parseIriRefOrFunction(PsiBuilder builder) {
    if (Literals.parseIriRef(builder)) {
      parseArgList(builder);
      return true;
    }
    return false;
  }

  public static boolean parseFunction(PsiBuilder builder) {
    if (Literals.parseIriRef(builder)) {
      if (!parseArgList(builder)) {
        builder.error("Expecting ArgList");
      }
      return true;
    }
    return false;
  }

  private static boolean parseArgList(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.LIT_NIL)) {
      return true;
    } else if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LROUND)) {
      Expressions.parseExpression(builder);
      while (ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA)) {
        Expressions.parseExpression(builder);
      }
      ParserUtils.getToken(builder, SparqlTokenTypes.OP_RROUND, "Expecting ')'");
      return true;
    }
    return false;
  }

  public static boolean parseBuiltInCall(PsiBuilder builder) {
    // expr functions
    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_STR) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_LANG) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_DATATYPE) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_IRI) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_URI) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_BLANK) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_LITERAL)) {
      if (!Expressions.parseBracketedExpr(builder)) {
        builder.error("Expecting '('");
      }
      return true;

      // two expr functions
    } else if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_LANGMATCHES) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_SAME_TERM)) {
      if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LROUND, "Expecting '('")) {
        Expressions.parseExpression(builder);
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA, "Expecting ','");
        Expressions.parseExpression(builder);
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_RROUND, "Expecting ')'");
      }
      return true;
    } else if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_BOUND)) {
      if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LROUND, "Expecting '('")) {
        Literals.parseVar(builder);
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_RROUND, "Expecting ')'");
      }
      return true;
    } else if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_REGEX)) {
      if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LROUND, "Expecting '('")) {
        Expressions.parseExpression(builder);
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA, "Expecting ','");
        Expressions.parseExpression(builder);
        if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA)) {
          Expressions.parseExpression(builder);
        }
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_RROUND, "Expecting ')'");
      }
      return true;
    }
    return false;
  }
}
