package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class ConceptTemplate[TOut](concept : ALConcept, body : ALConcept => TOut)
  extends Template[ALConcept,TOut](concept, body)

object ConceptTemplate{
  def apply[A](concept : ALConcept, body : ALConcept => A) = 
    {new ConceptTemplate(concept, body)}
}
