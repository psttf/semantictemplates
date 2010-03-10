package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class MockIndividual(val concept : ALConcept) extends PropertySet {

  def get[T](r : TypedRole[T]) : Set[T] = {
    if (concept.isSubsumedBy(ALIntersect(ALUniversal, ALExistsAny(r)))) {
      Mocker.mockValue[T](r)
    }
    else {
      throw new TemplateTestingException("concept " + concept.name + " doens't have role " + r.toString)
    }
  }
  
}
