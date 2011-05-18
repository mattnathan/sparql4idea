package com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * IRI ref parser
 *
 * @author Matt Nathan
 */
public class IriRef {
  public static boolean parse(PsiBuilder builder) {
    return ParserUtils.getToken(builder, SparqlTokenTypes.LIT_IRI, "Expecting IRI");
  }
}
