package com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;

/**
 * Graph node parser
 *
 * @author Matt Nathan
 */
public class GraphNode {
  public static boolean parse(PsiBuilder builder) {
    final PsiBuilder.Marker graphNode = builder.mark();
    final boolean result = Literals.parseVarOrTerm(builder) ||
            Triples.parseTriplesNode(builder);
    if (result) {
      graphNode.done(SparqlElementTypes.GRAPH_NODE);
    } else {
      graphNode.drop();
    }
    return result;
  }
}
