package com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Name namespace parser
 *
 * @author Matt Nathan
 */
public class PNameNS {
  public static boolean parse(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_PNAME_NS, "Expecting prefix namespace (e.g. \"myName:\")");
  }
}
