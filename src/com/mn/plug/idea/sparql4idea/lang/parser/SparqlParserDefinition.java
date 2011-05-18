package com.mn.plug.idea.sparql4idea.lang.parser;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.mn.plug.idea.sparql4idea.SparqlFileType;
import com.mn.plug.idea.sparql4idea.lang.lexer.SparqlLexer;
import com.mn.plug.idea.sparql4idea.lang.psi.SparqlFileImpl;
import com.mn.plug.idea.sparql4idea.lang.psi.VariablePsiElement;
import com.mn.plug.idea.sparql4idea.lang.psi.toplevel.PrefixPsiElement;
import org.jetbrains.annotations.NotNull;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypeSets.*;

/**
 * Parser definition for SPARQL.
 *
 * @author Matt Nathan
 */
public class SparqlParserDefinition implements ParserDefinition {

  private static final IFileElementType SPARQL_FILE_TYPE = new IFileElementType("SPARQL", SparqlFileType.SPARQL_LANGUAGE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new SparqlLexer();
  }

  @Override
  public PsiParser createParser(Project project) {
    return new SparqlParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return SPARQL_FILE_TYPE;
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return WHITESPACE;
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return STRING_LITERALS;
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode astNode) {
    if (astNode.getElementType() == SparqlElementTypes.PREFIX_DECL) {
      return new PrefixPsiElement(astNode);
    } else if (astNode.getElementType() == SparqlElementTypes.VARIABLE) {
      return new VariablePsiElement(astNode);
    }

    return new ASTWrapperPsiElement(astNode);
  }

  @Override
  public PsiFile createFile(FileViewProvider fileViewProvider) {
    return new SparqlFileImpl(fileViewProvider);
  }

  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
    return SpaceRequirements.MAY;
  }
}
