package com.mn.plug.idea.sparql4idea.lang.parser.parsing.util;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;

/**
 * Set of utils for helping with parsing
 *
 * @author Matt Nathan
 */
public class ParserUtils {

  /**
   * Auxiliary method for construction like
   * <BNF>
   * token?
   * </BNF>
   * parsing
   *
   * @param builder current builder
   * @param elem    given element
   * @return true if element parsed
   */
  public static boolean getToken(PsiBuilder builder, IElementType elem) {
    if (elem.equals(builder.getTokenType())) {
      builder.advanceLexer();
      return true;
    }
    return false;
  }

  /**
   * Auxiliary method for strict token appearance
   *
   * @param builder  current builder
   * @param elem     given element
   * @param errorMsg Message, that displays if element was not found; if errorMsg == null nothing displays
   * @return true if element parsed
   */
  public static boolean getToken(PsiBuilder builder, IElementType elem, String errorMsg) {
    if (elem.equals(builder.getTokenType())) {
      builder.advanceLexer();
      return true;
    } else {
      if (errorMsg != null)
        builder.error(errorMsg);
      return false;
    }
  }

  /**
   * Checks, that following element sequence is like given
   *
   * @param builder Given PsiBuilder
   * @param elem    Need element
   * @return true if following sequence is like a given
   */
  public static boolean lookAhead(PsiBuilder builder, IElementType elem) {
    return elem.equals(builder.getTokenType());
  }

  /**
   * Checks, that following element sequence is like given
   *
   * @param builder Given PsiBuilder
   * @param elems   Array of need elements in order
   * @return true if following sequence is like a given
   */
  public static boolean lookAhead(PsiBuilder builder, IElementType... elems) {
    if (!elems[0].equals(builder.getTokenType())) return false;

    if (elems.length == 1) return true;

    PsiBuilder.Marker rb = builder.mark();
    builder.advanceLexer();
    int i = 1;
    while (!builder.eof() && i < elems.length && elems[i].equals(builder.getTokenType())) {
      i++;
      builder.advanceLexer();
    }
    rb.rollbackTo();
    return i == elems.length;
  }

  /**
   * Wraps current token to node with specified element type.test
   *
   * @param builder Given builder
   * @param elem    Node element
   * @return elem type.test
   */
  public static IElementType eatElement(PsiBuilder builder, IElementType elem) {
    PsiBuilder.Marker marker = builder.mark();
    builder.advanceLexer();
    marker.done(elem);
    return elem;
  }
}
