package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Verb parser
 *
 * @author Matt Nathan
 */
public class Verb {
  public static boolean parse(PsiBuilder builder) {
    return Literals.parseVarOrIriRef(builder) ||
            ParserUtils.getToken(builder, SparqlTokenTypes.KW_A);
  }
}
