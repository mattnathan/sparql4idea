package com.mn.plug.idea.sparql4idea.lang.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

import java.io.Reader;

/**
 * General lexer for sparql language
 *
 * @author Matt Nathan
 */
public class SparqlLexer extends FlexAdapter {

  public SparqlLexer() {
    super(new _SparqlLexer((Reader) null));
  }
}
