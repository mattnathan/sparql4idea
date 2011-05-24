package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;

/**
 * Prologue parser.
 *
 * @author Matt Nathan
 */
public class Prologue {

  public static void parse(PsiBuilder builder) {
    BaseDecl.parse(builder);

    //noinspection StatementWithEmptyBody
    int count = 0;
    final PsiBuilder.Marker prefixes = builder.mark();
    while (PrefixDecl.parse(builder)) count++;
    if (count > 0) {
      prefixes.done(SparqlElementTypes.PREFIX_DECLS);
    } else {
      prefixes.drop();
    }
  }
}
