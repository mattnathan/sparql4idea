package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.query.SelectQuery;

/**
 * Top level query. This is the entry point for the parsing
 *
 * @author Matt Nathan
 */
public class Query {
  public static void parse(PsiBuilder builder) {
    Prologue.parse(builder);

    if (!SelectQuery.parse(builder)) {
      // todo: ConstructQuery
      // todo: DescribeQuery
      // todo: AskQuery
      builder.error("Expecting one of SELECT, CONSTRUCT, DESCRIBE or ASK");
    }
  }
}
