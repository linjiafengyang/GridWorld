import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

public class ImageJUnitTest {
	@Before
	public void setUp() throws Exception {}
	
	private myImageIO myImage = new myImageIO();
	private myImageProcessor processor = new myImageProcessor();
	
	@Test
	// test blue of 1.bmp
	public void testBlue1() throws IOException {
		Image imageBlue1 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/1.bmp");

		Image blue1 = processor.showChanelB(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/1_blue_goal.bmp");
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		int w = blue1.getWidth(null);
		int h = blue1.getHeight(null);
		BufferedImage myTestImageBlue1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}

	@Test
	// test blue of 2.bmp
	public void testBlue2() throws IOException {
		Image imageBlue2 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/2.bmp");

		Image blue2 = processor.showChanelB(imageBlue2);

		FileInputStream testFileBlue2 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/2_blue_goal.bmp");
		BufferedImage testImageBlue2 = ImageIO.read(testFileBlue2);

		int w = blue2.getWidth(null);
		int h = blue2.getHeight(null);
		BufferedImage myTestImageBlue2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageBlue2.getGraphics().drawImage(blue2, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageBlue2.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue2.getHeight(null); j++) {
				assertEquals(testImageBlue2.getRGB(i, j), myTestImageBlue2.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue2.getWidth(null), testImageBlue2.getWidth(null));
		assertEquals(blue2.getHeight(null), testImageBlue2.getHeight(null));
	}

	@Test
	// test green of 1.bmp
	public void testGreen1() throws IOException {
		Image imageGreen1 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/1.bmp");

		Image green1 = processor.showChanelG(imageGreen1);

		FileInputStream testFileGreen1 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/1_green_goal.bmp");
		BufferedImage testImageGreen1 = ImageIO.read(testFileGreen1);

		int w = green1.getWidth(null);
		int h = green1.getHeight(null);
		BufferedImage myTestImageGreen1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageGreen1.getGraphics().drawImage(green1, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageGreen1.getWidth(null); i++) {
			for (int j = 0; j < testImageGreen1.getHeight(null); j++) {
				assertEquals(testImageGreen1.getRGB(i, j), myTestImageGreen1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(green1.getWidth(null), testImageGreen1.getWidth(null));
		assertEquals(green1.getHeight(null), testImageGreen1.getHeight(null));
	}

	@Test
	// test green of 2.bmp
	public void testGreen2() throws IOException {
		Image imageGreen2 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/2.bmp");

		Image green2 = processor.showChanelG(imageGreen2);

		FileInputStream testFileGreen2 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/2_green_goal.bmp");
		BufferedImage testImageGreen2 = ImageIO.read(testFileGreen2);

		int w = green2.getWidth(null);
		int h = green2.getHeight(null);
		BufferedImage myTestImageGreen2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageGreen2.getGraphics().drawImage(green2, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageGreen2.getWidth(null); i++) {
			for (int j = 0; j < testImageGreen2.getHeight(null); j++) {
				assertEquals(testImageGreen2.getRGB(i, j), myTestImageGreen2.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(green2.getWidth(null), testImageGreen2.getWidth(null));
		assertEquals(green2.getHeight(null), testImageGreen2.getHeight(null));
	}

	@Test
	// test red of 1.bmp
	public void testRed1() throws IOException {
		Image imageRed1 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/1.bmp");

		Image red1 = processor.showChanelR(imageRed1);

		FileInputStream testFileRed1 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/1_red_goal.bmp");
		BufferedImage testImageRed1 = ImageIO.read(testFileRed1);

		int w = red1.getWidth(null);
		int h = red1.getHeight(null);
		BufferedImage myTestImageRed1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageRed1.getGraphics().drawImage(red1, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageRed1.getWidth(null); i++) {
			for (int j = 0; j < testImageRed1.getHeight(null); j++) {
				assertEquals(testImageRed1.getRGB(i, j), myTestImageRed1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(red1.getWidth(null), testImageRed1.getWidth(null));
		assertEquals(red1.getHeight(null), testImageRed1.getHeight(null));
	}

	@Test
	// test red of 2.bmp
	public void testRed2() throws IOException {
		Image imageRed2 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/2.bmp");

		Image red2 = processor.showChanelR(imageRed2);

		FileInputStream testFileRed2 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/2_red_goal.bmp");
		BufferedImage testImageRed2 = ImageIO.read(testFileRed2);

		int w = red2.getWidth(null);
		int h = red2.getHeight(null);
		BufferedImage myTestImageRed2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageRed2.getGraphics().drawImage(red2, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageRed2.getWidth(null); i++) {
			for (int j = 0; j < testImageRed2.getHeight(null); j++) {
				assertEquals(testImageRed2.getRGB(i, j), myTestImageRed2.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(red2.getWidth(null), testImageRed2.getWidth(null));
		assertEquals(red2.getHeight(null), testImageRed2.getHeight(null));
	}

	@Test
	// test gray of 1.bmp
	public void testGray1() throws IOException {
		Image imageGray1 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/1.bmp");

		Image gray1 = processor.showGray(imageGray1);

		FileInputStream testFileGray1 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/1_gray_goal.bmp");
		BufferedImage testImageGray1 = ImageIO.read(testFileGray1);

		int w = gray1.getWidth(null);
		int h = gray1.getHeight(null);
		BufferedImage myTestImageGray1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageGray1.getGraphics().drawImage(gray1, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageGray1.getWidth(null); i++) {
			for (int j = 0; j < testImageGray1.getHeight(null); j++) {
				assertEquals(testImageGray1.getRGB(i, j), myTestImageGray1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(gray1.getWidth(null), testImageGray1.getWidth(null));
		assertEquals(gray1.getHeight(null), testImageGray1.getHeight(null));
	}

	@Test
	// test gray of 2.bmp
	public void testGray2() throws IOException {
		Image imageGray2 = myImage.myRead("/home/administrator/workspace/ImageProcessing/goal/2.bmp");

		Image gray2 = processor.showGray(imageGray2);

		FileInputStream testFileGray2 = new FileInputStream("/home/administrator/workspace/ImageProcessing/goal/2_gray_goal.bmp");
		BufferedImage testImageGray2 = ImageIO.read(testFileGray2);

		int w = gray2.getWidth(null);
		int h = gray2.getHeight(null);
		BufferedImage myTestImageGray2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageGray2.getGraphics().drawImage(gray2, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageGray2.getWidth(null); i++) {
			for (int j = 0; j < testImageGray2.getHeight(null); j++) {
				assertEquals(testImageGray2.getRGB(i, j), myTestImageGray2.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(gray2.getWidth(null), testImageGray2.getWidth(null));
		assertEquals(gray2.getHeight(null), testImageGray2.getHeight(null));
	}
}