package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

// TODO: сделать класс TestableTemplateSystem, который будет более универсальным, чем IndividualTemplateSystem
class IndividualTemplate[TOut](concept : ALConcept, body : PropertySet => TOut)
extends Template[Individual,TOut](concept, body) {
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
    body(ind.asInstanceOf[PropertySet])
  }
}

object IndividualTemplate{
  def apply[A](concept : ALConcept, body : PropertySet => A) = 
    {new IndividualTemplate(concept, body)}
}
