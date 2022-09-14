package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c==0 || r==1) 1
    else pascal(c-1,r-1)+pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def aux(chars_aux: List[Char], left: Int): Boolean ={
      if (left<0) false
      else if (chars_aux.isEmpty) left == 0
      else{
        if (chars_aux.head == '(') {
          aux(chars_aux.tail, left+1)
        }
        else if (chars_aux.head == ')'){
          aux(chars_aux.tail, left-1)
        }
        else{
          aux(chars_aux.tail, left)
        }
      }
    }
    aux(chars,0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money<0 || coins.isEmpty) 0
    else if (money==0) 1 
    else countChange(money-coins.head, coins) + countChange(money, coins.tail)
  }
}
