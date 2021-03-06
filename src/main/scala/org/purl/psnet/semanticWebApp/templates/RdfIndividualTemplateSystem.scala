package org.purl.psnet.semanticWebApp.templates

import scala.collection._

import org.purl.psnet.dl._
import net.croz.scardf._

import com.hp.hpl.jena.ontology.OntClass

class RdfIndividualTemplateSystem[TOut](
  templates : List[RdfIndividualTemplate[TOut]]
) extends RdfTemplateSystem[RdfIndividualTemplate[TOut]](templates) {

  def this(ts : Iterable[RdfIndividualTemplate[TOut]]) = this(ts.toList)

  def this(m : Map[Res,Res => TOut]) = this(
    m.map((p) => RdfIndividualTemplate[TOut](p._1,p._2))
  )

  def this(ts : (Res, Res => TOut)*) =
    this(ts.map{p => RdfIndividualTemplate(p._1, p._2)})

//  def test : Boolean = {
//    templates.forall(t => t.test)
//  }
//
//  def testException = {
//    templates.foreach(t => t.testException)
//  }

  def execute(i : Res): Option[TOut] = {
    implicit val m = i.model
    Console.
      println(":::::::::::::: Choosing RdfIndividualTemplateSystem template...")
    for (t <- sortedTemplates.find(t => {
        Console.println("found t.concept: " + t.concept.jResource.getURI)
        Console.println("isoftype: " + i.isOfType(t.concept))
        i.isOfType(t.concept)
      }))
    yield t.body(i)
  }

  def execGet(i : Res) = execute(i).get

}

object RdfIndividualTemplateSystem {

  def apply[R <% Res, TOut](m : Map[R,Res => TOut]) =
    new RdfIndividualTemplateSystem[TOut](
      m.map((p) => RdfIndividualTemplate[TOut](p._1,p._2))
    )

  def apply[R <% Res, TOut](ts : (R, Res => TOut)*) =
    new RdfIndividualTemplateSystem[TOut](
      ts.map((p) => RdfIndividualTemplate[TOut](p._1,p._2))
    )
}