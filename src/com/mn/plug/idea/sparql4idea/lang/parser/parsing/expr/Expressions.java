package com.mn.plug.idea.sparql4idea.lang.parser.parsing.expr;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class Expressions {

  public static void parseExpression(PsiBuilder builder) {
    parseConditionalOrExpr(builder);
  }

  public static void parseConditionalOrExpr(PsiBuilder builder) {
    final PsiBuilder.Marker expr = builder.mark();
    parseConditionalAndExpr(builder);
    while (ParserUtils.getToken(builder, SparqlTokenTypes.OP_PIPEPIPE)) {
      parseConditionalAndExpr(builder);
    }
    expr.done(SparqlElementTypes.OR_EXPR);
  }

  private static void parseConditionalAndExpr(PsiBuilder builder) {
    final PsiBuilder.Marker expr = builder.mark();
    parseRelationalExpr(builder);
    while (ParserUtils.getToken(builder, SparqlTokenTypes.OP_ANDAND)) {
      parseRelationalExpr(builder);
    }
    expr.done(SparqlElementTypes.AND_EXPR);
  }

  private static void parseRelationalExpr(PsiBuilder builder) {
    final PsiBuilder.Marker expr = builder.mark();
    parseAddExpr(builder);
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_EQ) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_NE) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_LT) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_GT) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_LE) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_GE)) {
      parseAddExpr(builder);
    }
    expr.done(SparqlElementTypes.RELATIONAL_EXPR);
  }

  private static void parseAddExpr(PsiBuilder builder) {
    final PsiBuilder.Marker expr = builder.mark();
    parseMultExpr(builder);
    while (true) {
      if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_PLUS) ||
              ParserUtils.getToken(builder, SparqlTokenTypes.OP_MINUS)) {
        parseMultExpr(builder);
      } else if (Literals.parseNumericLiteralPos(builder) ||
              Literals.parseNumericLiteralNeg(builder)) {
      } else {
        break;
      }
    }
    expr.done(SparqlElementTypes.ADDITIVE_EXPR);
  }

  private static void parseMultExpr(PsiBuilder builder) {
    final PsiBuilder.Marker expr = builder.mark();
    parseUnaryExpr(builder);
    while (ParserUtils.getToken(builder, SparqlTokenTypes.OP_MULT) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_DIV)) {
      parseUnaryExpr(builder);
    }
    expr.done(SparqlElementTypes.MULTIPLICATIVE_EXPR);
  }

  private static void parseUnaryExpr(PsiBuilder builder) {
    final PsiBuilder.Marker expr = builder.mark();
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_NOT) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_PLUS) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.OP_MINUS)) {
      // do the same as before
    }
    parsePrimaryExpr(builder);
    expr.done(SparqlElementTypes.UNARY_EXPR);
  }

  private static void parsePrimaryExpr(PsiBuilder builder) {
    if (!parseBracketedExpr(builder) &&
            !parseBuiltInCall(builder)) {
      builder.error("Expecting one of BracketedExpression, BuiltInCall, IRIrefOrFunction, RDFLiteral, NumericLiteral, BooleanLiteral or Var");
    }
  }

  private static boolean parseBuiltInCall(PsiBuilder builder) {
    // expr functions
    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_STR) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_LANG) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_DATATYPE) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_IRI) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_URI) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_BLANK) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_IS_LITERAL)) {
      if (!parseBracketedExpr(builder)) {
        builder.error("Expecting '('");
      }
      return true;

      // two expr functions
    } else if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_LANGMATCHES) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_SAME_TERM)) {
      if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LROUND, "Expecting '('")) {
        parseExpression(builder);
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA, "Expecting ','");
        parseExpression(builder);
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
        parseExpression(builder);
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA, "Expecting ','");
        parseExpression(builder);
        if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA)) {
          parseExpression(builder);
        }
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_RROUND, "Expecting ')'");
      }
      return true;
    }
    return false;
  }

  public static boolean parseBracketedExpr(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LROUND)) {
      parseExpression(builder);
      ParserUtils.getToken(builder, SparqlTokenTypes.OP_RROUND, "Expecting ')'");
      return true;
    }
    return false;
  }
}
