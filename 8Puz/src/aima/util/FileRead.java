package aima.util;

import java.io.*;
import java.util.*;

public class FileRead {
	
	String filename;
	
	public FileRead(String filename){
		this.filename = filename;
	}
	
	public static ArrayList<ArrayList<Integer>> Matrix(String filename) throws FileNotFoundException{
		
		File inFile = new File(filename);
		BufferedReader buffer = new BufferedReader(new FileReader(inFile));
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		String br;
		try {
			while((br=buffer.readLine()) != null) {
				String[] splitted = br.split("\t");
				ArrayList<Integer> line = new ArrayList<>();
				for(String str : splitted) {
					line.add(Integer.parseInt(str));
				}
				list.add(line);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}