import scala.io.StdIn.readInt

    object FibonacciSeqCalculation{

    def fibonacci(n: Int): Int =n match{
        case 0 =>0
        case 1 =>1
        case _ =>fibonacci(n - 1)+fibonacci(n - 2)
    }

    def fibonacciSeq(n: Int): Unit = {
        if (n>0) {
           fibonacciSeq(n - 1) 
           println(fibonacci(n - 1))
        }
    }

    def main(args: Array[String]): Unit = {
        println("Enter the number of Fibonacci numbers to print:")
        val n = readInt()
        fibonacciSeq(n)       
    }
}
