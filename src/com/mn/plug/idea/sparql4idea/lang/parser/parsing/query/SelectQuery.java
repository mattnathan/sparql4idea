package com.mn.plug.idea.sparql4idea.lang.parser.parsing.query;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.DatasetClause;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.SolutionModifiers;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.WhereClause;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.*;

/**
 * Select query parser.
 *
 * @author Matt Nathan
 */
public class SelectQuery {

  public static boolean parse(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_SELECT)) {
      final PsiBuilder.Marker selectQuery = builder.mark();

      if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_SELECT, "Expecting \"SELECT\"")) {

        if (!ParserUtils.getToken(builder, KW_DISTINCT)) {
          ParserUtils.getToken(builder, KW_REDUCED);
        }

        parseProjectionVariables(builder);

        while (ParserUtils.lookAhead(builder, KW_FROM)) {
          DatasetClause.parse(builder);
        }

        WhereClause.parse(builder);

        SolutionModifiers.parse(builder);
      }
      selectQuery.done(SparqlElementTypes.SELECT_QUERY);
      return true;
    }
    return false;
  }

  private static void parseProjectionVariables(PsiBuilder builder) {
    final PsiBuilder.Marker vars = builder.mark();

    if (ParserUtils.getToken(builder, OP_MULT)) {
      // we have parsed all needed tokens
    } else if (Literals.parseVar(builder)) {
      //noinspection StatementWithEmptyBody
      while (Literals.parseVar(builder)) ;
    } else {
      builder.error("Expecting Variable or *");
    }

    vars.done(SparqlElementTypes.PROJECTION_VARIABLES);
  }
}
