package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._
import net.croz.scardf._

class ParameterizedRdfIndividualTemplateSystem[TPar,TOut](
  templates : List[ParameterizedRdfIndividualTemplate[TPar,TOut]]
) extends RdfTemplateSystem[ParameterizedRdfIndividualTemplate[TPar,TOut]](templates) {

//  def test : Boolean = {
//    templates.forall(t => t.test)
//  }
//
//  def testException = {
//    templates.foreach(t => t.testException)
//  }

  def execute(i : Res, p : TPar): Option[TOut] = {
    implicit val m = i.model
    Console.
      println("::::::::::::::: Choosing " +
              "ParameterizedRdfIndividualTemplateSystem template...")
    for (t <- sortedTemplates.find(t => {
        Console.println("found t.concept: " + t.concept.jResource.getURI)
        Console.println("isoftype: " + i.isOfType(t.concept))
        i.isOfType(t.concept)
      }))
    yield t.body(i, p)
  }

}