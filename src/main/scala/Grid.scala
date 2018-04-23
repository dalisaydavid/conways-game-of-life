package grid
import scala.util.Random

class Grid(var x: Int, var y: Int) {
    println(s"Creating grid with dimensions ($x, $y).")
    
    var grid = Array.ofDim[String](x, y)
    var directions = List( 
        (-1, 0), // north
        (-1, 1), // northeast
        (0, 1),  // east
        (1, 1),  // southeast
        (1, 0),  // south
        (1, -1), // southwest
        (0, -1), // west
        (1, -1), // northwest
    )

    def fill(fill_char: String): Unit = {
        for (i <- 0 to this.x-1) {
            for (j <- 0 to this.y-1) {
                grid(i)(j) = fill_char
            }
        }
    }

    def randomStart(char: String, numberOfCells: Int): Unit = {
        for(_ <- 0 to numberOfCells-1){
            var random_x = Random.nextInt(this.x)
            var random_y = Random.nextInt(this.y)
            grid(random_x)(random_y) = "1"
        }
    }

    def display(): Unit = {
        for (i <- 0 to this.x-1) {
            for (j <- 0 to this.y-1){
                print(grid(i)(j))
            }
            println()
        }
    }

    def inGridBounds(x: Int, y: Int): Boolean = {
        return (x >= 0 && x < this.x && y >= 0 && y < this.y)
    }

    def getAliveNeighborCount(x: Int, y: Int): Int = {
        var aliveNeighborCount: Int = 0
        
        for ((x_direction,y_direction) <- directions){
            val neighbor_x = x + x_direction
            val neighbor_y = y + y_direction
            if (inGridBounds(neighbor_x, neighbor_y) && this.grid(neighbor_x)(neighbor_y) == "1"){
                aliveNeighborCount += 1
            }
        }
        return aliveNeighborCount
    }
}