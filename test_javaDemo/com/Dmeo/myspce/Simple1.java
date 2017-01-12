package com.Dmeo.myspce;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Simple1 {
	private static JFrame frame; // 定义为静态变量以便main使用
	private static JPanel myPanel; // 该面板用来放置按钮组件
	private JButton button1; // 这里定义按钮组件
	private JButton button2; // 以便让ActionListener使用

	public Simple1() {
		// 新建面板
		myPanel = new JPanel();
		// 新建按钮
		button1 = new JButton("按钮1"); // 新建按钮1
		button2 = new JButton("按钮2");

		SimpleListener ourListener = new SimpleListener();
		// 建立一个actionlistener让两个按钮共享
		button1.addActionListener(ourListener);
		button2.addActionListener(ourListener);

		myPanel.add(button1); // 添加按钮到面板
		myPanel.add(button2);
	}

	private class SimpleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("按钮1")) {
				JOptionPane.showMessageDialog(frame, "按钮1 被点击");
			} else if (buttonName.equals("按钮2")) {
				JOptionPane.showMessageDialog(frame, "按钮2被点击");
			} else {
				JOptionPane.showMessageDialog(frame, "Unknown event");
			}
		}

	}

	public static void main(String[] args) {
		Simple1 simple1 = new Simple1();
		frame = new JFrame("simple1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}
}
