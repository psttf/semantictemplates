package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class ParameterizedTemplateSystem[TIn <: Subsumable,TPar,A](
  val templates : List[ParameterizedTemplate[TIn,TPar,A]]
) {
  def execute(i : TIn, p : TPar): Option[A] = {
    for (t <- templates.find(t => i.isSubsumedBy(t.concept)))
    yield t.body(i, p)
  }
}