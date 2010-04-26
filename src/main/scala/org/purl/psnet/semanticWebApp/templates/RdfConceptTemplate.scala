package org.purl.psnet.semanticWebApp.templates

import net.croz.scardf._
import org.purl.psnet.dl._

//TODO: concept д. б. концептом, не ресурсом
class RdfConceptTemplate[TOut](concept : Res, val body : Res => TOut)
extends RdfTemplate(concept)

object RdfConceptTemplate{
  def apply[A](conceptUri : String, body : Res => A)(implicit m : Model) =
    {new RdfConceptTemplate(Res(conceptUri), body)}
  def apply[A](concept : Res, body : Res => A) =
    {new RdfConceptTemplate(concept, body)}
}
