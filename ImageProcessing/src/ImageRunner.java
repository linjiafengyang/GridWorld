import imagereader.Runner;

public final class ImageRunner {
	private ImageRunner() {}
	public static void main(String[] args) {
		myImageIO imageioer = new myImageIO();
		myImageProcessor processor = new myImageProcessor();
		Runner.run(imageioer, processor);
	}
}