import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    println("### MAKE SURE ALL NAMES ARE SPELLED CORRECTLY AND ARE MORE THAN 2 LETTERS ###")
    println()
    var Fname: String
    var lname: String
    var DOB: String

    // Gets the firstname from the user
    do {
        print("Whats is your first name: ")
        Fname = readLine().toString()
        var count: Int = 0
        var check: Boolean

        // loops through each character and checked if it macthes with regex
        //This make sure the inputs must be letters only
        for (i in Fname) {
            if (i.toString().matches((Regex("[a-zA-Z]")))) {
                count = count + 1
            }
        }
        //checks if first name is correct
        if (Fname.length - count == 0 && Fname.length >= 2) {
            check = false
        } else {
            check = true
        }
    } while (check);

    // Gets the Lastname from the user most of the stuff that
    // is implemented from the first name is implemented here

    do {
        print(" Whats is your last name: ")
        lname = readLine().toString()
        var count: Int = 0
        var check: Boolean

        for (i in lname) {
            if (i.toString().matches((Regex("[a-zA-Z]")))) {
                count = count + 1
            }
        }

        if (lname.length - count == 0 && lname.length >= 2) {
            check = false
        } else {
            check = true
        }
    } while (check);

    println()

    println("Hello, $Fname $lname!\n Welcome to James fortune telling.\n")
    print("If you wish to see your fortune type(y) else to end type(n): ")

    //Checks if user would like to continue
    val cont = readLine()
    if (cont == "y" || cont == "yes" || cont == "Y" || cont == "YES") {
        println("Your wish is my command!\n Now lets answer a few questions\n")

        do {
            var check: Boolean
            print("What is your date of birth(Ex. dd/mm/yyyy): ")
            DOB = readLine().toString()
            //Use regex to make sure the format i want is correct
            if (DOB.matches((Regex("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d\$"))))
            {
                check = false
            }
            else {
                check = true
            }

        }while (check);
        println("### DO NOT INCLUDE FINGERS LINES AND PALM LINES MUST BE BETWEEN 1 AND 20 ###\n")

        var Pline:Int
        do{
            print("How many CLEAR and THICK palm lines do you have on your right palm: ")
            Pline= Integer.valueOf(readLine())
        }while (Pline > 20 || Pline < 1)

        //Generates a random number from 1 to 342
        val random1 = (0..342).shuffled().last()

        val result = random1 + Pline
        println()

        //check if fortune.txt is available, if not displays error message
        try {
            // reads a particular line from the file the line number it reads is equal to result
            val line = Files.readAllLines(Paths.get("Fortune.txt"))[result]
            println("Your fortune is:[$line]")

        }catch (ex:Exception){
            print(ex.message)
        }

    }
    else if (cont == "N" || cont == "n" || cont == "no" || cont == "NO") {
        print("When you are ready, feel free to try again.")
    }
    else {
        print("Since you can't select an option, We will end here.")
    }
}
