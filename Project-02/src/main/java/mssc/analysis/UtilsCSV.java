package mssc.analysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilsCSV {
	
	static String separator = ";";
	
	File directory;
	String prefix;
	ArrayList<String> dataLines = new ArrayList<>();
	
	public UtilsCSV(String prefix, File dir) {
		this.prefix = prefix;
		this.directory = dir;
	}
	
	String escapeSpecialCharacters(String data) {
	    String escapedData = data.replaceAll("\\R", " ");
	    if (data.contains(",") || data.contains("\"") || data.contains("'")) {
	        data = data.replace("\"", "\"\"");
	        escapedData = "\"" + data + "\"";
	    }
	    return escapedData;
	}
	
	public String convertToCSV(String... strings) {
		return Stream.of(strings)
			      .map(this::escapeSpecialCharacters)
			      .collect(Collectors.joining(separator));
	}
	
	public void writeLine(String... strings) {
		dataLines.add(convertToCSV(strings));
	}
	
	public static void setSeparator(String separator) {
		UtilsCSV.separator = separator;
	}
	
	public static String getSeparator() {
		return UtilsCSV.separator;
	}
	
	/**
	 * Writes CSV to file
	 * @return output file path
	 * @throws IOException
	 */
	public String writeToFile() throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		String filename = String.format("%s_%s.csv", prefix, dateFormat.format(date));
		String fullPath = Paths.get(directory.getAbsolutePath(),filename).toString();
		File file = new File(fullPath);
	    try (PrintWriter pw = new PrintWriter(file)) {
		    dataLines.stream()
		          .map(this::convertToCSV)
		          .forEach(pw::println);
	    }
	    return file.getName();
	}
	
}
