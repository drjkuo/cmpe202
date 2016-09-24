

import java.util.Random;

public class HasEnoughCoinState implements State {
	GumballMachine gumballMachine;
 
	public HasEnoughCoinState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertCoin(int c) {
		gumballMachine.setCoin( gumballMachine.getCoin() + c);
		System.out.println("You can't insert another quarter");
	}
 
	public void ejectCoin() {
		System.out.println("Coin returned");
		//coin = 0;
		gumballMachine.setCoin(0);
		gumballMachine.setState(gumballMachine.getNoEnoughCoinState());
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.addGumballInSlot();
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
}
