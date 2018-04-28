import grid.Grid
import scala.io.StdIn.readLine

object Game {
    def main(args: Array[String]): Unit = {
        var grid = new Grid(args(0).toInt,args(1).toInt)
        grid.fill("-")
        grid.randomStart("*", args(2).toInt)

        var input = ""
        while(input != "stop"){
            grid.display()

            var nextGrid = Array.ofDim[String](grid.x, grid.y)
            for (i <- 0 to grid.x-1) {
                for (j <- 0 to grid.y-1) {
                    val aliveNeighborCount = grid.getAliveNeighborCount(i, j)

                    if (grid.grid(i)(j) == "*" && (aliveNeighborCount < 2 || aliveNeighborCount > 3)) {
                        nextGrid(i)(j) = "-"
                    }
                    else if (grid.grid(i)(j) == "-" && aliveNeighborCount == 3){
                        nextGrid(i)(j) = "*"
                    }
                    else {
                        nextGrid(i)(j) = grid.grid(i)(j)
                    }
                }
            }
            grid.setGrid(nextGrid)
            input = readLine()
        }
    }
}