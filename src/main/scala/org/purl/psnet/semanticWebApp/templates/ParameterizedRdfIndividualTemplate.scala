package org.purl.psnet.semanticWebApp.templates

import net.croz.scardf._
import org.purl.psnet.dl._

//TODO: concept д. б. концептом, не ресурсом
class ParameterizedRdfIndividualTemplate[TPar,TOut](concept : Res, val body : (Res, TPar) => TOut)
extends RdfTemplate(concept){
//  def test = {
//    try {
//      testException
//      true
//    } catch {
//      case e:TemplateTestingException => false
//    }
//  }
//
//  def testException = {
//    val ind = new MockIndividual(concept)
//    body(ind.asInstanceOf[PropertySet])
//  }
}

object ParameterizedRdfIndividualTemplate{
  def apply[TPar,A](concept : Res, body : (Res, TPar) => A) =
    {new ParameterizedRdfIndividualTemplate(concept, body)}
}
