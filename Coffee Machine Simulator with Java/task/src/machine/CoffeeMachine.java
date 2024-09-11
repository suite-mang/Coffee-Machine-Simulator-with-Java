package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        int existWater = 400;
        int existMilk = 540;
        int existBeans = 120;
        int existCup = 9;
        int existMoney = 550;

        //import scanner for reading input                 
        Scanner sc = new Scanner(System.in);
        Machine machine = new Machine(existWater, existMilk, existBeans, existCup, existMoney);
        while (machine.isWorking()) {
            machine.action(sc.next());
        }
        
        sc.close();
    }


}
