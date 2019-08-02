package io.suprnation

import java.time.LocalDateTime

import com.typesafe.scalalogging.LazyLogging

import scala.collection.mutable
import scala.io.Source

object Core extends App with LazyLogging {
  logger info s"Core app started at `${LocalDateTime.now}`"

  start

  def versionThatWasNotCorrect: Unit = {
    val fileContents = Source.fromFile("triangle.txt").getLines().toList

    println("### Lets print `triangle.txt` ###")
    fileContents.foreach(println)

    val linesToList = fileContents.filterNot(_.isEmpty).map { line =>
      line.split(" ").toList.map((s: String) => s.toInt).sorted
    }

    val minimumValue = linesToList.map(_.head)
    val maximumValue = linesToList.map(_.last)

    println(s"Minimal path is: ${minimumValue.mkString(" + ")} = ${minimumValue.sum}")
    println(s"Maximal path is: ${maximumValue.mkString(" + ")} = ${maximumValue.sum}")

  }

  def start = {
    val fileContents = Source.fromFile("triangle.txt").getLines().toList
    println("### Lets print `triangle.txt` ###")
    fileContents.foreach(println)
    println("######")
    // this time will not sort them to not break logic.
    val linesToList = fileContents.filterNot(_.isEmpty).map { line =>
      line.split(" ").toList.map((s: String) => s.toInt)
    }
    sum(linesToList)
  }

  def sum(triangleValues: List[List[Int]]) = {
    var tempMap = mutable.Map[Int, Int]()
    var pathMap = mutable.Map[Int, Int]()
    val minimumSum = triangleValues.reduceRight(
      (up, low) =>
        up zip {
          // case if its first iteration (it should be empty)
          if(tempMap.nonEmpty) {
            pathMap += tempMap.toSeq.sorted.head
            tempMap.clear
          }
          low zip low.tail
        } map {
          case (above, (left, right)) =>
            val min = Math.min(left, right)
            // add temp path to temp path map
            tempMap += (above+min) ->  min
            above + Math.min(left, right)
        }
    )
    pathMap += tempMap.toSeq.sorted.head
    tempMap.clear
    // map to Seq  + sort
    val sorted = pathMap.toSeq.sorted.reverse
    // {Int, Int to Int + add missing element}
    val dd = sorted.toList.map(x => x._1 - x._2) :+ sorted.last._2

    println(s"Minimal path is: ${dd.mkString(" + ")} = ${minimumSum.sum}")
  }

}

