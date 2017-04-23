import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

import imagereader.IImageProcessor;

public class myImageProcessor implements IImageProcessor {
	// 提取并显示彩色图像的红色通道
	public Image showChanelR(Image image) {
		colorFilter red = new colorFilter(0);
		return Toolkit.getDefaultToolkit().createImage(
			new FilteredImageSource(image.getSource(), red));
	}
	// 提取并显示彩色图像的绿色通道
	public Image showChanelG(Image image) {
		colorFilter green = new colorFilter(1);
		return Toolkit.getDefaultToolkit().createImage(
			new FilteredImageSource(image.getSource(), green));
	}
	// 提取并显示彩色图像的蓝色通道
	public Image showChanelB(Image image) {
		colorFilter blue = new colorFilter(2);
		return Toolkit.getDefaultToolkit().createImage(
			new FilteredImageSource(image.getSource(), blue));
	}
	// 读取彩色图像并转换成灰度图像
	public Image showGray(Image image) {
		colorFilter gray = new colorFilter(3);
		return Toolkit.getDefaultToolkit().createImage(
			new FilteredImageSource(image.getSource(), gray));
	}
}
class colorFilter extends RGBImageFilter {
	private int colorNum;

	public colorFilter(int num) {
		colorNum = num;
	}
	public int filterRGB(int x, int y, int rgb) {
		if (colorNum == 0) {
			// 返回红色通道
			return rgb & 0xffff0000;
		}
		else if (colorNum == 1) {
			// 返回绿色通道
			return rgb & 0xff00ff00;
		}
		else if (colorNum == 2) {
			// 返回蓝色通道
			return rgb & 0xff0000ff;
		}
		else {
			// 将彩色图像转换成灰度图
			int gray = (int)( ((rgb & 0x00ff0000) >> 16) * 0.299 
				+ ((rgb & 0x0000ff00) >> 8) * 0.587 
				+ (rgb & 0x000000ff) * 0.114 );
			return (rgb & 0xff000000) + (gray << 16) + (gray << 8) + gray;
		}
	}
}