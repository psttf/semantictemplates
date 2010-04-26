package org.purl.psnet.semanticWebApp.templates.specs

import org.specs._
import org.specs.runner.{ConsoleRunner, JUnit4}

import org.purl.psnet.dl._
import org.purl.psnet.dl.ScalaIndividual._
import org.purl.psnet.dl.test._

import org.purl.psnet.semanticWebApp.templates.test._

import org.purl.psnet.scardf.extensions.Conversions._
import net.croz.scardf.Res
import net.croz.scardf.Res._

import com.hp.hpl.jena.vocabulary.OWL
import com.hp.hpl.jena.ontology.OntModelSpec
import com.hp.hpl.jena.ontology.OntClass
import com.hp.hpl.jena.rdf.model.ModelFactory

class SpecsTest extends JUnit4(Specs)

object Specs extends Specification {
  
  "TemplateSystem.test" should {
    "be true if templates are correct" >> {
      Print.test must beTrue
    }
    "be false if templates are incorrect" >> {}
  }
  
  "TemplateSystem.testExp" should {
    "not throw any exception if templates are correct" >> {
      Print.testException
    }
  }

  "TemplateSystem.execute" should {
    "correctly choose a template with concept expression" >> {
      val result = Print.execute(LeoTolstoy)
	    result.isEmpty must beFalse
      result.get must beEqualTo("great Leo Tolstoy")
    }
  }

  "RdfIndividualTemplateSystem" should {
    "sort templates if one concept is included in many others" >> {
      implicit val m = ModelFactory.createOntologyModel(
        OntModelSpec.OWL_MEM_RDFS_INF
      )
      val Animal = m.createClass(ontNS + "Animal")
      val Mammal = Animal.createSubClass(ontNS + "Mammal")
      val Elephant = Mammal.createSubClass(ontNS + "Elephant")
      val Dolphin = Mammal.createSubClass(ontNS + "Dolphin")

      val print : RdfIndividualTemplateSystem[String] =
        RdfIndividualTemplateSystem(
          Elephant -> {(i:Res) => "it is an Elephant"},
          Animal -> {(i:Res) => "it is an Animal"},
          Mammal -> {(i:Res) => "it is a Mammal"},
          Dolphin -> {(i:Res) => "it is a Dolphin"}
        )

      print.execGet(Elephant.createIndividual) must
        beEqualTo("it is an Elephant")
      print.execGet(Mammal.createIndividual) must beEqualTo("it is a Mammal")
      print.execGet(Dolphin.createIndividual) must beEqualTo("it is a Dolphin")
    }
  }

  "ClosestRdfClassSelector" should {
    "select closest class to an individual" >> {
      implicit val m = ModelFactory.createOntologyModel(
        OntModelSpec.OWL_MEM_RDFS_INF
      )
      val Animal = m.createClass(ontNS + "Animal")
      val Mammal = Animal.createSubClass(ontNS + "Mammal")
      val Elephant = Mammal.createSubClass(ontNS + "Elephant")
      val Dolphin = Mammal.createSubClass(ontNS + "Dolphin")

      val l = List(Animal, Mammal, Elephant, Dolphin)

      ClosestRdfClassSelector(l, Elephant.createIndividual) must
        beSome[OntClass].which(_ == Elephant)
      ClosestRdfClassSelector(l, Mammal.createIndividual) must
        beSome[OntClass].which(_ == Mammal)
      ClosestRdfClassSelector(l, Dolphin.createIndividual) must
        beSome[OntClass].which(_ == Dolphin)
    }
  }
  
  val ontNS = "http://example.org/ontology#"

  "Overall" should {
    "be able to create RdfConceptTemplateSystem from a map" >> {
      implicit val m = ModelFactory.createOntologyModel(
        OntModelSpec.OWL_MEM_RDFS_INF
      )
      val c1 = m.createClass(ontNS + "Class1")
      val c2 = m.createClass(ontNS + "Class2")

      c1.setSubClass(c2)

      val ts = RdfConceptTemplateSystem(Map(
        c1 -> {(r : Res) => r.uri}
      ))
      ts.execGet(c2) must beEqualTo(c2.uri)
    }
    "be able to create RdfConceptTemplateSystem from an immutable map" >> {
      implicit val m = ModelFactory.createOntologyModel(
        OntModelSpec.OWL_MEM_RDFS_INF
      )
      val c1 = m.createClass(ontNS + "Class1")
      val c2 = m.createClass(ontNS + "Class2")

      c1.setSubClass(c2)

      val ts = RdfConceptTemplateSystem(scala.collection.immutable.Map(
        c1 -> {(r : Res) => r.uri}
      ))
      ts.execGet(c2) must beEqualTo(c2.uri)
    }
    "be able to create RdfIndividualTemplateSystem from a map" >> {
      implicit val m = ModelFactory.createOntologyModel(
        OntModelSpec.OWL_MEM_RDFS_INF
      )
      val c1 = m.createClass(ontNS + "Class1")
      val ind = c1.createIndividual(ontNS + "Ind")

      val ts = RdfIndividualTemplateSystem(Map(
        c1 -> {(r : Res) => r.uri}
      ))
      ts.execGet(ind) must beEqualTo(ind.uri)
    }
    "be able to create RdfIndividualTemplateSystem from pairs" >> {
      implicit val m = ModelFactory.createOntologyModel(
        OntModelSpec.OWL_MEM_RDFS_INF
      )
      val c1 = m.createClass(ontNS + "Class1")
      val c2 = m.createClass(ontNS + "Class2")
      val ind = c1.createIndividual(ontNS + "Ind")

      val ts = RdfIndividualTemplateSystem(
        c1 -> {(r : Res) => r.uri},
        c2 -> {(r : Res) => "abc"}
      )
      ts.execGet(ind) must beEqualTo(ind.uri)
    }
  }

  "Individual.all.length" should{
    "be more than 0" >> {
      Individual.all.size must beGreaterThan(0)
    }
  }
  
}
