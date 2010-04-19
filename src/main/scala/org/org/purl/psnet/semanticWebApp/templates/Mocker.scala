package org.purl.psnet.semanticWebApp.templates

import org.purl.psnet.dl._
import scalax.reflect._
import scala.reflect.Manifest

object Mocker {
  def mockValue[T](r: TypedRole[T]) : Set[T] = r match {
    case r: StringRole => stringMock[T]
  }
  
  def stringMock[T] = Set("xxxx").asInstanceOf[Set[T]]
}
