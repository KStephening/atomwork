package com.longer.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @program: test
 * @description: 颜色选择器
 * @author: PuTao
 * @create: 2018-09-16 15:38
 **/
public class ColorChoose {
	public static void main(String[] args){
		JColorChooser colorChooser = new JColorChooser();
		JFrame jFrame = new JFrame();

		JColorChooser.showDialog(jFrame, "color choose", Color.red);
	}
}
