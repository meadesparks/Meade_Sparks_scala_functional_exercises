object Main extends App {
  def isSorted(as: Array[String], ordered: (String, String) => Boolean): Boolean = {
    if (as.length <= 1) // Base case: if (as) is length 0 or 1, it is already sorted. 
      return true
    def check(i: Int): Boolean = { // this function checks if the rest of (as) is sorted.
      if (i == as.length - 1) // compare our check i to length of array - 1. so if we are on first iteration, check(1) if (as) length is 2 we will compare as[0] with as[1].
        return ordered(as(i - 1), as(i)) // recursivley check if as[i-1] and a[i] are ordered.
      else if (!ordered(as(i - 1), as(i))) // if our comparison is not ordered, simply return false. 
        return false
      else
        return check(i + 1) // if our initial comparison was succesful, we will now travel through the remaining array incrementing i
    }
      check(1) // this triggers us to enter the recursive function (only when array is > 1 unit lomg).
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    if (as.length <= 1) // Base case: if (as) is length 0 or 1, it is already sorted. 
      return true
    def check(i: Int): Boolean = { // this is a recursive function that checks if the rest of (as) is sorted
      if (i == as.length - 1) // compare our check i to length of array - 1. so if we are on first iteration, check(1) if (as) length is 2 we will compare as[0] with as[1].
        return ordered(as(i - 1), as(i)) // recursivley check if as[i-1] and a[i] are ordered.
      else if (!ordered(as(i - 1), as(i))) // if our comparison is not ordered, simply return false. 
        return false
      else 
        return check(i + 1) // if our initial comparison was succesful, we will now travel through the remaining array incrementing i
    }
    check(1) // this triggers us to enter the recursive function (only when array is > 1 unit lomg).
  }

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  } // compose function simply composes two functions exactly as traditional mathematics. 

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  } // uncurry transforms a function to a function with one parameter to a function with multiple arguments. It is the oppostie of currying. 

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a => (b => f(a, b))
  } // curry transforms a function that takes multiple arguments into a function with a single argument.
  
}