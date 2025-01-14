/*
* COMP 1010 SECTION [A02]
* INSTRUCTOR: [Zach Havens]
* STUDENT NUMBER: [Student #008028220]
* ASSIGNMENT: [Assignment #3]
* QUESTION: [Question #3]
*
* PURPOSE: This program is written to build a simple adventure where the user makes decisions that shape the story’s
  progression. (Extended edition with side quest)
*/

import java.util.Scanner;
import java.util.Random;
public class GadhiyaRushanSohilbhaiA3Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        startJourney(sc);
    }
    static int score = 0;
    static int magicRock = 0;
    static int amulet = 0;


    /*
    * Initiates the adventure by asking for the user's name and guiding them to either the castle or the river.
    * Receives user input (crossroad choice) and modifies global score, magicRock, or amulet based on choices.
    * Produces output describing the choices and paths taken.
    */
    static void startJourney(Scanner sc) {
        System.out.println("Welcome, adventurer! What is your name?");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + " You stand at a crossroads.");
        System.out.println("Do you go LEFT to the castle or RIGHT to the river?");
        String crossroad = sc.next();
        if(crossroad.equals("LEFT")) {
            System.out.println("You approach the grand castle. What will you do (Type 1 or 2)?\n" + "1. Look around the perimeter of the castle.\n" +"2. Go inside the castle.");
            String type = sc.next();
            if(type.equals("1")){
                left_Type_1(sc);
            }
            else if(type.equals("2")){
                left_Type_2(sc);
            }
            else {
                score += -2;
                if(randomizer_50_50() == 1) 
                left_Type_1(sc);
                else
                left_Type_2(sc);
            } 
        }
        else if(crossroad.equals("RIGHT")) {
            System.out.println("You come across a bridge over a river.\n The bridge is guarded by a heavily armed TROLL! \n The troll says \"pay me money and I will let you by!\" (Type a number 0-100)");
            String coin = sc.next();
            if(Integer.valueOf(coin) >= 0 && Integer.valueOf(coin) <= 50) {
                score += Integer.valueOf(coin);
                right_Type_0to50(sc);
            }
            else if(Integer.valueOf(coin) >= 51 && Integer.valueOf(coin) <= 100) {
                score += Integer.valueOf(coin);
                right_Type_51to100(sc);
            }
            else {
                score += -2;
                Random numCoin = new Random();
                int coins = numCoin.nextInt(101); // gives a number between 0-100
                score += (-5 * coins);
                if(coins >= 0 && coins <= 50) {
                    right_Type_0to50(sc);
                }
                else if(coins >= 51 && coins <= 100) {
                    right_Type_51to100(sc);
                }
            }
        }
    }

        /*
        * Handles the scenario when the user offers 0-50 coins to the troll.
        * Gets user input from the console, modifies global variables (amulet, score), and produces output.
        * The output describes the encounter with the troll and actions taken afterward.
        */
        static void right_Type_0to50(Scanner sc) {
            System.out.println("The troll is displeased with your frugal ways and shoves you into the water.\n They pocket your coin and disappears into the forest.");
            if(randomizer_80_20() == 5) {
                System.out.println("You shake off the wet water, feeling damp and cold, you hobble down the path.\nYou have arrived at the final location. There are three doors ahead of you.");
                finalLocation(sc);
            }
            else {
                amulet = 1;
                score += 20;
                System.out.println("As you struggle to regain your balance,\n your hand brushes against something shiny at the bottom of the river. \n You dive down and retrieve a beautiful amulet, its surface glimmering in the light. \n You shake off the wet water, feeling damp and cold, you hobble down the path.\n You have arrived at the final location. There are three doors ahead of you.");
                finalLocation(sc);
            }
        }

        /*
        * Manages the scenario when the user offers 51-100 coins to the troll.
        * Produces output based on user actions and modifies global variables (amulet, score).
        * Guides the user to the final location based on their choice to look around or walk.
        */
        static void right_Type_51to100(Scanner sc) {
            System.out.println("The troll is happy and leaves you as he disappears into the forest. \n What will you do?(TYPE 1 or 2) \n 1. Look around \n 2. Just keep walking.");
            int type = sc.nextInt();
            if(type == 1) {
                if(randomizer_80_20() == 1 && randomizer_80_20() == 2) {// 2 out of 5 is 40% chance 
                    amulet = 1;
                    score += 20;
                    System.out.println("As you look around you see a something shiny near a rock. \n You walk to it and retrieve a beautiful amulet, its surface glimmering in the light.\n You hobble down the path. You have arrived at the final location.\n There are three doors ahead of you.");
                    finalLocation(sc);
                }
                else {
                    System.out.println("After looking around for a while.\n You hobble down the path. You have arrived at the final location.\n There are three doors ahead of you.");
                    finalLocation(sc);
                }
            }
            else if(type == 2) {
                System.out.println("You keep walking down the path. You have arrived at the final location.\n There are three doors ahead of you.");
                finalLocation(sc);
            }
        }

    /*
    * Manages the scenario where the user explores the castle perimeter.
    * Modifies global variables (magicRock, score) and prompts user for action at the river.
    * Produces output about the user's discoveries and choices made afterward.
    */
    static void left_Type_1(Scanner sc) {
            if(randomizer_50_50() == 1){
                magicRock = 1;
                score += 15;
            System.out.println("While meandering around the outside of the castle,\n you stumble upon a glowing rock! You pocket it.\nYou exit the castle and arrive at a river. What will you do (Type 1 or 2)? \n 1. Take a minute to enjoy the river's splendor.\n2. Follow the path to the mysterious destination.");
                String at_River = sc.next();
                if(at_River.equals("1")) {
                    at_River_1(sc);
                }
                else if(at_River.equals("2")) {
                    at_River_2(sc);
                }
                else {
                    score += -2;
                    if(randomizer_50_50() == 1)
                    at_River_1(sc);
                    else
                    at_River_2(sc);
                }
            }
            else {
            System.out.println("While meandering around the outside of the castle,\n you arrive at a river. What will you do (Type 1 or 2)? \n 1. Take a minute to enjoy the river's splendor.\n2. Follow the path to the mysterious destination.");
            String at_River = sc.next();
                if(at_River.equals("1")) {
                    at_River_1(sc);
                }
                else if(at_River.equals("2")) {
                    at_River_2(sc);
                }
                else {
                    score += -2;
                    if(randomizer_50_50() == 1)
                    at_River_1(sc);
                    else
                    at_River_2(sc);
                }
            }
    }

    /*
    * Manages the scenario when the user goes inside the castle.
    * Modifies global variables (magicRock, score) and guides the user to the river with a choice.
    * Produces output based on user encounters and their actions afterward.
    */
    static void left_Type_2(Scanner sc) {
        score += 10;
            if(randomizer_80_20() == 1 || randomizer_80_20() == 2 || randomizer_80_20() == 3 || randomizer_80_20() == 4) {
                System.out.println("While exploring the castle's inside, you meet a wizard who says \n \"Why did I bring my magic wand to the bar? \n Because I heard they had great SPELLbinding cocktails!\" \n and he disappears as he laughed weirdly. \n You exit out the back of the castle. \n Now you reach near a river with a bridge over it. \n What will you do (Type 1 or 2)? \n1. Take a minute to enjoy the river's splendor. \n2. Follow the path to the mysterious destination.");
                String at_River = sc.next();
                if(at_River.equals("1")) {
                    at_River_1(sc);
                }
                else if(at_River.equals("2")) {
                    at_River_2(sc);
                }
                else {
                    score += -2;
                    if(randomizer_50_50() == 1)
                    at_River_1(sc);
                    else
                    at_River_2(sc);
                }
            }
            else {
                magicRock = 1;
                score += 15;
                System.out.println("While exploring the castle's inside, you meet a wizard who says \n \"Oh I knew you'd come, you are a true warrior and so I shall give you this magic rock for this will change your fate\" \n as he gives you the magic rock he vanished. You pocket this rock and exit out the back of the castle. \n You exit out the back of the castle. \n Now you reach near a river with a bridge over it. \nWhat will you do (Type 1 or 2)? \n1. Take a minute to enjoy the river's splendor. \n2. Follow the path to the mysterious destination." );
                String at_River = sc.next();
                if(at_River.equals("1")) {
                    at_River_1(sc);
                }
                else if(at_River.equals("2")) {
                    at_River_2(sc);
                }
                else {
                    score += -2;
                    if(randomizer_50_50() == 1)
                    at_River_1(sc);
                    else
                    at_River_2(sc);
                }
            }
    }

    /*
    * Handles the scenario when the user enjoys the river.
    * Modifies global variables (amulet, score) and directs to the final location.
    * Produces output based on user actions and discoveries made at the river.
    */
    static void at_River_1(Scanner sc) {
        if(randomizer_50_50() == 1) {
            System.out.println("After enjoying the peaceful calm of the river \n You have arrived at the final location. \n There are three doors ahead of you. ");
            finalLocation(sc);

        } else {
            amulet = 1;
            score += 20;
            System.out.println("While enjoying the peaceful calm of the river, you see something in the water! \n You scoop it up and pocket a shining amulet! \n You have arrived at the final location. There are three doors ahead of you.");
            finalLocation(sc);
        }
    }

    /*
    * Manages the scenario when the user chooses to follow the path instead of enjoying the river.
    * Directs the user to the final location without modifying global variables.
    * Produces output indicating arrival at the final location.
    */
    static void at_River_2(Scanner sc) {
        System.out.println("You have arrived at the final location. There are three doors ahead of you.");
        finalLocation(sc);
    }

    /*
    * Manages the final location based on the user's items (amulet and magicRock) and score.
    * Produces output describing the outcomes of using items at the door.
    * Determines the user's character based on their score.
    */
    static void finalLocation(Scanner sc) {
        if(amulet == 0 && magicRock == 0) {
            System.out.println("You stand there in the shiny glowing door's beautiful light\nNothing happens. You wait.\nNothing happens still. What a waste of your day!\nYou should have stayed home and studied for your COMP 1010 test.\n");
        }
        else if(amulet == 0 && magicRock == 1) {
            System.out.println("You stand there in the shiny glowing door's beautiful light\n You used the magic rock to open the treasure room and gather much gold! and silver");
        }
        else if(amulet == 1 && magicRock == 0) {
            System.out.println("You stand there in the shiny glowing door's beautiful light\n You entered the magical realm using amulet \n And you find yourself trapped in the magic realm for all eternity.");
            magicalRealm(sc);
        }
        else if(amulet == 1 && magicRock == 1) {
            System.out.println("You used the magic rock to open the treasure room and gather much gold!\nYou entered a magical realm using the amulet.\nYour fortune is known by all, and you are the ruler of this magical realm!");
        }
        if(score >= 0 && score <= 20) {
            System.out.println("Score = "+score);
            System.out.println("You are compatible with being a humble villager");
        } 
        else if(score >= 21 && score <= 40) {
            System.out.println("Score = "+score);
            System.out.println("You are suited for being an adventurer");
        }
        else if(score >= 41) {
            System.out.println("Score = "+score);
            System.out.println("You are destined to be a legendary hero!");

        }
    }

    /*
    * Manages the scenario in the magical realm where the user interacts with a dwarf.
    * Receives user input from the console to determine their choice of action.
    * Produces output based on user decisions and leads to potential encounters with the "Death Monger."
    */
    static void magicalRealm(Scanner sc) {
        Random rdm = new Random();
        System.out.println("No wait a second, a magic portal opened in front of you \n a dwarf with sharp nose and grey cloak walk towards you \n Select one (Type 1 or 2) 1. Try to fight him \n 2. Ask him if there is a way out of this realm");
        int choose = sc.nextInt();
        if(choose == 1) {
            System.out.println("As you try to punch the dwarf, your hand gets through his body \n as if punching air. \n The dwarf took his wand out and with a spell \n turned you into a rat");
        }
        else if(choose == 2) {
            System.out.println("The dwarf says there is only one way out of this magical realm \n \"You can only leave this realm if you retrieve the \'key of fate\' \n which is guarded by the most dangerous creature of this realm known as \"Death Monger\"\" \n Select one (Type 1 or 2) 1. Don't want to fight Death Monger and live for eternity in this realm \n 2. Have an ultimate Fight with the Death Monger");
            int fightOrNot = sc.nextInt();
            if(fightOrNot == 1) {
                System.out.println("Now you are trapped here for eternity");
            }
            else if(fightOrNot == 2) {
                System.out.println("You have entered the cave where Death Monger lives \n To win this fight with death monger you have to enter a number between 1 to 25 \n if the death monger chooses the same number then you officially defeat it and retrieve the key of fate\n if not then it will burn you with his fire balls");
                System.out.println("Enter \"START\" to start the fight");
                String start = sc.next();
                if(start.equals("START")) {
                    System.out.println("Enter a number between 1 to 25, choose wisely"); 
                    int userChoice = sc.nextInt();
                    int creatureChoice = rdm.nextInt(25)+1;//will give a number between 1 to 25
                    System.out.println("You choose : "+ userChoice);
                    System.out.println("Creature's choice : " + creatureChoice);
                    if(userChoice == creatureChoice){
                        System.out.println("CONGRATULATIONS!!! The VICTORY is yours \n the creature dies and you take the key of fate \n and return to your realm");
                    }
                    else {
                        System.out.println("You suffer the consequences of your fate again! \n the creature killed you by the fire balls\n you died, The END.");
                    }
                }
            }
        }
    }
        /*
        * Generates a random number between 0 and 1.
        * Used to create a 50/50 chance for various game scenarios.
        * Returns the generated random number.
        */
        static int randomizer_50_50() {
        Random rdm = new Random();
        int random = rdm.nextInt(2);// this will either give 0 or 1
        return random;
    }                

    /*
    * Generates a random number between 1 and 5.
    * Used to create an 80% chance of success in certain scenarios.
    * Returns the generated random number.
    */
    static int randomizer_80_20() {
        Random rdm = new Random();
        int random = rdm.nextInt(5)+1;//this will give a number between 1 to 5
        return random;
    }
}