import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import imagereader.IImageIO;

public class myImageIO implements IImageIO {
	// 位图头字节
	private static final int HEAD_BYTE = 14;
	// 位图信息字节
	private static final int INFO_BYTE = 40;
	private static final int FOUR_BYTE = 4;
	// 彩色直
	private static final int MULTICOLOR = 24;
	// 保存每个像素的位数
	private int bitCount;

	// 根据文件路径读取图片
	public Image myRead(String filepath) throws IOException {
		// obtains input bytes from a file
		FileInputStream file = new FileInputStream(filepath);
		// 新建两个数组来存储位图头和位图信息
		byte bmpHead[] = new byte[HEAD_BYTE];
		byte bmpInfo[] = new byte[INFO_BYTE];
		// 位图宽度、高度、原始图像大小、空子节数、偏移、像素大小
		int widthOfbmpInfo, heightOfbmpInfo, sizeOfbmpInfo, numOfEmptyByte, pixelSize;
		Image image = null;
		byte totalByte[];
		int pixelArray[];

		try {
			file.read(bmpHead, 0, HEAD_BYTE);
			file.read(bmpInfo, 0, INFO_BYTE);


			// 保存位图宽度(以像素个数表示)
			widthOfbmpInfo = (int)( (bmpInfo[7] & 0xff) << 24 | (bmpInfo[6] & 0xff) << 16 
				| (bmpInfo[5] & 0xff) << 8 | (bmpInfo[4] & 0xff) );

			// 保存位图高度(以像素个数表示)
			heightOfbmpInfo = (int)( (bmpInfo[11] & 0xff) << 24 | (bmpInfo[10] & 0xff) << 16 
				| (bmpInfo[9] & 0xff) << 8 | (bmpInfo[8] & 0xff) );

			// 保存图像大小。这是原始(:en:raw)位图数据的大小，不要与文件大小混淆。
			sizeOfbmpInfo = (int)( (bmpInfo[23] & 0xff) << 24 | (bmpInfo[22] & 0xff) << 16 
				| (bmpInfo[21] & 0xff) << 8 | (bmpInfo[20] & 0xff) );

			// 保存每个像素的位数，它是图像的颜色深度。常用值是1、4、8(灰阶)和24(彩色)。
			bitCount = (int)( (bmpInfo[15] & 0xff) << 8 | (bmpInfo[14] & 0xff) );
			// 彩色
			if (bitCount == MULTICOLOR) {
				// 由于像素使用的字节若不是4的倍数，则会自动扩大，
				// 由此产生空白。因此我们需要在一开始计算出空白的大小 
				numOfEmptyByte = (sizeOfbmpInfo / heightOfbmpInfo) - widthOfbmpInfo * 3;
				if (numOfEmptyByte == FOUR_BYTE) {
					numOfEmptyByte = 0;
				}

				// 计算pixel大小
				pixelSize = 3 * (widthOfbmpInfo + numOfEmptyByte) * heightOfbmpInfo;

				if (numOfEmptyByte != 0) {
					totalByte = new byte[pixelSize];
				}
				else {
					totalByte = new byte[sizeOfbmpInfo];
				}

				// 读取所有RGB数据
				file.read(totalByte, 0, pixelSize);
				pixelArray = new int[widthOfbmpInfo * heightOfbmpInfo];
				// pixelArray赋值
				int index = 0;
				for (int j = 0; j < heightOfbmpInfo; j++) {
					for (int i = 0; i < widthOfbmpInfo; i++) {
						// 第一个0xff << 24表示透明度 
						pixelArray[widthOfbmpInfo * (heightOfbmpInfo - j - 1) + i] = 
							(0xff << 24) 
							| (totalByte[index + 2] & 0xff) << 16 
							| (totalByte[index + 1] & 0xff) << 8 
							| (totalByte[index] & 0xff);
						index += 3;
					}
					index += numOfEmptyByte;
				}
				// 构建图片
				image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(
					widthOfbmpInfo, heightOfbmpInfo, pixelArray, 0, widthOfbmpInfo));
			}
			// 关闭file
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// 返回图片
		return image;
	}

	// 保存图片
	public Image myWrite(Image image, String file) throws IOException {
		try {
			int height = image.getHeight(null);
			int width = image.getWidth(null);
			// 图片类型
			int fileType;

			if (bitCount == MULTICOLOR) {
				fileType = BufferedImage.TYPE_3BYTE_BGR;
			}
			else {
				fileType = BufferedImage.TYPE_BYTE_GRAY;
			}

			// 创建图片
			BufferedImage bmp = new BufferedImage(width, height, fileType);
			bmp.getGraphics().drawImage(image, 0, 0, null);
			// 根据文件名创建文件
			File afile = new File(file + ".bmp");
			// 保存图片
			ImageIO.write(bmp, "bmp", afile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}