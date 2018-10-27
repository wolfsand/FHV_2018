
import java.util.Random;

public class FillRandom implements FillStrategy {

	@Override
	public void fill(int[] numbers) {
		// TODO Auto-generated method stub
		Random Zufall = new Random();
		for (int i=0; i<numbers.length;i++) {
			numbers[i]=Zufall.nextInt(numbers.length);
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ("mit Zufallszahlen gefuellt");
	}

}



