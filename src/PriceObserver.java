import java.util.Date;

public class PriceObserver implements Observer
{
	
	private double bid;
	private double ask;
	private double high;
	private double low;
	private double dir;
	private Date last;
	private String symbol;
	private static int counter = 0;
	private int observerID;
	
	private Subject priceObserver;

	public PriceObserver(Subject priceObserver)
	{
		this.priceObserver = priceObserver;
		this.observerID = ++counter;
		priceObserver.register(this);
	}

	@Override
	public void update(double bid, double ask, double high, double low, double dir, Date last, String symbol)
	{
		this.bid=bid;
		this.ask=ask;
		this.high=high;
		this.low=low;
		this.dir=dir;
		this.last=last;
		this.symbol=symbol;
		
		print();
	}
	
	public void print()
	{
		System.out.println(observerID + "\nsymbol:" + symbol + "\nBid: " + bid + "\nask: " + ask + "\nhigh: " + high +
				"\nlow" + low + "\ndir" + dir + "\nlast" + last+ "\n");
	}

}
