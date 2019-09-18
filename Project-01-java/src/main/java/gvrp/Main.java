package gvrp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

	/**
	 * Runs the GVRP solver, printing the results to the standard output
	 * @param args
	 * <ul>
	 * <li>if none, requests one instance file through {@link JFileChooser}
	 * and runs the solver for this instance only</li>
	 * <li>else, runs the solver for each instance file path provided
	 * being all arguments file paths</li>
	 * </ul>
	 */
	public static void main(String [] args) {
		if (args.length == 0) {
			
			File instanceFile = promptForFolder();
			System.out.println(instanceFile);
			
			Scanner sc = null;
			
			try {
				sc = new Scanner(instanceFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
			
			Instance instance = null;
			
			try {
				instance = Instance.parse(sc);
			} catch (NoSuchElementException nsee) {
				nsee.printStackTrace();
				return;
			} catch (IllegalStateException ilse) {
				ilse.printStackTrace();
				return;
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
			System.out.println(instance);
		} else {
			// TODO: for N files provided by args
		}
	}

	public static File promptForFolder()
	{
	    JFileChooser fc = new JFileChooser();
	    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    fc.setCurrentDirectory(new java.io.File("./data/GVRP3"));
	    fc.setFileFilter(new FileNameExtensionFilter("GVRP instance", "gvrp"));

	    if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	    {
	        return fc.getSelectedFile();
	    }

	    return null;
	}
	
}
