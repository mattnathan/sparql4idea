package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;

/**
 * Prologue parser.
 *
 * @author Matt Nathan
 */
public class Prologue {

  public static void parse(PsiBuilder builder) {
    BaseDecl.parse(builder);

    //noinspection StatementWithEmptyBody
    while (PrefixDecl.parse(builder)) ;
  }
}
