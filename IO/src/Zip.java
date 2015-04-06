//import java.io.BufferedOutputStream;
//import java.io.DataInputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//import java.util.zip.ZipOutputStream;
//
//
//public class Zip {
//	public static void write(byte[] buffer, OutputStream out)
//			throws IOException {
//		out.write(buffer);
//		out.close();
//	}
//
//	public static void readZip(String zipName){
//		InputStream in=null;
//		try {
//			in = new FileInputStream(zipName);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ZipInputStream zip= new ZipInputStream(in);
//
//		try {
//			ZipEntry entry=zip.getNextEntry();
//			byte[] buffer = new byte[1024];
//
//			while(entry!=null){
//				zip.read(buffer, 0, buffer.length);
//				InputStream inputStream =null;
//				write(buffer,
//						new BufferedOutputStream (new
//								FileOutputStream(entry.getName())));
//				entry=zip.getNextEntry();
//			}
//		} catch (IOException e) {
//			System.out.println("Exception:");
//			e.printStackTrace();
//			return;
//		}
//
//	}
//	public static void writeZip(String zipName, String file){
//
//		ZipOutputStream zipOut=null;
//		try {
//			zipOut = new ZipOutputStream(new FileOutputStream(zipName));
//		} catch (FileNotFoundException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		}
//		byte[] buffer = new byte[1024];
//		try(InputStream in = new FileInputStream(file)) {
//			in.read(buffer);
//			in.close();
//		} catch (FileNotFoundException e2) {
//			e2.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ZipEntry e1 = new ZipEntry(file);
//		try {
//
//			if(zipOut.putNextEntry(e1)){
//				
//			zipOut.write(buffer, 0, buffer.length);
//			}
//
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//
//	//		try {
//	//			ZipEntry entry=zip.getNextEntry();
//	//			byte[] buffer = new byte[1024];
//	//
//	//			while(entry!=null){
//	//				zip.read(buffer, 0, buffer.length);
//	//				InputStream inputStream =null;
//	//				write(buffer,
//	//						new BufferedOutputStream (new
//	//								FileOutputStream(entry.getName())));
//	//				entry=zip.getNextEntry();
//	//			}
//	//		} catch (IOException e) {
//	//			System.out.println("Exception:");
//	//		    e.printStackTrace();
//	//		    return;
//	//		}
//
//
//
//public static void main(String[] args) {
//	readZip("arch.zip");
//	writeZip("arch2.zip", "in.txt");
////	writeZip("arch2.zip", "in2.txt");
//}
//}
