

public class NoEnoughCoinState implements State {
    GumballMachine gumballMachine;
 
    public NoEnoughCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int c) {
		System.out.println("You inserted a coin");
		gumballMachine.setCoin( gumballMachine.getCoin() + c);
		if (gumballMachine.getCoin() >= 50)
			gumballMachine.setState(gumballMachine.getHasEnoughCoinState());		
	}
 
	public void ejectCoin() {
		System.out.println("Not enough coin");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no enough coin");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "waiting for quarter";
	}
}
