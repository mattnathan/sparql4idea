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

  IElementType OR_EXPR = new SparqlElementType("OR_EXPR");
  IElementType AND_EXPR = new SparqlElementType("AND_EXPR");
  IElementType RELATIONAL_EXPR = new SparqlElementType("RELATIONAL_EXPR");
  IElementType ADDITIVE_EXPR = new SparqlElementType("ADDITIVE_EXPR");
  IElementType MULTIPLICATIVE_EXPR = new SparqlElementType("MULTIPLICATIVE_EXPR");
  IElementType UNARY_EXPR = new SparqlElementType("UNARY_EXPR");
  IElementType SOLUTION_MODIFIERS = new SparqlElementType("SOLUTION_MODIFIERS");
  IElementType GROUP_GRAPH_PATTERN = new SparqlElementType("GROUP_GRAPH_PATTERN");
  IElementType COLLECTION = new SparqlElementType("COLLECTION");
  IElementType OBJECT_LIST = new SparqlElementType("OBJECT_LIST");
  IElementType TRIPLE_PROPERTY = new SparqlElementType("TRIPLE_PROPERTY");
  IElementType TRIPLES_BLOCK = new SparqlElementType("TRIPLES_BLOCK");
  IElementType OPTIONAL_GRAPH = new SparqlElementType("OPTIONAL_GRAPH");
  IElementType GRAPH_GRAPH = new SparqlElementType("GRAPH_GRAPH");
  IElementType UNION_GRAPH = new SparqlElementType("UNION_GRAPH");
}
