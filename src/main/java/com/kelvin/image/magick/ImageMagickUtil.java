package com.kelvin.image.magick;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageMagickUtil {

	public static void resize(String src, String dest, int width, int height, int quality) {

		// 命令
		List<String> commandList = new ArrayList<>();
		commandList.add("convert");
		commandList.add("-resize");
		commandList.add(width + "X" + height + ">");
		if (quality != 0) {
			commandList.add("-quality");
			commandList.add(quality + "%");
		}
		commandList.add(src);
		commandList.add(dest);

		Process p = null;
		try {
			p = new ProcessBuilder(commandList).start();
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (p != null) {
				p.destroy();
			}
		}

	}

	public static void main(String[] args) {
		resize("/root/uploadImage/cat.jpg", "/root/uploadImage/cat2.jpg", 800, 400, 0);
	}

}
