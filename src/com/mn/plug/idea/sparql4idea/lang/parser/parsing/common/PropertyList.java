package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph.GraphNode;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Verb;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * PropertyList parser
 *
 * @author Matt Nathan
 */
public class PropertyList {
  public static boolean parse(PsiBuilder builder) {
    if (parseVerbObjectList(builder)) {
      while(ParserUtils.getToken(builder, SparqlTokenTypes.OP_SEMI)) {
        parseVerbObjectList(builder);
      }
      return true;
    }
    return false;
  }

  private static boolean parseVerbObjectList(PsiBuilder builder) {
    final PsiBuilder.Marker tripleProperty = builder.mark();
    if (Verb.parse(builder)) {
      parseObjectList(builder);
      tripleProperty.done(SparqlElementTypes.TRIPLE_PROPERTY);
      return true;
    }
    tripleProperty.drop();
    return false;
  }

  private static boolean parseObjectList(PsiBuilder builder) {
    if (GraphNode.parse(builder)) {
      while (ParserUtils.getToken(builder, SparqlTokenTypes.OP_COMMA)) {
        if (!GraphNode.parse(builder)) {
          builder.error("Expecting GraphNode");
        }
      }
      return true;
    } else {
      builder.error("Expecting GraphNode");
    }
    return false;
  }

}
