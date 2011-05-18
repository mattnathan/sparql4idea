package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class GraphNode {
  public static boolean parse(PsiBuilder builder) {
    return Literals.parseVarOrTerm(builder) ||
            Triples.parseTriplesNode(builder);
  }
}
