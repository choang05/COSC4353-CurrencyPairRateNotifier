import java.util.Date;

public interface Observer
{
	public void update(double bid, double ask, double high, double low, double dir, Date last, String symbol);
}
