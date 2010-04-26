package org.purl.psnet.semanticWebApp.templates.test

import org.purl.psnet.dl._
import org.purl.psnet.dl.test._
import scala.reflect._

object App {

  def main(args : Array[String]) : Unit = {
    //Console.print(WarAndPeace.isSubsumedBy(Book))
    //<:< работает только в Scala 2.8
//    Console.print(typeOf(new InverseRole(Wrote)))
//    Console.println
//    Console.print(typeOf(new InverseRole(org.purl.psnet.dl.test.Wrote)) <:< typeOf[InverseRole] )
//    Console.println
//    Console.print(typeOf(WrittenBy))
//    Console.println
//    Console.print(typeOf(WrittenBy) <:< typeOf[InverseRole] )
//    Console.println
//    Console.print(typeOf(org.purl.psnet.dl.test.Wrote) <:< typeOf[TypedRole[Individual]] )
//    Console.println
//    Console.print(typeOf(org.purl.psnet.dl.test.Book) <:< typeOf[ALIntersect] )
  }

  def typeOf[T](x :T)(implicit m: Manifest[T]) : Manifest[T] = m
  def typeOf[T](implicit m: Manifest[T]) : Manifest[T] = m

}
