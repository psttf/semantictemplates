package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class ParameterizedIndividualTemplate[TPar,TOut](concept : ALConcept, body : (PropertySet, TPar) => TOut)
extends ParameterizedTemplate[Individual,TPar,TOut](concept, body) {
//  def test = {
//    try {
//      testException
//      true
//    } catch {
//      case e:TemplateTestingException => false
//    }
//  }
//
//  def testException = {
//    val ind = new MockIndividual(concept)
//    body(ind.asInstanceOf[PropertySet])
//  }
}

object ParameterizedIndividualTemplate{
  def apply[TPar,A](concept : ALConcept, body : (PropertySet, TPar) => A) =
    {new ParameterizedIndividualTemplate(concept, body)}
}
