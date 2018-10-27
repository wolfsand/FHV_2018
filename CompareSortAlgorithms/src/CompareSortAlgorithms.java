
import java.util.Date;

public class CompareSortAlgorithms {

	public static void main( String[] args )
	{
		Date start;
		Date end;
		Long duration;
		SortStrategy sortStrategy;
		FillStrategy fillStrategy;


		Settings settings = Settings.getInstance(args);
		int arrayLength = settings.getArrayLength();
		fillStrategy = settings.getFillStrategy();
		sortStrategy = settings.getSortStrategy();


		int[] numbers;
		numbers = new int[arrayLength];
		fillStrategy.fill(numbers);
		start = new Date();
		sortStrategy.sort(numbers);
		end = new Date();
		duration = end.getTime()-start.getTime();

		System.out.println(sortStrategy.getName());
		System.out.println(fillStrategy.getName());
		System.out.println("Size: " + arrayLength +"  Duration: "+ duration + "milliseconds");
		System.out.println("*********************");
		System.out.println();

		System.out.println("done");

	}
}



