package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class ConceptAndIdTemplate[TOut](concept : ALConcept, body : ConceptAndId => TOut)
  extends Template[ConceptAndId,TOut](concept, body)

object ConceptAndIdTemplate{
  def apply[A](concept : ALConcept, body : ConceptAndId => A) = 
    {new ConceptAndIdTemplate(concept, body)}
}
