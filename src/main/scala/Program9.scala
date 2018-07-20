object Program9 {
  def main(args: Array[String]): Unit = {
    randomNumbersROfTenThousandSamples()
  }
  def  randomNumbersROfTenThousandSamples(): Unit = {
    val rand = new scala.util.Random
    var randomNumbers = 1 to 100000
    var randomNumbersArray = randomNumbers.toArray
    randomNumbersArray = randomNumbersArray.map(x => rand.nextInt(50000))
    var samplesMeans = new Array[BigDecimal](1000)
    var samplesCount = 0;
    createAllSamples(samplesMeans,samplesCount)
    var sumOfAllMeans = samplesMeans.reduce(_+_)
    var MeanOfAllMeans = sumOfAllMeans/samplesMeans.length
    var r = 1.96*(MeanOfAllMeans/Math.sqrt(samplesMeans.length))
    println("r = "+r)
  }
  def createAllSamples(sampleMeans : Array[BigDecimal],samplesCount : Int): Unit ={
    var sampleArrayIndex = createSample()
    var sampleSeq = 1 to 10000
    var sampleArray = sampleSeq.toArray
    var count = -1
    var sampleArrayFinal = new Array[Int](10000)
    var sampleArrayTemp = sampleArrayFinal.map(x => if(count < 10000){count = count + 1; sampleArrayFinal.update(count,sampleArrayIndex(count))})
    var meanOfArraySample = calculateMean(sampleArrayFinal)
    var samplesCountInc = samplesCount
    sampleMeans.update(samplesCountInc, meanOfArraySample)
    samplesCountInc = samplesCountInc + 1
    if(samplesCountInc < 1000){
      createAllSamples(sampleMeans,samplesCountInc)
    }
  }
  def calculateMean(randomNumbersArray: Array[Int]): BigDecimal ={
    var array = randomNumbersArray
    var randomNumbersArrayBigInt = array.map(x => BigInt(x))
    var sumOfNumbers = randomNumbersArrayBigInt.reduce(_+_)
    var M = BigDecimal(sumOfNumbers)/BigDecimal(array.length)
    M
  }
  def createSample(): Array[Int] ={
    var sampleArrayIndex = sampleNoRepeats(1 to 50000,10000).toArray[Int]
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