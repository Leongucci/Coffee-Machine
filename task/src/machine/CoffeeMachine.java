package machine;
import java.util.Scanner;

public class CoffeeMachine {
    //Initialize necessary variables
    private static int water = 400; // ml of water
    private static int milk = 540; // ml of milk
    private static int beans = 120; // g of coffee beans
    private static int cups = 9; // amount of disposable cups
    private static int money = 550; // $ in the machine
    private static Scanner scn = new Scanner(System.in); // scanner
    private static boolean active = true; // boolean for the while loop

    public static void main(String[] args) {
        //This is the main loop that maintains the machine running
        //Each case points to a specific method in order to keep loop clean
        //Can easily add or remove functions
        while (active) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scn.next();
            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    machineStatus();
                    break;
                case "exit":
                    active = false;
                    break;
                default:
                    System.out.println("That's not a valid action!");
                    break;
            }
        }
    }

    //Method for printing the current machine status
    public static void machineStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println(money + "$");
    }

    //Method for buying coffee
    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scn.next();
        //Checks for minimum ingredients whenever this method is called
        boolean canEspresso = (water >= 250 && beans >= 16 && cups >= 1);
        boolean canLatte = (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1);
        boolean canCappuccino = (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1);
        //Another very useful switch for each possible type of coffee
        //Can easily add more types of coffee
        switch (coffeeType) {
            case "1":
                if (canEspresso) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups -= 1;
                    break;
            } else {
                    System.out.println("Not enough ingredients to make an espresso.");
                    break;
                }

            case "2":
                if (canLatte) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups -= 1;
                    break;
                } else {
                    System.out.println("Not enough ingredients to make a latte.");
                    break;
                }

            case "3":
                if (canCappuccino) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cups -= 1;
                    break;
                } else {
                    System.out.println("Not enough ingredients to make a cappuccino.");
                    break;
                }
            case "back":
                break;
        }
    }

    //Method for adding ingredients to the machine
    public static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scn.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scn.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scn.nextInt();
        System.out.println("Write how many disposable cups do you want to add:");
        cups += scn.nextInt();
    }

    //Simple method to take the money from the machine, setting it to 0
    public static void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }




}
