package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class Filter {
  public static boolean parse(PsiBuilder builder) {
    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_FILTER)) {
      if (!Constraint.parse(builder)) {
        builder.error("Expecting Constraint");
      }
      return true;
    }
    return false;
  }
}
