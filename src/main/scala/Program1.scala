object Program1 {
  def main(args: Array[String]): Unit = {
    print(sum_multiples_3_5(15))
  }
  def sum_multiples_3_5(n: Int): Int = {
    var sum: Int = 0
    val listOfIntegers = List.range(1,n)
    val arrayOfIntegers = listOfIntegers.toArray
    val result = arrayOfIntegers.map(x => if ((x % 3 == 0 || x % 5 == 0) &&(!(x % 3 == 0 && x % 5 == 0))) x else 0)
    var multiplesArray = result.filter(_ != 0)
    sum = multiplesArray.sum
    sum
  }
}