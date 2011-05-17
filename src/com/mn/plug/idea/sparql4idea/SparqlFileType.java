package com.mn.plug.idea.sparql4idea;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.util.Icons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * The file type for sparql query files
 *
 * @author Matt Nathan
 */
public class SparqlFileType extends LanguageFileType {

  public static final SparqlFileType SPARQL_FILE_TYPE = new SparqlFileType();
  public static final Language SPARQL_LANGUAGE = SPARQL_FILE_TYPE.getLanguage();
  private static final String DEFAULT_EXTENSION = "sparql";

  protected SparqlFileType() {
    super(new SparqlLanguage());
  }

  @NotNull
  @Override
  public String getName() {
    return "SPARQL";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "SPARQL file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return DEFAULT_EXTENSION;
  }

  @Override
  public Icon getIcon() {
    return SparqlIcons.XQUERY_ICON_16x16;
  }
}
