import java.util.Scanner;
import java.util.Timer;

public class Prices
{
	static String pair = "";
	private static double target = 0;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the pair");
		pair = sc.next();
		System.out.println("Enter target rate");
		target = sc.nextDouble();
		sc.close();

		Timer time = new Timer ();
		Scheduler sch = new Scheduler();
		time.scheduleAtFixedRate(sch, 0, 20000);	//(,local,period)
	}

	public static String getPair() {
		return pair;
	}

	public static void setPair(String pair) {
		Prices.pair = pair;
	}

	public static double getTarget() {
		return target;
	}

	public static void setTarget(double target) {
		Prices.target = target;
	}
}
