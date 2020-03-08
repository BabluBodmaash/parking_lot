package com.parking.lot.fileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.parking.lot.model.Ticket;



public class FileUtils {

	public static void writeObject(Object serObj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(getDirectory()+"/parkingSlot");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(serObj);
			objectOut.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Ticket ReadObject() {
		try {
			FileInputStream fileIn = new FileInputStream(getDirectory()+"/parkingSlot");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Object obj = objectIn.readObject();
			objectIn.close();
			return (Ticket) obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String getDirectory() {
		String dir = "";
		dir = System.getProperty("user.dir");
		return dir;
	}

	public static void removeFiles() {
		File file = new File(getDirectory()+"/parkingSlot");  
		try {
			file.delete();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} 
}
