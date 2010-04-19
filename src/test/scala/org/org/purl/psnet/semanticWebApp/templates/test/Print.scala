package org.purl.psnet.semanticWebApp.templates.test

import org.purl.psnet.semanticWebApp.templates._
import org.purl.psnet.dl._
import org.purl.psnet.dl.test._

object Index extends IndividualTemplateSystem[List[Individual]](List(
))

object Show extends IndividualTemplateSystem[Option[Individual]](List(
))

object Print extends IndividualTemplateSystem[String](List(
  IndividualTemplate(
    ALIntersect(Author,ALAll(org.purl.psnet.dl.test.Wrote,GreatBook)),
    x => {
      "great " + (x get1 Name)
    }
  ),
  IndividualTemplate(
    Author,
    {_ get1 Name}
  )
))

object Create extends IndividualTemplateSystem[Option[Individual]](List(
  IndividualTemplate(
    //DatabaseObject,
    ALUniversal,
    { ps : PropertySet =>
      throw new Exception("the template DatabaseObject.Create is not implemented yet")
      Some(new ListIndividual())
    }
  )
))

object Update extends IndividualTemplateSystem[Option[Individual]](List(
))

object Delete extends IndividualTemplateSystem[Option[Individual]](List(
))

object Save extends IndividualTemplateSystem[Option[Individual]](List(
))
 