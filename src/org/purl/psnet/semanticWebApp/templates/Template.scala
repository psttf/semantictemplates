package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl.Concept
import org.purl.psnet.dl.ALConcept
import org.purl.psnet.dl.PropertySet

/**
 * Шаблон
 * @param A тип результата
 */
class Template[TIn,A](val concept : ALConcept, val body : TIn => A)

object Template{
  def apply[TIn,A](concept : ALConcept, body : TIn => A) =
    {new Template(concept, body)}
}
