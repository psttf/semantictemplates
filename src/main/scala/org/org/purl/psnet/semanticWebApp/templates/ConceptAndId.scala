package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class ConceptAndId(val concept : ALConcept, val id : String) extends Subsumable {
  def isSubsumedBy(c : ALConcept) = concept.isSubsumedBy(c)
}
