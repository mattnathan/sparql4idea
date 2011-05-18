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

  IElementType SELECT_QUERY = new SparqlElementType("SELECT_QUERY");
  IElementType PROJECTION_VARIABLES = new SparqlElementType("PROJECTION_VARIABLES");

  IElementType CONSTRUCT_QUERY = new SparqlElementType("CONSTRUCT_QUERY");
  IElementType DESCRIBE_QUERY = new SparqlElementType("DESCRIBE_QUERY");
  IElementType ASK_QUERY = new SparqlElementType("ASK_QUERY");
  
  IElementType DATASET_CLAUSE = new SparqlElementType("DATASET_CLAUSE");
  IElementType WHERE_CLAUSE = new SparqlElementType("WHERE_CLAUSE");
}
