import org.scalatest.FunSuite
import board.Board

class BoardTest extends FunSuite {
  test("Board constructor should take in 2 integers") {
  	var board = new Board(3,4)
    assert(board.x == 3 && board.y == 4)
  }
}
