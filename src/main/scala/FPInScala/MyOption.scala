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

object MyOption extends App{
	def variance(xs: Seq[Double]): Option[Double] = {
		if(xs.isEmpty) None
		else mean(xs).flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))
	}

	def mean(xs: Seq[Double]): Option[Double] = {
    if(xs.isEmpty) None
		else Some(xs.sum / xs.length)
	}

	def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
	  a.flatMap(aa => b.map(bb => f(aa, bb)))
	}

	def sequence[A](a: List[Option[A]]): Option[List[A]] = {
		a match {
			case Nil => Some(Nil)
			case h :: t => h.flatMap(hh => sequence(t).map(hh :: _))
		}
	}
}
