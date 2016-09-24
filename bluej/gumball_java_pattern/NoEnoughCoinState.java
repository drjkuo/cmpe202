

public class NoEnoughCoinState implements State {
    GumballMachine gumballMachine;
 
    public NoEnoughCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int c) {
		System.out.println("You inserted a coin");
		gumballMachine.setCoin( gumballMachine.getCoin() + c);
		gumballMachine.setState(gumballMachine.getHasEnoughCoinState());
	}
 
	public void ejectCoin() {
		System.out.println("You haven't inserted a quarter");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "waiting for quarter";
	}
}
