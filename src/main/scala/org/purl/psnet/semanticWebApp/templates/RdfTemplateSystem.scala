package org.purl.psnet.semanticWebApp.templates

import com.hp.hpl.jena.ontology.OntClass
import com.hp.hpl.jena.vocabulary.OWL

import net.croz.scardf._

//TODO: concept Рґ. Р±. РєРѕРЅС†РµРїС‚РѕРј, РЅРµ СЂРµСЃСѓСЂСЃРѕРј
class RdfTemplate(val concept : Res)

class RdfTemplateSystem[TemplateType <: RdfTemplate](
  val templates : List[TemplateType]
) {
  def this(ts : Iterable[TemplateType]) = this(ts.toList)

  val depthMap : scala.collection.mutable.Map[TemplateType,Int] =
    scala.collection.mutable.Map[TemplateType,Int]()

  def depth(t : TemplateType) : Int =
    depthMap.getOrElseUpdate(t,
    {
      Console.println(":::::::::::::: computing depth for " +
        t.concept.uri)
      val result = if (
          t.concept.jResource.as(classOf[OntClass]).asInstanceOf[OntClass].
            hasEquivalentClass(OWL.Thing)
        ) 0
      else templates.filter(tt =>
          (t.concept != tt.concept) &&
            (t.concept.jResource.as(classOf[com.hp.hpl.jena.ontology.OntClass]).
            asInstanceOf[com.hp.hpl.jena.ontology.OntClass] hasSuperClass
            tt.concept.jResource)
        ).sort(depth(_:TemplateType)>depth(_:TemplateType)).firstOption match {
            case Some(tu) => {
                Console.println(":::::::::::::::: result is depth(" +
                                tu.concept.uri + ") + 1" )
                depth(tu) + 1
              }
            case _ => 0
          }
      Console.println(":::::::::::::: result = " + result)
      result
    }
  )

  def sortedTemplates : List[TemplateType] = {
    Console.println(":::::::::::: sorting templates... ")
    templates.sort(depth(_) >= depth(_))
  }

}
