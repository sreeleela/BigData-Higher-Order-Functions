object Program5 {
  def main(args: Array[String]): Unit = {
    println(sampleNoRepeats(1 to 50000, 50000).mkString(","))
  }
  def  sampleNoRepeats(ranges : Range , numberOfDigits: Int): Set[Int] = {
    val rand = new scala.util.Random
    var rangeArray = ranges.toArray
    var randomNumbers : Seq[Int] = 1 to numberOfDigits
    var randomNumbersSet = randomNumbers.toSet
    if(rangeArray(rangeArray.length-1)-rangeArray(0)+1 < numberOfDigits){
      println("The range is less than the number of random numbers.")
      println("Since this generates random numbers without repetation..try with bigger range.")
      randomNumbers = 0 to 0
      return randomNumbers.toSet
    }
    else {
      randomNumbersSet = randomNumbersSet.map(x => (rangeArray(0) + rand.nextInt((rangeArray(rangeArray.length - 1) - rangeArray(0)) + 1)))
      if (randomNumbersSet.toArray.length < numberOfDigits) {
        randomNumbersSet = sampleNoDuplicates(ranges, numberOfDigits, randomNumbersSet.toArray)
      }
    }
    return randomNumbersSet
 }
  def  sampleNoDuplicates(ranges : Range , numberOfDigits: Int,array: Array[Int]): Set[Int] = {
    val rand = new scala.util.Random
    var rangeArray = ranges.toArray
    var randomNumbers : Seq[Int] = 1 to (numberOfDigits - array.length)
    var randomNumbersSet = randomNumbers.toSet
    randomNumbersSet = randomNumbersSet.map(x => (rangeArray(0) + rand.nextInt((rangeArray(rangeArray.length-1) - rangeArray(0))+1)))
    var array1 = array
    var array2 = randomNumbersSet.toArray
    array1 = array1 ++ array2
    randomNumbersSet = array1.toSet
    var randomNumbersSetToArray = randomNumbersSet.toArray
    if(randomNumbersSetToArray.length < numberOfDigits){
      sampleNoDuplicates(ranges , numberOfDigits, randomNumbersSetToArray)
    }
    else {
      return randomNumbersSetToArray.toSet
    }
  }
}