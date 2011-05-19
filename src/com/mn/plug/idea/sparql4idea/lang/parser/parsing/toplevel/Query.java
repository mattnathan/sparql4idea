package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.query.AskQuery;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.query.ConstructQuery;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.query.DescribeQuery;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.query.SelectQuery;

/**
 * Top level query. This is the entry point for the parsing
 *
 * @author Matt Nathan
 */
public class Query {
  public static void parse(PsiBuilder builder) {
    Prologue.parse(builder);

    if (!SelectQuery.parse(builder) &&
            !ConstructQuery.parse(builder) &&
            !DescribeQuery.parse(builder) &&
            !AskQuery.parse(builder)) {
      builder.error("Expecting one of SELECT, CONSTRUCT, DESCRIBE or ASK");
    }
  }
}
