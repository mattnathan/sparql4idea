package com.mn.plug.idea.sparql4idea.lang.parser.parsing.common;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.*;
import static com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes.DATASET_CLAUSE;

/**
 * Dataset clasue parser
 *
 * @author Matt Nathan
 */
public class DatasetClause {

  public static boolean parse(PsiBuilder builder) {
    final PsiBuilder.Marker datasetClause = builder.mark();
    if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_FROM, "Expecting \"FROM\"")) {
      ParserUtils.getToken(builder, KW_NAMED); // ("NAMED")?

      if (builder.getTokenType() == LIT_IRI ||
              builder.getTokenType() == LIT_PNAME_LN ||
              builder.getTokenType() == LIT_PNAME_NS) {
        builder.advanceLexer();
      } else {
        builder.error("Expecting IRI_REF, PNAME_LN or PNAME_NS");
      }
    }

    datasetClause.done(DATASET_CLAUSE);
    return true;
  }
}
