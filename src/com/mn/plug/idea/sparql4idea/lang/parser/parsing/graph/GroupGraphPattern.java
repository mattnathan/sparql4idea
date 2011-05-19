package com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.Filter;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.Triples;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * GroupGraphPattern block
 *
 * @author Matt Nathan
 */
public class GroupGraphPattern {

  public static boolean parse(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.OP_LCURLY)) {

      final PsiBuilder.Marker groupGraphPattern = builder.mark();

      if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LCURLY, "Expecting '{'")) {

        Triples.parseTriplesBlock(builder); // optional triples block

        while (Graphs.parseGraphPatternNotTriples(builder) || Filter.parse(builder)) {
          ParserUtils.getToken(builder, SparqlTokenTypes.OP_DOT); // '.'?
          Triples.parseTriplesBlock(builder); // TriplesBlock?
        }

        ParserUtils.getToken(builder, SparqlTokenTypes.OP_RCURLY, "Expecting '}'");
      }

      groupGraphPattern.done(SparqlElementTypes.GROUP_GRAPH_PATTERN);

      return true;
    }
    return false;
  }
}
