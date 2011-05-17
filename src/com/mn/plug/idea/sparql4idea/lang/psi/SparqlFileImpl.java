package com.mn.plug.idea.sparql4idea.lang.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.mn.plug.idea.sparql4idea.SparqlFileType;
import org.jetbrains.annotations.NotNull;

/**
 * File implementation for SPARQL.
 *
 * @author Matt Nathan
 */
public class SparqlFileImpl extends PsiFileBase {

  public SparqlFileImpl(@NotNull FileViewProvider fileViewProvider) {
    super(fileViewProvider, SparqlFileType.SPARQL_LANGUAGE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return SparqlFileType.SPARQL_FILE_TYPE;
  }
}
