package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

/**
 * Шаблон
 * @param A тип результата
 */
class ParameterizedTemplate[TIn,TPar,A](val concept : ALConcept, val body : (TIn,TPar) => A)

object ParameterizedTemplate{
  def apply[TIn,TPar,A](concept : ALConcept, body : (TIn,TPar) => A) =
    new ParameterizedTemplate(concept, body)
}
