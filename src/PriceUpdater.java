import java.util.*;
public class PriceUpdater implements Subject
{
	private ArrayList<Observer> observers; 
	private double bid;
	private double ask;
	private double high;
	private double low;
	private double dir;
	private Date last;
	private String symbol;

	public double getBid() {
		return bid;
	}

	public double getAsk() {
		return ask;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getDir() {
		return dir;
	}

	public Date getLast() {
		return last;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
		notifyObserver();
	}

	public void setBid(double bid)
	{
		this.bid = bid;
		notifyObserver();
	}

	public void setAsk(double ask)
	{
		this.ask = ask;
		notifyObserver();
	}

	public void setHigh(double high)
	{
		this.high = high;
		notifyObserver();
	}

	public void setLow(double low)
	{
		this.low = low;
		notifyObserver();
	}

	public void setDir(double dir)
	{
		this.dir = dir;
		notifyObserver();
	}

	public void setLast(Date last)
	{
		this.last = last;
		notifyObserver();
	}

	public PriceUpdater()
	{
		observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer o)
	{
		 observers.add(o);
		 int observerIndex = observers.indexOf(o);
		 System.out.println("Observer " + (observerIndex+1) + " added");
	}

	@Override
	public void unregister(Observer o)
	{
		int observerIndex = observers.indexOf(o);
		 observers.remove(observerIndex);
		 System.out.println("Observer " + (observerIndex+1) + " deleted");
	}

	@Override
	public void notifyObserver()
	{
		for(Observer observer : observers)
		{
			observer.update(bid, ask, high, low, dir, last, symbol);
		}
	}

}
