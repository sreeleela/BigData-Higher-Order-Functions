object Program2 {
  def main(args: Array[String]): Unit = {
    print(pattern_count("Abcde", "abc"))
  }
  def pattern_count(text: String, pattern: String): Int = {
    var sum: Int = 0
    var count = 0
    var givenText = text
    var givenPattern = pattern
    val result = givenText.map(x => if (count < (givenText.length() - givenPattern.length() + 1)) {if(givenText.substring
      (count,count+givenPattern.length()).equals(pattern)) {sum = sum + 1;count = count + 1}
      else{count = count + 1}} else {count = count + 1})
    sum
  }
}