package com.mn.plug.idea.sparql4idea.lang.parser;

import com.intellij.psi.tree.IElementType;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlElementType;

/**
 * Parser element types.
 *
 * @author Matt Nathan
 */
public interface SparqlElementTypes {
  IElementType BASE_DECL = new SparqlElementType("BASE_DECL");
  IElementType PREFIX_DECL = new SparqlElementType("PREFIX_DECL");
}
