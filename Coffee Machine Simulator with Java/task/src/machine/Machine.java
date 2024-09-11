package machine;

import java.util.Scanner;

public class Machine{
    int water, milk, beans, cup, money;
    static MachineState state;

    Scanner sc = new Scanner(System.in);
    // ingredient for one cup of espresso
    static final int WATER_FOR_ESPRESSO = 250;
    static final int MILK_FOR_ESPRESSO = 0;
    static final int BEANS_FOR_ESPRESSO = 16;
    static final int MONEY_FOR_ESPRESSO = 4;
    // ingredient for one cup of latte
    static final int WATER_FOR_LATTE = 350;
    static final int MILK_FOR_LATTE = 75;
    static final int BEANS_FOR_LATTE = 20;
    static final int MONEY_FOR_LATTE = 7;
    // ingredient for one cup of  cappuccino
    static final int WATER_FOR_CAPPU= 200;
    static final int MILK_FOR_CAPPU = 100;
    static final int BEANS_FOR_CAPPU= 12;
    static final int MONEY_FOR_CAPPU = 6;

    public Machine(int water, int milk, int beans, int cup, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cup = cup;
        this.money = money;
        setMainState();

    }
    private void setMainState() {
        MachineState state = MachineState.START;
        System.out.print("\nWrite action (buy, fill, take, remaining, exit):\n> ");
    }
    public boolean isWorking() {
        return state != MachineState.EXIT;
    }

    public void action(String act) {

        switch (act.toLowerCase()) {
            case "buy":
                // code block
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                coffeeMenu(sc.next());
                
                setMainState();
                break;

            case "fill":
                refill();
                setMainState();
                break;

            case "take":
                take();
                setMainState();
                break;

            case "remaining":
                remaining();
                setMainState();
                break;
            case "exit":
                state = MachineState.EXIT;
                break;
            default:
                setMainState();
                break;
        }
    }


    public void coffeeMenu(String coffeeType){
            if (coffeeType.equals("1")) {
                if (water > WATER_FOR_ESPRESSO
                        && beans> BEANS_FOR_ESPRESSO && cup> 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");

                    water -= WATER_FOR_ESPRESSO;

                    beans-= BEANS_FOR_ESPRESSO;
                    cup--;
                    money += MONEY_FOR_ESPRESSO;

                }else {
                    System.out.println("Sorry, not enough resources!\n");
                }

            } else if (coffeeType .equals("2") ) {
                if (water > WATER_FOR_LATTE &&milk > MILK_FOR_LATTE &&
                        beans > BEANS_FOR_LATTE && cup > 0) {

                    System.out.println("I have enough resources, making you a coffee!\n");

                    water-= WATER_FOR_LATTE;
                    milk -= MILK_FOR_LATTE;
                    beans-= BEANS_FOR_LATTE;
                    cup--;
                    money+= MONEY_FOR_LATTE;
                }else {
                    System.out.println("Sorry, not enough resources!\n");
                }

            } else if(coffeeType.equals("3")) {
                if (water > WATER_FOR_CAPPU && milk > MILK_FOR_CAPPU
                        && beans > BEANS_FOR_CAPPU && cup > 0) {

                    System.out.println("I have enough resources, making you a coffee!\n");

                    water -= WATER_FOR_CAPPU;
                    milk -= MILK_FOR_CAPPU;
                    beans -= BEANS_FOR_CAPPU;
                    cup --;
                    money += MONEY_FOR_CAPPU;


                }
            }else {
                System.out.println("Invalid input");

            }

        }

    private void refill() {
        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cup += sc.nextInt();
    }
    private void take(){
        System.out.println("\nI gave you $" + money + "\n");
        money =0;
    }
    private void remaining() {
        System.out.println("\nThe coffee machine has:\n"
                + water+ " ml of water\n"
                + milk + " ml of milk\n"
                + beans + " g of coffee beans\n"
                + cup + " disposable cups\n$"
                + money + " of money\n");
    }
}
