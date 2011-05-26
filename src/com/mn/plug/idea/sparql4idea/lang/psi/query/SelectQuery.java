package com.mn.plug.idea.sparql4idea.lang.psi.query;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.mn.plug.idea.sparql4idea.lang.psi.VariableList;
import com.mn.plug.idea.sparql4idea.lang.psi.expressions.VariableBase;
import org.jetbrains.annotations.NotNull;

/**
 * Select query
 *
 * @author Matt Nathan
 */
public class SelectQuery extends ASTWrapperPsiElement {

  private static final VariableBase[] VARIABLE_PSI_ELEMENTS = new VariableBase[0];

  public SelectQuery(@NotNull ASTNode node) {
    super(node);
  }

  public VariableBase[] getSelectVariables() {
    final VariableList variableList = findChildByClass(VariableList.class);
    if (variableList != null) {
      return variableList.getVariables();
    }
    return VARIABLE_PSI_ELEMENTS;
  }

  public WhereClause getWhereClause() {
    return findChildByClass(WhereClause.class);
  }

  @Override
  public String toString() {
    return "SelectQuery(...)";
  }
}
