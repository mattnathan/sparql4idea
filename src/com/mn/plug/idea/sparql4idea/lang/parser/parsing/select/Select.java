package com.mn.plug.idea.sparql4idea.lang.parser.parsing.select;

import com.intellij.lang.PsiBuilder;
import com.intellij.util.continuation.Where;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.DatasetClause;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.WhereClause;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.*;
import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.VAR;

/**
 * Select query parser.
 *
 * @author Matt Nathan
 */
public class Select {

  public static void parse(PsiBuilder builder) {
    final PsiBuilder.Marker selectQuery = builder.mark();

    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_SELECT, "Expecting \"SELECT\"")) {

      if (builder.getTokenType() == KW_DISTINCT || builder.getTokenType() == KW_REDUCED) {
        builder.advanceLexer();
      }

      parseProjectionVariables(builder);

      while (ParserUtils.lookAhead(builder, KW_FROM)) {
        DatasetClause.parse(builder);
      }

      WhereClause.parse(builder);

      // todo: SolutionModifier
    }
    selectQuery.done(SparqlElementTypes.SELECT_QUERY);
  }

  private static void parseProjectionVariables(PsiBuilder builder) {
    final PsiBuilder.Marker vars = builder.mark();

    if (ParserUtils.lookAhead(builder, OP_MULT)) {
      builder.advanceLexer();
    } else if (Literals.parseVar(builder)) {
      //noinspection StatementWithEmptyBody
      while (Literals.parseVar(builder));
    } else {
      builder.error("Expecting Variable or *");
    }

    vars.done(SparqlElementTypes.PROJECTION_VARIABLES);
  }
}
