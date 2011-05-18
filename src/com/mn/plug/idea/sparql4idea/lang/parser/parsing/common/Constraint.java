package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.expr.Expressions;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.func.Functions;

/**
 * Constraint parser
 *
 * @author Matt Nathan
 */
public class Constraint {
  public static boolean parse(PsiBuilder builder) {
    return Expressions.parseBracketedExpr(builder) ||
            Functions.parseBuiltInCall(builder) ||
            Functions.parseFunction(builder);
  }
}
