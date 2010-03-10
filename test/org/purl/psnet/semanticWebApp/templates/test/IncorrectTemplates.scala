package org.purl.psnet.semanticWebApp.templates.test

import org.purl.psnet.dl.test._
import org.purl.psnet.dl._

object IncorrectTemplates extends IndividualTemplateSystem[String](List(
  IndividualTemplate(
    Author,
    (x : PropertySet) => (x get PublishedAt).toString
  )
))
