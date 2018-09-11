
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
public class encrypt {
 
	public static void main(String[] args) throws IOException{
	
		//BufferedImage original = 
          //      ImageIO.read(new File("C:/Users/shikha/eclipse-workspace/Quest/1.bmp"));

//ByteArrayOutputStream by = new ByteArrayOutputStream();
//ImageIO.write( original, "bmp", by );

//byte[] image = by.toByteArray();

		detectingface df =new detectingface();
	  	String inPath=df.detect();
	  	System.out.println("image"+inPath);
	  	BufferedImage original = ImageIO.read(new File(inPath));
	  	ByteArrayOutputStream by = new ByteArrayOutputStream();
	  ImageIO.write( original, "bmp", by );
	  		
		byte[] image=by.toByteArray();
		byte a1=4;
		byte a2=5;
		byte q=(byte) 251;
		byte x=1;
		byte y = 0;
		
		byte[] s1 = new byte[image.length];
		
		for(int i=0;i<=53;i++)
		{
			s1[i]=image[i];
		}
		for(int i=54;i<image.length;i++)
		{
			 s1[i]=(byte) (image[i]+a1*x+a2*x*x);
			 s1[i]=(byte) (s1[i] % q);
		}
		
		System.out.println(image[0]);
		System.out.println(s1[0]);
		Path s=Paths.get("C:/Users/shikha/eclipse-workspace/OpenCVExample/images/share.bmp");
		
		Files.write(s,s1);
		
		
		
		
		
	//int a=	(y1 * (-x2 * -x3) * inverse(((x1-x2)*(x1-x3)),q) + y2 * (-x1 * -x3) * inverse(((x2-x1)*(x2-x3)),q) + y3 * (-x1 * -x2) * inverse(((x3-x1)*(x3-x2)),q)) % q;
		 
		
		
	}
}
