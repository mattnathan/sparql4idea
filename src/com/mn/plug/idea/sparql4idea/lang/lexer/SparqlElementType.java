package com.mn.plug.idea.sparql4idea.lang.lexer;

import com.intellij.psi.tree.IElementType;
import com.mn.plug.idea.sparql4idea.SparqlFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Sparql element type
 *
 * @author Matt Nathan
 */
public class SparqlElementType extends IElementType {

  public SparqlElementType(@NotNull @NonNls String debugName) {
    super(debugName, SparqlFileType.SPARQL_LANGUAGE);
  }
}
