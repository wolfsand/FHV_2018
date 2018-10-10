

import java.io.*;
import java.util.*;

public class Settings {

	private static Settings settings; /* single object */


	Properties properties = new Properties();


	/* empty constructor - singleton pattern */
	private Settings() {		
	}

	public static Settings getInstance(String[] args) {
		if (settings == null) {
			settings = new Settings();
			settings.interpreteArgs(args);	
			System.out.println("settings read");
		}

		return settings;
	}

	/* first argument ==> filename of settings */
	private void interpreteArgs(String[] args) {
		String filename;
		File file;
		if (args.length > 0) {
			filename = args[0];		
		}
		else filename ="settings.txt";

		System.out.println("Filename: "+filename);

		file = new File(filename);	
		if (file.exists() && file.canRead()) {
			setProperties(file);
		};
		// saveProperties(file);

	}

	private void setProperties(File file) {

		try {
			Reader reader = new FileReader(file);
			System.out.println(file.getAbsolutePath());
			properties.load(reader);
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Could not find file");
		}
		catch (IOException e) {
			System.err.println("error opening file"); }
	}

	private void saveProperties(File file) {
		try {
			Writer writer = new FileWriter(file);
			System.out.println(file.getAbsolutePath());
			properties.setProperty("Test", "value");
			properties.store(writer, "SAVE");
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Could not find file");
		}
		catch (IOException e) {
			System.err.println("error opening file"); }
	}


	public int getArrayLength() {
		try {
			return (Integer.parseInt(properties.getProperty("ArrayLength")));
		}
		catch (NumberFormatException e) {
			return 0;
		}
	}

	public SortStrategy getSortStrategy() {

		String sortMethod;
		sortMethod = properties.getProperty("SortMethod");
		if (sortMethod == "SelectionSort") {
			return new SelectionSort();
		}
		else {
			return new SelectionSort();
		}
	}

	public FillStrategy getFillStrategy() {

		String fillMethod;
		fillMethod = properties.getProperty("FillMethod");
		if (fillMethod == "Random") {
			return new FillRandom();
		}
		else {
			return new FillRandom();
		}
	}


}
