object Program3 {
  def main(args: Array[String]): Unit = {
    print(factorial(5))
  }
  def factorial(num : BigInt): BigInt = {
    var factorialOfNNumbers: BigInt = 0
    var numbers = BigInt(1) to num
    factorialOfNNumbers = numbers.reduceLeft(_ * _)
    factorialOfNNumbers
  }
}