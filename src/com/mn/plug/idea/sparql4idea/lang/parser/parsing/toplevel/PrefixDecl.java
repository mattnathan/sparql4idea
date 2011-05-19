package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.PNameNS;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Prefix decl
 *
 * @author Matt Nathan
 */
public class PrefixDecl {

  public static boolean parse(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_PREFIX)) {
      final PsiBuilder.Marker prefixDecl = builder.mark();

      if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_PREFIX, "Expecing \"PREFIX\"")) {
        if (PNameNS.parse(builder)) {
          if (!Literals.parseIri(builder)) {
            builder.error("Expecting Iri");
          }
        }
      }

      prefixDecl.done(SparqlElementTypes.PREFIX_DECL);

      return true;
    }
    return false;
  }
}
