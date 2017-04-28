import java.util.Timer;
import java.util.TimerTask;

public class Scheduler extends TimerTask
{
	String currencyPair = Prices.pair;
	XMLFileReader x = new XMLFileReader();
	@Override
	public void run()
	{
		try
		{
			double bid = x.xmlJdom(currencyPair); //get currencypair
			double targetRate = Prices.getTarget();

			if (bid >= targetRate)
			{
				System.out.println("\n Current rate >=   "+ targetRate + "    !!! \n");
				System.exit(0);
			}
			else
			{
				System.out.println("\n Current rate <=   "+ targetRate + "    !!! \n");
			}
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


