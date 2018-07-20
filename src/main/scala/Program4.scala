object Program4 {
  def main(args: Array[String]): Unit = {
    println(collectionAndArrayComparision(Array("To", "Fred", "Harry"),Map("Tom" -> 5, "fred" -> 45, "Harry" -> 6 )).mkString(","))
  }
  def collectionAndArrayComparision(array : Array[String], maps : Map[String,Int]): Array[Int] = {
    var matchingStrings = array.filter(x => (maps.contains(x)))
    var matchingStringValues = matchingStrings.map(x => maps(x))
    return matchingStringValues
  }
}