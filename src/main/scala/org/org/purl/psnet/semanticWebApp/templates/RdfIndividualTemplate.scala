package org.purl.psnet.semanticWebApp.templates

import net.croz.scardf._
import org.purl.psnet.dl._

//TODO: concept д. б. концептом, не ресурсом
class RdfIndividualTemplate[TOut](concept : Res, val body : Res => TOut)
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

object RdfIndividualTemplate{
  def apply[A](concept : Res, body : Res => A) =
    {new RdfIndividualTemplate(concept, body)}
}
