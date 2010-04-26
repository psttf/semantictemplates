package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class TestableTemplate[TIn/* <: Mockable*/,TOut](concept : ALConcept, body : TIn => TOut)
extends Template[TIn,TOut](concept, body) {
  def test = {
    try {
      testException
      true
    } catch {
      case e:TemplateTestingException => false
    }
  }
  
  def testException = {
    val ind = new MockIndividual(concept)
    body(ind.asInstanceOf[TIn])
  }
}

object TestableTemplate{
  def apply[A](concept : ALConcept, body : PropertySet => A) = 
    new TestableTemplate(concept, body)
}
