package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Where clause parser
 *
 * @author Matt Nathan
 */
public class WhereClause {
  public static boolean parse(PsiBuilder builder) {
    final PsiBuilder.Marker whereClause = builder.mark();
    // (WHERE)?
    ParserUtils.getToken(builder, SparqlTokenTypes.KW_WHERE);
    GroupGraphPattern.parse(builder);

    whereClause.done(SparqlElementTypes.WHERE_CLAUSE);
    return true;
  }
}
