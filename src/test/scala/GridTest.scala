import org.scalatest.FunSuite
import grid.Grid

class GridTest extends FunSuite {
  test("Grid constructor should take in 2 integers") {
  	var grid = new Grid(3,4)
    assert(grid.x == 3 && grid.y == 4)
  }

  test("Grid bounds"){
  	var grid = new Grid(3,5)
  	assert(grid.inGridBounds(-1,3) == false)
  }

  test("Grid check alive neighbor counts"){
  	var grid = new Grid(3,3)
  	grid.grid = Array(
  		Array("*", "*", "-"),
  		Array("*", "-", "-"),
  		Array("-", "-", "-")
	)
	val aliveNeighborCount = grid.getAliveNeighborCount(1, 1)
	assert(aliveNeighborCount == 3)
  }
}
