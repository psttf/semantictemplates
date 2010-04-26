package org.purl.psnet.semanticWebApp.templates

import scala.collection._

import org.purl.psnet.dl._
import net.croz.scardf._
import com.hp.hpl.jena.rdf.model.Resource

class RdfConceptTemplateSystem[TOut](templates : List[RdfConceptTemplate[TOut]])
extends RdfTemplateSystem[RdfConceptTemplate[TOut]](templates) {

  def this(ts : Iterable[RdfConceptTemplate[TOut]]) = this(ts.toList)

  def this(m : Map[Res,Res => TOut]) = this(
    m.map((p) => RdfConceptTemplate[TOut](p._1,p._2))
  )

  def apply(i : Res) = execute(i)

  def execGet(i : Res) = execute(i).get

  def execute(i : Res): Option[TOut] = {
    Console.
      println("::::::::::::::: Executing a RdfConceptTemplateSystem...")
    Console.println("::::::::::::::::: for concept " + i.uri)
    implicit val m = i.model
    for (t <- sortedTemplates.find(t => {
          val result =
          (i.jResource.
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

object RdfConceptTemplateSystem {
  
  def apply[R <% Res, TOut](m : Map[R,Res => TOut]) =
    new RdfConceptTemplateSystem[TOut](
      m.map((p) => RdfConceptTemplate[TOut](p._1,p._2))
    )

}