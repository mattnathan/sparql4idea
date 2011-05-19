package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
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
    // TriplesSameSubject
    if (Literals.parseVarOrTerm(builder)) {
      if (!PropertyList.parse(builder)) {
        builder.error("Expecting PropertyListNotEmpty");
      }
    } else if (parseTriplesNode(builder)) {
      PropertyList.parse(builder);
    } else {
      return false;
    }

    if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_DOT)) {
      parseTriplesBlock(builder);
    }
    return true;
  }
}
