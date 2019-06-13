package clsf;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Classification {
	
	public static void main(String[] args) {
		String path = "D:\\clf";
		File dirFile = new File(path);
		File[] fileList = dirFile.listFiles();
		for (File tempFile : fileList) {
			if (tempFile.isFile()) {
			    String tempPath=tempFile.getParent()+"\\";
				String tempFileName = tempFile.getName();
				System.out.println("���ϸ� : "+tempFileName);
				String mkdirpath = path +"\\"+ tempFileName.substring(0, tempFileName.length()-4);
				System.out.println("������ : "+mkdirpath);
				makedir(new File(mkdirpath));
				String fileName = tempPath+tempFileName;
				System.out.println("fileName : "+fileName);
				String dirName = mkdirpath+"\\";
				System.out.println("dirName : "+dirName);
				moveFile(fileName, dirName);
				
			}
		}
	}
	
	//���丮 �����ϴ� �޼���
	public static void makedir(File folder) {
		if (!folder.exists()) {
			try{
				folder.mkdir(); //���� �����մϴ�.
			    System.out.println("������ �����Ǿ����ϴ�.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
		}
	    }
	//���� ���� �޼���
	
	 public static void fileDelete(String deleteFileName) {
		  File I = new File(deleteFileName);
		  I.delete();
		 }

	//���� �̵��ϴ� �޼���
	public static void moveFile(String fileName, String dirName) {
		Path file = Paths.get(fileName); // "c/text.txt"
		Path movePath = Paths.get(dirName); // "c:/TEMP/"
		try {
			Files.move(file , movePath .resolve(file .getFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}
