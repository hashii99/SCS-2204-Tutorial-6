import scala.io.StdIn.readLine

object Main {
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  def main(args: Array[String]): Unit = {

    println("Enter the string: ");
    val s = readLine()

    //Encryption function
    //parameters -> character, key, alphabet
    val encryption = (c:Char, key:Int, a:String)=> a((a.indexOf(c.toUpper)+key)%a.size)
    //get given character and add the key value and take mod with a.size

    //Decryption function
    val decryption = (c:Char, key:Int, a:String) => a((a.indexOf(c.toUpper)-key%a.size))

    //cipher function takes particular functions to process the data
    //pass the algorithm to the map function
    val cipher = (algo:(Char,Int,String)=> Char, s:String, key:Int, a:String)=> s.map(algo(_,key,a))
    //take each character of input string and map based on the given algorithm
    //map function apply this algorithm to every character in the string

    val ct= cipher(encryption,s,5,alphabet)
    //entription function, string, key, alphabet
    println(ct)

    val pt= cipher(decryption,ct,5,alphabet)
    println(pt)
  }
}