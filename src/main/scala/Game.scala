import grid.Grid
import scala.io.StdIn.readLine

object Game {
    def main(args: Array[String]): Unit = {
        var grid = new Grid(args(0).toInt,args(1).toInt)
        grid.fill("0")
        grid.randomStart("1", args(2).toInt)

        var input = ""
        while(input != "stop"){
            grid.display()
            for (i <- 0 to grid.x-1) {
                for (j <- 0 to grid.y-1) {
                    val aliveNeighborCount = grid.getAliveNeighborCount(i, j)

                    if (aliveNeighborCount < 2 || (grid.grid(i)(j) == "1" && aliveNeighborCount > 3)) {
                        grid.grid(i)(j) = "0"
                    }
                    else if (grid.grid(i)(j) == "0" && aliveNeighborCount == 3){
                        grid.grid(i)(j) = "1"
                    }
                }
            }
            input = readLine()
        }
    }
}