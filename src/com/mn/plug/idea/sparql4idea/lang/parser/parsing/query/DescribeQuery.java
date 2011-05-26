package com.mn.plug.idea.sparql4idea.lang.parser.parsing.query;

import com.intellij.lang.PsiBuilder;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.common.SolutionModifiers;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.lit.Literals;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.util.ParserUtils;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class DescribeQuery {

  public static boolean parse(PsiBuilder builder) {
    if (ParserUtils.lookAhead(builder, SparqlTokenTypes.KW_DESCRIBE)) {
      final PsiBuilder.Marker describeQuery = builder.mark();
      if (ParserUtils.getToken(builder, SparqlTokenTypes.KW_DESCRIBE, "Expecting 'DESCRIBE'")) {
        boolean valid;
        if (ParserUtils.getToken(builder, SparqlTokenTypes.OP_MULT)) {
          // expected
          valid = true;
        } else if (Literals.parseVarOrIriRef(builder)) {
          //noinspection StatementWithEmptyBody
          while (Literals.parseVarOrIriRef(builder)) ;
          valid = true;
        } else {
          builder.error("Expecting '*' or VarOrIRIref");
          valid = false;
        }

        if (valid) {
          //noinspection StatementWithEmptyBody
          while (DatasetClause.parse(builder)) ;

          WhereClause.parse(builder);

          SolutionModifiers.parse(builder);
        }
      }

      describeQuery.done(SparqlElementTypes.DESCRIBE_QUERY);
      return true;
    }
    return false;
  }
}
