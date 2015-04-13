package ru.kpfu.itis.group403.sharipova.zip;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class Zip {


	public static void readZip(String zipName){
		try (ZipInputStream zip= new ZipInputStream(new FileInputStream(zipName))){
			ZipEntry entry;
			byte[] buffer = new byte[1024];
			int len;

			while((entry=zip.getNextEntry())!=null){
				try(BufferedOutputStream dest=new BufferedOutputStream (new FileOutputStream(entry.getName()))){
					while((len=zip.read(buffer))!=-1){

						dest.write(buffer);
					}
				}
				catch (IOException e){
					e.printStackTrace();
					return;
				}
			}

		} catch (IOException e) {
			System.out.println("Exception:");
			e.printStackTrace();
		}

	}
	public static void writeZip(String zipName, String fileName){

		try (
				ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName));
				InputStream in = new FileInputStream(fileName);){


			byte[] buffer = new byte[1024];
			int len;
			ZipEntry e1 = new ZipEntry(fileName);
			zipOut.putNextEntry(e1);
			while((len=in.read(buffer))!=-1){
				zipOut.write(buffer);
			}



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	



	public static void main(String[] args) {
		readZip("C:\\Users\\1-ой\\newWorkplace\\Zip\\arch.zip");
		writeZip("arch2.zip", "in.txt");
		writeZip("arch2.zip", "in2.txt");

	}
}
