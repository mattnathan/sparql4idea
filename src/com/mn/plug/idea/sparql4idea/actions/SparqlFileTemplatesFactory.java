package com.mn.plug.idea.sparql4idea.actions;

import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import com.mn.plug.idea.sparql4idea.SparqlIcons;

/**
 * Set of templates available to the sparql plugin
 *
 * @author Matt Nathan
 */
public class SparqlFileTemplatesFactory implements FileTemplateGroupDescriptorFactory {

  public static enum Templates {
    SELECT("SPARQL Select");
    private final String file;

    Templates(String file) {
      this.file = file;
    }

    public String getFile() {
      return file;
    }
  }

  @Override
  public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
    final FileTemplateGroupDescriptor result = new FileTemplateGroupDescriptor("SPARQL Files", SparqlIcons.XQUERY_ICON_16x16);
    for (Templates template : Templates.values()) {
      result.addTemplate(template.getFile());
    }
    return result;
  }
}
