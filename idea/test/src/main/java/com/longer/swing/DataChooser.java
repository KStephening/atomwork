package com.longer.swing;

import com.sunking.swing.JDatePicker;

import javax.swing.*;

/**
 * @program: test
 * @description: 日期选择器
 * @author: PuTao
 * @create: 2018-09-17 17:02
 **/
public class DataChooser {
	public static void main(String[] args){
		JPanel panel= FrameUniversal.init("日期选择","日期");

		JDatePicker datePicker = new JDatePicker(
				JDatePicker.STYLE_CN_DATE1);
		panel.add(datePicker);
	}

}
