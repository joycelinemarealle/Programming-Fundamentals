package ProgrammingFundamentalsProject;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LotterySystemProject {
    //Global can be accessed by any method //create new array and initialize index // static int i = 0; dont need. do not want variable each time
    static int[] playerRandomArray = new int[6];//create new array of type int
    static int[] computerRandomArray = new int[6];
    static int[] lotteryNumbersArray = new int[6];
    static boolean playGame = true; //assume true meaning want to play again

    public static void main(String[] args) {

       do { //keep on playing game until user says no
           // create new object
           Scanner scanner = new Scanner(System.in);

           // Ask user for name
           System.out.println("/nStart of Lottery. Enter your name");
           String name = scanner.nextLine();

           //Call static method that Validate age
           dateValidation();
           //call static method for playerTicket number after player  choice 1 / their own or 2/computer random number generator
           int [] resultsOfPlayerTicketArray = playerTicketArray(); //save the returned array
           System.out.println("\nYour Ticket Number is " + Arrays.toString(resultsOfPlayerTicketArray));

           //Call static method for Lottery Numbers
           capturedLotteryNumbers();
           System.out.println("\nLottery Number is " + Arrays.toString(lotteryNumbersArray));

           //count to see if user ticket matches that of Lottery
           int numberOfMatches = numberOfMatchesOfLottery (lotteryNumbersArray,resultsOfPlayerTicketArray); //??? 3)issues with which parameters to pass through. want to compare lottery ticket and user ticket
           System.out.println("\nThe number of your matches is " + numberOfMatches);

           //Call static method that assigns prizes
           String resultsOfPrizes = getPrize(lotteryNumbersArray, resultsOfPlayerTicketArray);
           System.out.println("\n");
           System.out.println(resultsOfPrizes);

           //Ask user if want to play game again
           System.out.println("\nWould you like to play the Lottery again? Answer Yes or No");
           String playGameAgainChoice = scanner.nextLine();
           if (playGameAgainChoice.equalsIgnoreCase ("No")) { //define as String which is reference so use equals a.equals('b')
               playGame = false;
               System.out.println("\nExiting Game. Goodbye");
               break; //break from game
           } else {
               playerRandomArray = new int[6]; //need to reset to make sure the array is empty
               computerRandomArray = new int[6];
                lotteryNumbersArray = new int[6];
           }
       } while (playGame); //always run the game until user says no - they do not want play again

    }

    public static void dateValidation(){
        //Loop until a valid date is added and user > age
        LocalDate birthDate = null; //initialize birthdate as empty. put outside loop so accessible when calculating age
        boolean dateIsValid = false; //assume false until proven otherwise when a valid output is added
        Scanner scanner = new Scanner(System.in);
        // Ask user for date in format Month-day-year format
        while (!dateIsValid) { //start as dateIsValid is false when date is not valid
            System.out.println("\nEnter your date of birth in MONTH-DAY-YEAR format. For example 12-13-1980");
            String birthDateStr = scanner.nextLine(); // initialze name variable + get string date from user

            //Parse and Validate the date format
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); //object for date formatter
                birthDate = LocalDate.parse(birthDateStr, formatter); //converts user string to date format, if converted then date valid
                dateIsValid = true; //date format is valid so now can calculate age

                //If date valid now Calculate age
                LocalDate today = LocalDate.of(2024,06,10); // check date is June 10th 2024
                Period age = Period.between(birthDate, today); //calculate time difference (yrs, month,days ) between birthdate date now
                int years = age.getYears();

                //Test to see if 18 years and above
                if (years >= 18 && years < 120) { //range of one alive
                    System.out.println("\nYour age is " + years + " years");
                    break; //exit loop if age > 18

                } else if (years > 120 ){
                    System.out.println("\nYour age is " + years + " years. Invalid Age");
                    dateIsValid = false; // cant be alive. set dateIsValid to false to ask again birthday !dataIsValid
                }
                else {
                    System.out.println("\nYou need to be 18 years old to participate in the Lottery System. ");
                    birthDateStr = scanner.nextLine(); // Ask again user to their date of birth
                }
                //if date not valid then print error and prompt user to enter valid date
            } catch (DateTimeParseException e) {
                System.out.println("\nInvalid Date. Enter a valid date");
                continue; //skip to the top to ask user for birthdate
            }
        }

    }

    public static int[] playerTicketArray() { //no  void since returning array
        //ask user if want to choose random or let computer generate
            System.out.println("Select 1 if want to generate your own 6 random numbers");
            System.out.println("Select 2 if want computer to generate your 6 random numbers");
            Scanner scanner = new Scanner(System.in);
            int playerchoice = scanner.nextInt();

            //Depending on number selected, pick appropriate random generator option
            if (playerchoice == 1) {  //Ask user to choose random number 6 times
                System.out.println("\nChoose 6 random numbers between 1- 49");
                capturedNumbersArray(); //Call static method that captures users in array. No need parameters since not returning anything
                System.out.println("\nYou added your own random numbers. Your Ticket Number is " + Arrays.toString(playerRandomArray));
                return playerRandomArray; // need to return player generated number array need to use it in the comparison of lottery matches

            } else { //FR3 Lucky dip
                System.out.println("\nStart of Lucky Dip");
                computerArray();  //Call static method that captures users in array. No need parameters since not returning anything
                System.out.println("\n Computer generated your ticket. Your Ticket Number is " + Arrays.toString(computerRandomArray)); //print out the array
                return computerRandomArray; //return computer generated number array since need to use it in the comparison of lottery matches
            }// use if or else since need to always return something. This avoids situation where user type other number than 1 or 2

         //1)??? how do I return an array that captures either option 1 player inserts own numbers or 2. players ask computer to generate. I need it to compare with Lottery ticket
    }

    public static void capturedNumbersArray() {   //add void since not returning anything //no parameters added since no calculations done
        Scanner scanner = new Scanner(System.in);
        //Capture player 6 random numbers between 1-49 //repeat 6 times so use for loop. Number of times length of array

        for (int i = 0; i < playerRandomArray.length; i++) {
            System.out.println("\nEnter a number:");
            int numberChosenByPlayer = 0; //initialize variable
            boolean newNumber; //intialize variable
            do {
                newNumber = true;// set the condition to true - assuming they are going to enter a new number
                numberChosenByPlayer = scanner.nextInt(); //in static method allow to ask 6 times
                for (int j = 0; j < playerRandomArray.length; j++) {
                    if (playerRandomArray[j] == numberChosenByPlayer) { // it's in there
                        System.out.println("\nThe number is already chosen. Choose another number");
                        newNumber = false; // set the condition to false because they didn't provide a new number
                        break;
                    }
                }
            } while (!newNumber); // ?? While not newNumber ( not true) means when duplicate number entered do ..

            playerRandomArray[i] = numberChosenByPlayer; // if we've got here then the user has entered a number not in the array //insert number into array input = to what players adds

        }
    }

    //Static method Lucky Dip
    public static void computerArray() { //add void since not returning anything //no parameters added since no calculations done

        for (int n = 0; n < computerRandomArray.length; n++) {
            int computerNumber = 0;
            boolean computerRandomNumberIsnew; //initialize boolean

            do {
                computerRandomNumberIsnew = true;
                computerNumber = (int) (Math.random() * 49) + 1; //find random number //Math random generates upto 0.99 *49 gets to 48.99 int truncated down to 48. then add 1 to get to 49
                //System.out.println("\nRandom number by computer " + computerNumber);

                //test if in array already
                for (int k = 0; k < computerRandomArray.length; k++) {
                    if (computerNumber == computerRandomArray[k])
                        computerRandomNumberIsnew = false;
                    break;
                }
            } while (!computerRandomNumberIsnew); //if computer random number not new keep on generating number

            //If got here means new number were added to array
            computerRandomArray[n] = computerNumber; //capture computer random number in array

        }
    }

    //Static Random number for Lottery System
    public static void capturedLotteryNumbers() { //add void since not returning anything
        int lotteryRandomNumber = 0;
        boolean lotteryNumberIsNew;

        for (int k = 0; k < lotteryNumbersArray.length; k++) {
            do {
                lotteryNumberIsNew = true; //assume true until proven otherwise

                lotteryRandomNumber = (int) (Math.random() * 49) + 1;

                //check if number created already in array
                for (int l = 0; l < lotteryNumbersArray.length; l++) {
                    if (lotteryRandomNumber == lotteryNumbersArray[l]) {
                        lotteryNumberIsNew = false;
                        break;
                    }
                }

            } while (!lotteryNumberIsNew);   //if lottery random number is not new then keep on generating random number until get new then put array
            lotteryNumbersArray[k] = lotteryRandomNumber; //Got here because new number generated . noe add to array
        }

    }

    //Static method to do number of counts
    public static int numberOfMatchesOfLottery(int[] lotteryNumbersArray, int[] resultsOfPlayerTicketArray) { //return array so not void
        int count = 0; //use nested to test matches regardless of their positions
        for (int a = 0; a < lotteryNumbersArray.length; a++) {
            for ( int b = 0 ; b< resultsOfPlayerTicketArray.length;  b++){
                if (lotteryNumbersArray[a] == resultsOfPlayerTicketArray[a]) {
                    count += 1;
                    break; //stop inner loop if match found
                }

            }

        }
        return count;
    }

    //Static method to assign prize of number of counts to applicable prices
    //do use previous method if count > 1,23,??

     public static String getPrize(int[] lotteryNumbersArray, int[] resultsOfPlayerTicketArray){ //pass the parameters

         int numberOfMatches = numberOfMatchesOfLottery(lotteryNumbersArray, resultsOfPlayerTicketArray); //pass paramters
        String prize = " ";
          if (numberOfMatches == 2) {
              prize = " You have 2 Matches. Your Prize is $1";
              return prize;
        }
         else if (numberOfMatches == 3 ) {
              prize = " You have 3 Matches. Your Prize is $2";
             return prize;
        }
         else if ( numberOfMatches ==4) {
             prize = " You have 4 Matches. Your Prize is $3";
            return prize;
        }
         else if (numberOfMatches ==5 ) {
             prize = " You have 5 Matches. Your Prize is $8";
              return prize;

        }
         else if (numberOfMatches == 6) {
             prize =" You have 6 Matches. Your Prize Jackpot";
             return prize;

        }
         else {
             prize = "Sorry, You won no prize. Please try again";
             return  prize;

         }
     }
}

/*//Call static method that captures player's random numbers in array. No need parameters since not returning anything
        //capturedNumbersArray();
        //System.out.println("You entered your own 6 random numbers. Your Ticket Number is " + Arrays.toString(playerRandomArray));

        //Call static method computer generated numbers in array. No need parameters since not returning anything
        //computerArray();
        //System.out.println("\n Computer generated your ticket. Your Ticket Number is " + Arrays.toString(computerRandomArray)); //print out the array with 6 random numbers
*/
//FR3 Lucky dip Static Method

/*Capture user age
 * Convert user string age to date format
 * validate date
 * calculate age
 * test if greater than 18 year old */