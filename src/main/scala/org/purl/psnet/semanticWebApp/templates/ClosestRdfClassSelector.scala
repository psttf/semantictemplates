package org.purl.psnet.semanticWebApp.templates

import com.hp.hpl.jena.ontology.OntClass
import com.hp.hpl.jena.ontology.Individual
import com.hp.hpl.jena.vocabulary.OWL

object ClosestRdfClassSelector {

  def depth(c : OntClass, l : List[OntClass]) : Int = {
    Console.println(":::::::::::::: computing depth for " +
      c.getURI)
    val result = if (c hasEquivalentClass OWL.Thing) 0
    else l.filter(c2 => (c != c2) && (c hasSuperClass c2)).
        sort(depth(_,l) > depth(_,l)).firstOption match {
          case Some(result) => {
              Console.println(":::::::::::::::: result is depth(" +
                              result.getURI + ") + 1" )
              depth(result,l) + 1
            }
          case _ => 0
        }
    Console.println(":::::::::::::: result = " + result)
    result
  }

  def apply(l : List[OntClass], i : Individual) : Option[OntClass] =
    l.sort(depth(_,l) > depth(_,l)).find(i hasOntClass _)
  
}
