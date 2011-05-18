package com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.select.Select;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Top level query. This is the entry point for the parsing
 *
 * @author Matt Nathan
 */
public class Query {
  public static void parse(PsiBuilder builder) {
    Prologue.parse(builder);

    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_SELECT)) {
      Select.parse(builder);
    } else {
      builder.error("Expecting one of SELECT, CONSTRUCT, DESCRIBE or ASK");
    }
  }
}
