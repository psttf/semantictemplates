package org.purl.psnet.semanticWebApp.templates

import net.croz.scardf._
import org.purl.psnet.dl._

class ConceptAndIdRdfTemplate[TOut](concept : Res, val body : RdfConceptAndId => TOut)
extends RdfTemplate(concept)

object ConceptAndIdRdfTemplate{
  def apply[A](concept : Res, body : RdfConceptAndId => A) =
    {new ConceptAndIdRdfTemplate(concept, body)}
}
