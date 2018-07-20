object Program6 {
  def main(args: Array[String]): Unit = {
    randomNumbersMean()
  }
  def  randomNumbersMean(): Unit = {
    val rand = new scala.util.Random
    var randomNumbers = 1 to 100000
    var randomNumbersArray = randomNumbers.toArray
    randomNumbersArray = randomNumbersArray.map(x => rand.nextInt(50000))
    var meanOfArray = calculateMean(randomNumbersArray)
    var sampleArrayIndex = createSample()
    var sampleSeq = 1 to 100
    var sampleArray = sampleSeq.toArray
    var count = -1
    var sampleArrayFinal = new Array[Int](100)
    var sampleArrayTemp = sampleArrayFinal.map(x => if(count < 100){count = count + 1; sampleArrayFinal.update(count,sampleArrayIndex(count))})
    var meanOfArraySample = calculateMean(sampleArrayFinal)
    println("Standard Error = Standard deviation of sample: "+ (meanOfArraySample/Math.sqrt(100)))
    var meanDifference = meanOfArray - meanOfArraySample
    if(meanDifference < 0){meanDifference = meanDifference * -1}
    println("Percentage Error: "+ ((meanDifference/meanOfArray)*100)+" %")
    println(meanOfArray)
  }
  def calculateMean(randomNumbersArray: Array[Int]): BigDecimal ={
    var array = randomNumbersArray
    var randomNumbersArrayBigInt = array.map(x => BigInt(x))
    var sumOfNumbers = randomNumbersArrayBigInt.reduce(_+_)
    var M = BigDecimal(sumOfNumbers)/BigDecimal(array.length)
    M
  }
  def createSample(): Array[Int] ={
    var sampleArrayIndex = sampleNoRepeats(1 to 50000,100).toArray[Int]
    sampleArrayIndex
  }
  def  sampleNoRepeats(ranges : Range , numberOfDigits: Int): Set[Int] = {
    val rand = new scala.util.Random
    var rangeArray = ranges.toArray
    var randomNumbers : Seq[Int] = 1 to numberOfDigits
    var randomNumbersSet = randomNumbers.toSet
    randomNumbersSet = randomNumbersSet.map(x => (rangeArray(0) + rand.nextInt((rangeArray(rangeArray.length-1) - rangeArray(0))+1)))
    if(randomNumbersSet.toArray.length < numberOfDigits){
      randomNumbersSet = sampleNoDuplicates(ranges , numberOfDigits, randomNumbersSet.toArray)
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