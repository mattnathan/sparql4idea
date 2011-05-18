package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

import static com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes.PREFIX_DECL;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class Prologue {
  public static void parse(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_BASE)) {
      BaseDecl.parse(builder);
    }

    while (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_PREFIX)) {
      PrefixDecl.parse(builder);
    }
  }
}
