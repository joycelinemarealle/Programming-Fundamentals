# Programming-Fundamentals

Project: Programming Fundamentals
Lottery System

SUMMARY
For this project, I worked independently to develop a UK National Lottery game in Java, utilizing Scanner for input, ArrayList for data storage, Random for number generation, and control flow structures and loops for game logic, ensuring input validation, age verification, and user interaction features.

PROJECT DETAILS
FR1: Over 18s Only!
In order to play the game, I asked the user for their name and date of birth. I could ask for the year, month, and day separately, or as a single string.
My program validated the input (e.g., a date of 33/19/2056 is clearly not reasonable, what about 01/01/1900?). It also validated that the person was over 18 in order to play the game.
When checking ages, I assumed that the date that the game was played was 10th June 2024.

Java Concepts Used:
Input Handling: I used Scanner to capture user input.
Date Validation: I used date manipulation and validation techniques to ensure the input was reasonable and that the user was over 18 years old.

FR2: Pick Numbers
I allowed the user to pick six numbers for their lottery ticket from the range 1-49. The user could only pick each number once per game, and they had to pick exactly six numbers.

Java Concepts Used:
Collections: I used an ArrayList to store the user's chosen numbers.
Input Validation: I ensured that the numbers were within the specified range and that there were no duplicates.

FR3: Lucky Dip
In addition to allowing users to pick their own numbers, I offered the choice for the program to generate a 'lucky dip', where the program picked six random numbers for their ticket.
The same rules applied: six numbers, from the range 1-49, and each number could be picked only once per game.

Java Concepts Used:
Random Number Generation: I used the Random class to generate random numbers.
Collections: I used an ArrayList to store the randomly generated numbers.

FR4: View the Ticket
I allowed the user to see the ticket (i.e., the numbers they had selected).

Java Concepts Used:
Output Handling: I used System.out.println to display the user's ticket.

FR5: Play the Game
When ready, the user could run the lottery to see if they had won.
The program picked exactly six random numbers from the range 1-49, and these numbers were compared against the ticket. A range of prizes were on offer:
1 or fewer matches resulted in no prize.
2 correct numbers got a prize of £1.
3 correct numbers got a prize of £2.
4 correct numbers got a prize of £4.
5 correct numbers got a prize of £8.
6 correct numbers won the jackpot.

Java Concepts Used:
Random Number Generation: I used the Random class to generate winning numbers.
Collections: I used an ArrayList to store the winning numbers.
Control Flow: I used conditional statements to check the number of matches and determine the prize.

FR6: Check the Ticket
I provided a way for the user to check their ticket and see if they had won, and how much they had won!

Java Concepts Used:
Output Handling: I used System.out.println to display the results and the prize.

FR7: Reset and Replay
I provided an option to reset the game and start over from the very beginning.

Java Concepts Used:
Control Flow: I used loops and methods to reset the game state and allow the user to play again.
