package com.mn.plug.idea.sparql4idea.lang.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

/**
 * Set of lexer token types
 *
 * @author Matt Nathan
 */
public interface SparqlTokenTypes {

  IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;
  IElementType WHITE_SPACE = TokenType.WHITE_SPACE;

  // keywords
  IElementType KW_BASE = new SparqlElementType("KW_BASE");
  IElementType KW_PREFIX = new SparqlElementType("KW_PREFIX");
  IElementType KW_SELECT = new SparqlElementType("KW_SELECT");
  IElementType KW_CONSTRUCT = new SparqlElementType("KW_CONSTRUCT");
  IElementType KW_DESCRIBE = new SparqlElementType("KW_DESCRIBE");
  IElementType KW_ASK = new SparqlElementType("KW_ASK");
  IElementType KW_ORDER = new SparqlElementType("KW_ORDER");
  IElementType KW_BY = new SparqlElementType("KW_BY");
  IElementType KW_LIMIT = new SparqlElementType("KW_LIMIT");
  IElementType KW_OFFSET = new SparqlElementType("KW_OFFSET");
  IElementType KW_DISTINCT = new SparqlElementType("KW_DISTINCT");
  IElementType KW_REDUCED = new SparqlElementType("KW_REDUCED");
  IElementType KW_FROM = new SparqlElementType("KW_FROM");
  IElementType KW_NAMED = new SparqlElementType("KW_NAMED");
  IElementType KW_WHERE = new SparqlElementType("KW_WHERE");
  IElementType KW_GRAPH = new SparqlElementType("KW_GRAPH");
  IElementType KW_OPTIONAL = new SparqlElementType("KW_OPTIONAL");
  IElementType KW_UNION = new SparqlElementType("KW_UNION");
  IElementType KW_FILTER = new SparqlElementType("KW_FILTER");
  IElementType KW_A = new SparqlElementType("KW_A");
  IElementType KW_STR = new SparqlElementType("KW_STR");
  IElementType KW_LANG = new SparqlElementType("KW_LANG");
  IElementType KW_LANGMATCHES = new SparqlElementType("KW_LANGMATCHES");
  IElementType KW_DATATYPE = new SparqlElementType("KW_DATATYPE");
  IElementType KW_BOUND = new SparqlElementType("KW_BOUND");
  IElementType KW_SAME_TERM = new SparqlElementType("KW_SAME_TERM");
  IElementType KW_IS_URI = new SparqlElementType("KW_IS_URI");
  IElementType KW_IS_IRI = new SparqlElementType("KW_IS_IRI");
  IElementType KW_IS_LITERAL = new SparqlElementType("KW_IS_LITERAL");
  IElementType KW_REGEX = new SparqlElementType("KW_REGEX");

  IElementType LIT_TRUE = new SparqlElementType("true");
  IElementType LIT_FALSE = new SparqlElementType("false");
  IElementType LIT_INTEGER = new SparqlElementType("INTEGER");
  IElementType LIT_DECIMAL = new SparqlElementType("DECIMAL");
  IElementType LIT_DOUBLE = new SparqlElementType("DOUBLE");
}
