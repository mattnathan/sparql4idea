package com.mn.plug.idea.sparql4idea.lang.parser.parsing.query;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.WhereClause;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Ask parser
 *
 * @author Matt Nathan
 */
public class AskQuery {
  public static boolean parse(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_ASK)) {
      final PsiBuilder.Marker askQuery = builder.mark();
      if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_ASK, "Expecting 'ASK'")) {
        //noinspection StatementWithEmptyBody
        while (DatasetClause.parse(builder));

        if (!WhereClause.parse(builder)) {
          builder.error("Expecting WhereClause");
        }
      }
      askQuery.done(SparqlElementTypes.ASK_QUERY);
      return true;
    }
    return false;
  }
}
