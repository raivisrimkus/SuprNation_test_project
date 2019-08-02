package io.suprnation

import java.time.LocalDateTime

import com.typesafe.scalalogging.LazyLogging

import scala.io.Source

object Core extends App with LazyLogging {
  logger info s"Core app started at `${LocalDateTime.now}`"

  start
  def start: Unit = {
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





}