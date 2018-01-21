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

  private def getCheckSum : Int = {
    val filename = "C:\\working\\dev\\src\\input2.txt"
    var totalDiff = 0
    for (line <- Source.fromFile(filename).getLines) {
      val sortedArray: Array[Int] = line.split(" ").map(_.toInt).sortWith(_ < _)
      val diff: Int = sortedArray.last - sortedArray.head
      totalDiff += diff
    }
    totalDiff
  }


  println(getCheckSum)
}