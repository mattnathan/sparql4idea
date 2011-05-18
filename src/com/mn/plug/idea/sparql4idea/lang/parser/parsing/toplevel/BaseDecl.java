package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.IriRef;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * BASE decl parser
 *
 * @author Matt Nathan
 */
public class BaseDecl {
  public static boolean parse(PsiBuilder builder) {
    final PsiBuilder.Marker baseDecl = builder.mark();

    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_BASE, "Expecing \"BASE\"")) {
      IriRef.parse(builder);
    }

    baseDecl.done(SparqlElementTypes.BASE_DECL);

    return true;
  }
}
