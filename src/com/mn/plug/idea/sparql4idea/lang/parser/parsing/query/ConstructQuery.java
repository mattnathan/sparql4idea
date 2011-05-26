package com.mn.plug.idea.sparql4idea.lang.parser.parsing.query;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.SolutionModifiers;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph.Triples;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Construct query parsing
 *
 * @author Matt Nathan
 */
public class ConstructQuery {

  public static boolean parse(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_CONSTRUCT)) {
      final PsiBuilder.Marker constructQuery = builder.mark();
      if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_CONSTRUCT, "Expecting 'CONSTRUCT'")) {
        if (parseConstructTemplate(builder)) {
          //noinspection StatementWithEmptyBody
          while (DatasetClause.parse(builder)) ;
          if (!WhereClause.parse(builder)) {
            builder.error("Expecting WhereClause");
          } else {
            SolutionModifiers.parse(builder);
          }
        }
      }
      constructQuery.done(SparqlElementTypes.CONSTRUCT_QUERY);
      return true;
    }
    return false;
  }

  private static boolean parseConstructTemplate(PsiBuilder builder) {
    final PsiBuilder.Marker constructTemplate = builder.mark();
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LCURLY, "Expecting '{'")) {

      Triples.parseTriplesBlock(builder);

      ParserUtils.getToken(builder, SparqlTokenTypes.OP_RCURLY, "Expecting '}'");
      constructTemplate.done(SparqlElementTypes.CONSTRUCT_TEMPLATE);
      return true;
    }
    return false;
  }
}
