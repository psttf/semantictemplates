package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._

class IndividualTemplateSystem[TOut](templates : List[IndividualTemplate[TOut]])
extends TemplateSystem[Individual,TOut](templates) {
    
  def test : Boolean = {
    templates.forall(t => t.test)
  }
  
  def testException = {
    templates.foreach(t => t.testException)
  }

}