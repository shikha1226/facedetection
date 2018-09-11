import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat; 
import org.opencv.core.MatOfRect; 
import org.opencv.core.Point; 
import org.opencv.core.Rect; 
import org.opencv.core.Scalar; 

import org.opencv.imgcodecs.Imgcodecs;  
import org.opencv.imgproc.Imgproc; 
import org.opencv.objdetect.CascadeClassifier;  
  
public class detectingface {  
private static final boolean Rect = false;

public String detect() {
	 System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
    String f = "C:/Users/shikha/eclipse-workspace/OpenCVExample/images/1.jpg";	//load image
     Mat matr = Imgcodecs.imread(f); 	//matrix obj
    
	
	 
	 
     String lbp = "C:/Program Files (x86)/opencv/sources/modules/java/test/common_test/res/raw/lbpcascade_frontalface.xml"; 
  CascadeClassifier classifier = new CascadeClassifier(lbp); 	//cascade classifier

  MatOfRect det = new MatOfRect(); 	//matrix object
  
  classifier.detectMultiScale( matr, det);  
  
  System.out.println(String.format("Detected %s faces",det.toArray().length));  
      
 for (Rect box : det.toArray()) { //draw rectangle in image
  
	 Imgproc.rectangle(matr,new Point(box.x, box.y), new Point(box.x + box.width, box.y + box.height),new Scalar(0, 0, 255), 3);} 
                   
  Imgcodecs.imwrite("C:/Users/shikha/eclipse-workspace/OpenCVExample/images/output.jpg", matr); 	//output image
    String newPath=    "C:/Users/shikha/eclipse-workspace/OpenCVExample/images/1.bmp";
  System.out.println("Image Processed");  
	return newPath;
}

}