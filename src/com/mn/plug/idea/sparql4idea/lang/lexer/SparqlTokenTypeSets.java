package com.mn.plug.idea.sparql4idea.lang.lexer;

import com.intellij.psi.tree.TokenSet;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.*;

/**
 * Sets of token types for easy use.
 *
 * @author Matt Nathan
 */
public interface SparqlTokenTypeSets {

  TokenSet COMMENTS = TokenSet.create();
  TokenSet WHITESPACE = TokenSet.create(WHITE_SPACE);
  TokenSet STRING_LITERALS = TokenSet.create();
  TokenSet KEYWORDS = TokenSet.create(
          KW_BASE,
          KW_PREFIX,
          KW_SELECT,
          KW_CONSTRUCT,
          KW_DESCRIBE,
          KW_ASK,
          KW_ORDER,
          KW_BY,
          KW_LIMIT,
          KW_OFFSET,
          KW_DISTINCT,
          KW_REDUCED,
          KW_FROM,
          KW_NAMED,
          KW_WHERE,
          KW_GRAPH,
          KW_OPTIONAL,
          KW_UNION,
          KW_FILTER,
          KW_A,
          KW_STR,
          KW_LANG,
          KW_LANGMATCHES,
          KW_DATATYPE,
          KW_BOUND,
          KW_SAME_TERM,
          KW_IS_URI,
          KW_IS_IRI,
          KW_IS_LITERAL,
          KW_REGEX
  );
}
