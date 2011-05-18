package com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
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
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LCURLY)) {

      Triples.parseTriplesBlock(builder); // optional triples block

      while (Graphs.parseGraphPatternNotTriples(builder) || Filter.parse(builder)) {
        ParserUtils.getToken(builder, SparqlTokenTypes.OP_DOT); // '.'?
        Triples.parseTriplesBlock(builder); // TriplesBlock?
      }

      ParserUtils.getToken(builder, SparqlTokenTypes.OP_RCURLY, "Expecting '}'");
      return true;
    }
    return false;
  }
}
