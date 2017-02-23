package FPInScala

/**
	* Created by hp on 2017/1/10.
	*/
import scala.{Option => _, Either => _, Left => _,Right => _,_}

//sealed trait Option[+A] {
//	def map[B](f: A => B): Option[B] = this match {
//		case Some(a) => Some(f(a))
//		case None => None
//	}
////	def flatMap[B](f: A=> Option[B]): Option[B]
//	def getOrElse[B >: A](default: => B): B = this match {
//		case None => default
//		case Some(a) => a
//	}
//}
//case class Some[+A](get: A) extends Option[A]
//case object None extends Option[Nothing]
//
//
//object Test extends App{
//	def mean(xs: Seq[Double]): Option[Double] = {
//    if(xs.isEmpty) None
//		else Some(xs.sum / xs.length)
//	}
//}
