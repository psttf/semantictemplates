package org.purl.psnet.semanticWebApp.templates.test

import org.purl.psnet.dl.test._

object CorrectTemplates extends IndividualTemplateSystem[String](List(
  IndividualTemplate(
    Author,
    {_ get1 Name}
  )
))