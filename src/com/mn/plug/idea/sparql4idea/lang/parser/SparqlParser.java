package com.mn.plug.idea.sparql4idea.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes;
import com.mn.plug.idea.sparql4idea.lang.parser.parsing.toplevel.Prologue;
import org.jetbrains.annotations.NotNull;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.*;
import static com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes.*;

/**
 * Parser implementation for SPARQL files
 *
 * @author Matt Nathan
 */
public class SparqlParser implements PsiParser {

  @NotNull
  @Override
  public ASTNode parse(IElementType root, PsiBuilder builder) {
    PsiBuilder.Marker mark = builder.mark();

    parseQuery(builder);

    while (!builder.eof()) {
      builder.advanceLexer();
    }
    mark.done(root);

    return builder.getTreeBuilt();
  }

  private void parseQuery(PsiBuilder builder) {
    Prologue.parse(builder);

    if (builder.getTokenType() == KW_SELECT) {
      parseSelectQuery(builder);
    } else if (builder.getTokenType() == KW_CONSTRUCT) {

    } else if (builder.getTokenType() == KW_DESCRIBE) {

    } else if (builder.getTokenType() == KW_ASK) {

    }
  }

  private void parseSelectQuery(PsiBuilder builder) {
    assert builder.getTokenType() == KW_SELECT;

    final PsiBuilder.Marker selectQuery = builder.mark();
    builder.advanceLexer();

    if (builder.getTokenType() == KW_DISTINCT ||
            builder.getTokenType() == KW_REDUCED) {
      builder.advanceLexer();
    }

    if (builder.getTokenType() == OP_MULT) {
      builder.advanceLexer();
    } else if (builder.getTokenType() == VAR) {
      builder.advanceLexer();

      while (builder.getTokenType() == VAR) {
        builder.advanceLexer();
      }
    } else {
      builder.error("Expecting VAR or *");
    }

    while (builder.getTokenType() == KW_FROM) {
      parseDatasetClause(builder);
    }

    parseWhereClause(builder);

    selectQuery.done(SELECT_QUERY);

  }

  private void parseWhereClause(PsiBuilder builder) {
    final PsiBuilder.Marker whereClause = builder.mark();

    if (builder.getTokenType() == KW_WHERE) {
      builder.advanceLexer();
    }

    parseGroupGraphPattern(builder);

    whereClause.done(WHERE_CLAUSE);
  }

  private void parseGroupGraphPattern(PsiBuilder builder) {
    if (builder.getTokenType() == OP_LCURLY) {
      builder.advanceLexer();
    } else {
      builder.error("Expecting '{'");
      return;
    }

    // TriplesBlock?
    parseOptTriplesBlock(builder);

    while (!builder.eof() && builder.getTokenType() != OP_RCURLY) {
      builder.advanceLexer();
    }
    if (!builder.eof()) {
      builder.advanceLexer();
    }
  }

  private void parseOptTriplesBlock(PsiBuilder builder) {
    if (builder.getTokenType() == VAR ||
            builder.getTokenType() == LIT_IRI ||
            builder.getTokenType() == LIT_TRUE ||
            builder.getTokenType() == LIT_FALSE ||
            builder.getTokenType() == LIT_INTEGER ||
            builder.getTokenType() == LIT_DECIMAL ||
            builder.getTokenType() == LIT_DOUBLE ||
            builder.getTokenType() == LIT_BLANK_NODE ||
            builder.getTokenType() == LIT_NIL ||
            builder.getTokenType() == LIT_STRING ||
            builder.getTokenType() == OP_LROUND ||
            builder.getTokenType() == OP_LSQUARE) {
      // should be in TriplesBlock now
    }
  }

  private void parseDatasetClause(PsiBuilder builder) {
    assert builder.getTokenType() == KW_FROM;

    final PsiBuilder.Marker datasetClause = builder.mark();
    builder.advanceLexer();

    if (builder.getTokenType() == KW_NAMED) {
      builder.advanceLexer();
    }

    if (builder.getTokenType() == LIT_IRI ||
            builder.getTokenType() == LIT_PNAME_LN ||
            builder.getTokenType() == LIT_PNAME_NS) {
      builder.advanceLexer();
    } else {
      builder.error("Expecting IRI_REF, PNAME_LN or PNAME_NS");
    }

    datasetClause.done(DATASET_CLAUSE);
  }
}
