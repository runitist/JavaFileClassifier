package clsf;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//파일 분류 프로그램
public class Classification {
	
	public static void main(String[] args) {
		String path = "D:\\backupIMG"; // 파일이 위치하는 디렉토리 입력
		File dirFile = new File(path); // 해당 디렉토리에 대한 객체 생성
		File[] fileList = dirFile.listFiles(); //해당 디렉토리 객체 내의 파일 리스트 추출.
		for (File tempFile : fileList) { //디렉토리 파일 리스트를 차례로 열람.
			if (tempFile.isFile()) { // 해당 리스트가 디렉토리가 아닌 파일이라면,
			    String tempPath=tempFile.getParent()+"\\";//해당 파일 현재 경로 추출
			    System.out.println("파일 경로"+ tempPath);//D:\backupIMG\
			    
				String tempFileName = tempFile.getName();//해당 파일 이름 추출(dd.jpg)
				System.out.println("파일명 : "+tempFileName);// josi_evans_0007.png
				
				String mkdirpath = path +"\\"+ tempFileName.substring(0, tempFileName.length()-4);
				System.out.println("폴더명 : "+mkdirpath);//새로 생성할 폴더명 생성. D:\backupIMG\josi_evans_0007
				
				String fileName = tempPath+tempFileName;//D:\backupIMG\josi_evans_0007.png
				System.out.println("fileName : "+fileName);
				String dirName = mkdirpath+"\\";//D:\backupIMG\josi_evans_0007\
				System.out.println("dirName : "+dirName);
				
				String nmchng = filenamechng(fileName);
				System.out.println(nmchng);
				
				String mkdirpath2 = tempPath+nmchng;
				System.out.println(mkdirpath2);

				makedir(new File(mkdirpath2));//디렉토리 생성하는 메서드
				
				moveFile(fileName, mkdirpath2+"\\");//파일 이동하는 메서드
				
			}
		}
	}
	//특정 패턴에 맞도록 파일명 추출 메서드
	public static String filenamechng(String filename) {
		//filename의 형태는 d:\\a\\b\\c.jpg와 비슷.
		//먼저 경로값을 제거.
		String commonfilenm = filename.substring(filename.lastIndexOf("\\")+1, filename.length()-1);
		commonfilenm = commonfilenm.substring(0, commonfilenm.lastIndexOf("_"));
		
		return commonfilenm;
	}
	
	
	//디렉토리 생성하는 메서드
	public static void makedir(File folder) {
		if (!folder.exists()) {
			try{
				folder.mkdir(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
	    }
	//파일 삭제 메서드
	
	 public static void fileDelete(String deleteFileName) {
		  File I = new File(deleteFileName);
		  I.delete();
		 }

	//파일 이동하는 메서드
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
