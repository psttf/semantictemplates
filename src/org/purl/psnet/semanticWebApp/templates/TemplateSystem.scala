package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class TemplateSystem[TIn <: Subsumable,A](val templates : List[Template[TIn,A]]) {
  def execute(i : TIn): Option[A] = {
    for (t <- templates.find(t => i.isSubsumedBy(t.concept)))
    yield t.body(i)
  }
}