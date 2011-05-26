package com.mn.plug.idea.sparql4idea.codeInspections;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.mn.plug.idea.sparql4idea.lang.parser.SparqlElementTypes;
import com.mn.plug.idea.sparql4idea.lang.psi.expressions.VariableBase;
import org.jetbrains.annotations.NotNull;

/**
 * Generated JavaDoc Comment.
 *
 * @author Matt Nathan
 */
public class UnknownSelectVariableInspection implements Annotator {

  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    if (element instanceof VariableBase) {
      final PsiElement parent = element.getParent();
      if (parent.getNode().getElementType() == SparqlElementTypes.PROJECTION_VARIABLES) {
        // we are at a variable in a projection list
        // check to make sure this variable exists in the where clause
        holder.createErrorAnnotation(element, "This is a variable");
      }
    }
  }
}
