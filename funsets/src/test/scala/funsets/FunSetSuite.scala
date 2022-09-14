package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = Set(1,2,3,4)
    val s5 = Set(5,6,7,8)
    val s6 = Set(-5,-6,7,8)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect test") {
    new TestSets{
      val testset1 = intersect(s1, s4)
      val testset2 = intersect(s2, s4)
      val testset3 = intersect(s3, s4)
      assert(contains(testset1, 1), "intersect 4")
      assert(contains(testset2, 2), "intersect 5")
      assert(contains(testset3, 3), "intersect 6")
    }
  }

   test("diff test") {
    new TestSets{
      val testset1 = diff(s4,s1)
      val testset2 = diff(s4,s2)
      val testset3 = diff(s4,s3)
      assert(!contains(testset1, 1), "diff 1")
      assert(!contains(testset2, 2), "diff 2")
      assert(!contains(testset3, 3), "diff 3")
    }
  }

  test("filter test") {
    new TestSets{
      type filtertest = Int => Boolean
      val greaterthan2: filtertest = (x:Int) => x>2
      val testset1 = filter(s1,greaterthan2)
      val testset2 = filter(s2,greaterthan2)
      val testset3 = filter(s3,greaterthan2)
      assert(!contains(testset1, 1), "filter 1")
      assert(!contains(testset2, 2), "filter 2")
      assert(contains(testset3, 3), "filter 3")
    }
  }

  test("forall test") {
    new TestSets{
      type foralltest = Int => Boolean
      val positive: foralltest = (x:Int) => x>0
      val negative: foralltest = (x:Int) => x<0
      assert(forall(s1,positive), "forall 1")
      assert(!forall(s1,negative), "forall 2")
      assert(forall(s4,positive), "forall 3")
      assert(!forall(s6,positive), "forall 4")
    }
  }

  test("exist test") {
    new TestSets{
      type existtest = Int => Boolean
      val positive: existtest = (x:Int) => x>0
      val negative: existtest = (x:Int) => x<0
      assert(exists(s1,positive), "exist 1")
      assert(!exists(s1,negative), "exist 2")
      assert(exists(s4,positive), "exist 3")
      assert(exists(s6,positive), "exist 4")
    }
  }

  test("map test") {
    new TestSets{
      val s = map(s4,x=>x+10)
      assert(contains(s,14), "map 1")
      assert(!contains(s,4), "map 2")
    }
  }
}
