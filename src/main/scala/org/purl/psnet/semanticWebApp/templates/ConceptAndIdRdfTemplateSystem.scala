package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._
import net.croz.scardf._

class ConceptAndIdRdfTemplateSystem[TOut](templates : List[ConceptAndIdRdfTemplate[TOut]])
extends RdfTemplateSystem[ConceptAndIdRdfTemplate[TOut]](templates) {

  def apply(i : RdfConceptAndId) = execute(i)

  def execute(i : RdfConceptAndId): Option[TOut] = {
    Console.
      println("::::::::::::::: Executing a ConceptAndIdRdfTemplateSystem...")
    Console.println("::::::::::::::::: for concept " + i.concept.uri)
    Console.println("::::::::::::::::: and id " + i.id)
    implicit val m = i.concept.model
    for (t <- sortedTemplates.find(t => {
          val result =
          (i.concept.jResource.
           as(classOf[com.hp.hpl.jena.ontology.OntClass]).
           asInstanceOf[com.hp.hpl.jena.ontology.OntClass] hasSuperClass
           t.concept.jResource)
          Console.println("::::::::::::::::: template concept " + t.concept.uri)
          Console.println("::::::::::::::::: result " + result)
          result
        }))
    yield t.body(i)
  }

}