package coffee_machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeeMachineService cms = new CoffeeMachineService();
        
        Scanner scanner = new Scanner(System.in);
        while( true ){
            cms.displayStock();
            cms.displayMenu();

            String coffeeType;
            coffeeType = scanner.nextLine();

            cms.selectCoffee(coffeeType);
            
            cms.insertMoney(80.00);
            cms.insertMoney(80.00);
        }
        
    }
}
