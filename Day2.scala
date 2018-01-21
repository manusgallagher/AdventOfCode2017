//--- Day 2: Corruption Checksum ---
//As you walk through the door, a glowing humanoid shape yells in your direction. "You there! Your state appears to be idle. Come help us repair the corruption in this spreadsheet - if we take another millisecond, we'll have to display an hourglass cursor!"
//
//The spreadsheet consists of rows of apparently-random numbers. To make sure the recovery process is on the right track, they need you to calculate the spreadsheet's checksum. For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences.
//
//For example, given the following spreadsheet:
//
//5 1 9 5
//7 5 3
//2 4 6 8
//The first row's largest and smallest values are 9 and 1, and their difference is 8.
//The second row's largest and smallest values are 7 and 3, and their difference is 4.
//The third row's difference is 6.
//In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.

import scala.io.Source

object Day2 extends App {

  private def getEvenDivide(line: Array[Int]) = {

      val solutions =
        for (a <- line; b <- line; if a > b && a % b == 0)
          yield a / b

    solutions.head

  }

  private def getCheckSum(line: Array[Int]): Int = {

    val sortedArray: Array[Int] = line.sortWith(_ < _)
    sortedArray.last - sortedArray.head

  }

  private def answer(f: Array[Int] => Int): Int = {
    var total = 0
    val filename = "C:\\working\\dev\\src\\input2.txt"
    for (line <- Source.fromFile(filename).getLines) {
      total += f(line.split("\t").map(_.toInt))
    }

    total
  }

  println(answer(getCheckSum))
  println(answer(getEvenDivide))
}
