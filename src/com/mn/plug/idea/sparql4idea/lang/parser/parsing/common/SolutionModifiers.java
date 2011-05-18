package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

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
public class SolutionModifiers {

  public static boolean parseOrderClause(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_ORDER)) {
      ParserUtils.getToken(builder, SparqlTokenTypes.KW_BY, "Expecting 'BY'");

      if (!parseOrderCondition(builder)) {
        builder.error("Expecting OrderCondition");
      }
      //noinspection StatementWithEmptyBody
      while(parseOrderCondition(builder));

      return true;
    }
    return false;
  }

  private static boolean parseOrderCondition(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_ASC) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_DESC)) {
      if (!Expressions.parseBracketedExpr(builder)) {
        builder.error("Expecting '('");
      }
      return true;
    } else if (Constraint.parse(builder) || Literals.parseVar(builder)) {
      return true;
    }
    return false;
  }
}
