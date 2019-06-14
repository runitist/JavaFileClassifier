package clsf;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//���� �з� ���α׷�
public class Classification {
	
	public static void main(String[] args) {
		String path = "D:\\backupIMG"; // ������ ��ġ�ϴ� ���丮 �Է�
		File dirFile = new File(path); // �ش� ���丮�� ���� ��ü ����
		File[] fileList = dirFile.listFiles(); //�ش� ���丮 ��ü ���� ���� ����Ʈ ����.
		for (File tempFile : fileList) { //���丮 ���� ����Ʈ�� ���ʷ� ����.
			if (tempFile.isFile()) { // �ش� ����Ʈ�� ���丮�� �ƴ� �����̶��,
			    String tempPath=tempFile.getParent()+"\\";//�ش� ���� ���� ��� ����
			    System.out.println("���� ���"+ tempPath);//D:\backupIMG\
			    
				String tempFileName = tempFile.getName();//�ش� ���� �̸� ����(dd.jpg)
				System.out.println("���ϸ� : "+tempFileName);// josi_evans_0007.png
				
				String mkdirpath = path +"\\"+ tempFileName.substring(0, tempFileName.length()-4);
				System.out.println("������ : "+mkdirpath);//���� ������ ������ ����. D:\backupIMG\josi_evans_0007
				
				String fileName = tempPath+tempFileName;//D:\backupIMG\josi_evans_0007.png
				System.out.println("fileName : "+fileName);
				String dirName = mkdirpath+"\\";//D:\backupIMG\josi_evans_0007\
				System.out.println("dirName : "+dirName);
				
				String nmchng = filenamechng(fileName);
				System.out.println(nmchng);
				
				String mkdirpath2 = tempPath+nmchng;
				System.out.println(mkdirpath2);

				makedir(new File(mkdirpath2));//���丮 �����ϴ� �޼���
				
				moveFile(fileName, mkdirpath2+"\\");//���� �̵��ϴ� �޼���
				
			}
		}
	}
	//Ư�� ���Ͽ� �µ��� ���ϸ� ���� �޼���
	public static String filenamechng(String filename) {
		//filename�� ���´� d:\\a\\b\\c.jpg�� ���.
		//���� ��ΰ��� ����.
		String commonfilenm = filename.substring(filename.lastIndexOf("\\")+1, filename.length()-1);
		commonfilenm = commonfilenm.substring(0, commonfilenm.lastIndexOf("_"));
		
		return commonfilenm;
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
