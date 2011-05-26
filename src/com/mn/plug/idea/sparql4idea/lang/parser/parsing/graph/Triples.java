package com.mn.plug.idea.sparql4idea.lang.parser.parsing.graph;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.PropertyList;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Triples statements
 *
 * @author Matt Nathan
 */
public class Triples {

  public static boolean parseTriplesNode(PsiBuilder builder) {
    if (Literals.parseCollection(builder)) {
      return true;
    } else if (parseBlankNodePropertyList(builder)) {
      return true;
    }
    return false;
  }

  public static boolean parseBlankNodePropertyList(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_LSQUARE)) {
      if (!PropertyList.parse(builder)) {
        builder.error("Expecting PropertyList");
      }
      ParserUtils.getToken(builder, SparqlTokenTypes.OP_RSQUARE, "Expecting ']'");
      return true;
    }
    return false;
  }

  public static boolean parseTriplesBlock(PsiBuilder builder) {
    if (!parseTriplesSameSubject(builder)) {
      return false;
    }

    while (ParserUtils.getToken(builder, SparqlTokenTypes.OP_DOT)) {
      if (!parseTriplesSameSubject(builder)) {
        break;
      }
    }
    return true;
  }

  private static boolean parseTriplesSameSubject(PsiBuilder builder) {
    final PsiBuilder.Marker triplesBlock = builder.mark();
    if (Literals.parseVarOrTerm(builder)) {
      if (!PropertyList.parse(builder)) {
        builder.error("Expecting PropertyListNotEmpty");
      }
      triplesBlock.done(SparqlElementTypes.TRIPLES_BLOCK);
      return true;
    } else if (parseTriplesNode(builder)) {
      PropertyList.parse(builder);
      triplesBlock.done(SparqlElementTypes.TRIPLES_BLOCK);
      return true;
    } else {
      triplesBlock.drop();
      return false;
    }
  }
}
