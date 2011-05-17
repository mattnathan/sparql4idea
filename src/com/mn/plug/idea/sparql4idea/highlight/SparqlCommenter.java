package com.mn.plug.idea.sparql4idea.highlight;

import com.intellij.lang.Commenter;

/**
 * Commenter for the sparql query language
 *
 * @author Matt Nathan
 */
public class SparqlCommenter implements Commenter {

  @Override
  public String getLineCommentPrefix() {
    return "#";
  }

  @Override
  public String getBlockCommentPrefix() {
    return null;
  }

  @Override
  public String getBlockCommentSuffix() {
    return null;
  }

  @Override
  public String getCommentedBlockCommentPrefix() {
    return null;
  }

  @Override
  public String getCommentedBlockCommentSuffix() {
    return null;
  }
}
