package com.Dmeo.myspce;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.undo.UndoManager;

/**
 * 简易记事本
 * 
 * @author luotuan
 *
 */
public class MyNotepad implements ActionListener {
	// 文件选择器
	private JFileChooser jfc;
	private String fielDiretory;// 打开文本的地址
	private JFrame jf = new JFrame("简易记事本");// 记事本主页面
	private JTextArea jta = new AreaRightMenu();// 记事本,显示纯文本的多行区域
	private ImageIcon icon = new ImageIcon("book.png");
	String[] menuLabel = { "文件", "编辑", "帮助" };
	String[][] miLabel = { { "新建", "打开", "保存", "另存为", "退出" },
			{ "撤销", "剪切", "复制", "粘贴", " 删除", "", "查找", "替换", "", "全选" }, { "关于记事本" } };

	public MyNotepad() {
		JMenuBar jmb = new JMenuBar();
		for (int i = 0; i < menuLabel.length; i++) {
			JMenu jm = new JMenu(menuLabel[i]);
			jmb.add(jm);
			for (int j = 0; j < miLabel[i].length; j++) {
				if ("".equals(miLabel[i][j])) {
					jm.addSeparator();
				} else {
					JMenuItem jmi = new JMenuItem(miLabel[i][j]);
					if ("保存".equals(jmi.getText())) {
						jmi.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));// 设置保存快捷键
					}
					jm.add(jmi);
					jmi.addActionListener(this);
				}
			}
		}
		jf.setJMenuBar(jmb);// JFrame加菜单栏时用setJmenuBar(),不用add
		jf.add(new JScrollPane(jta));// 加滚动条
		jf.setLocation(100, 10);// 设计出现的位置
		jf.setSize(1200, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();// 获取点击按钮
		if ("新建".equals(comm)) {
			jta.setText("");
		} else if ("打开".equals(comm)) {
			readFile();// 载入文件
		} else if ("退出".equals(comm)) {
			System.exit(0);// 退出
		} else if ("保存".equals(comm)) {
			saveFile(fielDiretory);
		} else if ("另存为".equals(comm)) {
			saveAs();
		} else if ("关于记事本".equals(comm)) {
			aboutText();
		}
	}

	/**
	 * 关于记事本
	 */
	public void aboutText() {
		JFrame frame = new JFrame("关于笔记本");
		frame.setLocation(150, 100);
		frame.setSize(400, 200);
		frame.setVisible(true);
		JTextArea area = new JTextArea();
		area.setText("       这是一个简易的记事本@by bruce");
		area.setFont(new Font("宋体", Font.PLAIN, 14));
		area.setEditable(false);
		frame.add(area);
		JPanel panel = new JPanel();
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setSize(100, 50);
		panel.add(button);
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
	}

	/**
	 * 读取打开的文本
	 * 
	 * @param file
	 */
	public void readFile() {
		FileDialog fd = new FileDialog(jf, "请选择文件", FileDialog.LOAD);
		fd.setVisible(true);
		String direct = fd.getDirectory();// 获取目录
		String fileName = fd.getFile();// 获取文件名
		jf.setTitle(fileName);
		fielDiretory = direct + fileName;
		jta.setText("");
		File f = new File(fielDiretory);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));// 目标文件
			String readLine = br.readLine();
			while (readLine != null) {
				jta.append(readLine + "\n");
				readLine = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 保存读取的文本
	 * 
	 * @param args
	 */
	public void saveFile(String fielDiretory) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File(fielDiretory));
			bw = new BufferedWriter(fw);
			String[] s = this.jta.getText().split("\n");
			for (int i = 0; i < s.length; i++) {
				bw.write(s[i] + "\r\n");
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 另存为
	 * 
	 * @param args
	 */
	public void saveAs() {
		// 新文件
		File newFile = null;
		jfc = new JFileChooser();
		// 添加过滤器
		addFilter();
		jfc.setDialogTitle("另存为");
		int resultVal = jfc.showSaveDialog(null);
		jfc.setVisible(true);
		switch (resultVal) {
		case JFileChooser.APPROVE_OPTION:
			// 获得被选中的过滤器
			MyFileFilter filter = (MyFileFilter) jfc.getFileFilter();
			// 获取过滤器的后缀
			String ends = filter.getEnds();
			File saveAsFileName = jfc.getSelectedFile().getAbsoluteFile();

			if (saveAsFileName.getAbsolutePath().toUpperCase().endsWith(ends.toUpperCase())) {
				newFile = saveAsFileName;
			} else {
				newFile = new File(saveAsFileName.getAbsolutePath() + ends);
			}
			System.out.println("保存文件的路径是" + newFile.getAbsolutePath());
			this.saveFile(newFile.getAbsolutePath());
			break;
		case JFileChooser.CANCEL_OPTION:
			System.out.println("退出保存文件选择框");

			break;
		case JFileChooser.ERROR_OPTION:
			System.out.println("保存文件出错");
			break;
		default:
			break;
		}
	}

	/**
	 * 为jtc设置文件过滤器
	 */
	public void addFilter() {
		// 设置多个文件过滤器
		FileFilter txtFilter = new MyFileFilter(".txt", "文本文档 (*.txt)");
		FileFilter docFilter = new MyFileFilter(".doc", "word文档 (*.doc)");
		FileFilter htmlFilter = new MyFileFilter(".html", "html文档 (*.html)");
		jfc.addChoosableFileFilter(txtFilter);
		jfc.addChoosableFileFilter(docFilter);
		jfc.addChoosableFileFilter(htmlFilter);
	}

	public static void main(String[] args) {
		new MyNotepad();
	}

	/**
	 * 含右键菜单的JTextArea
	 * 
	 * @author admin
	 *
	 */
	class AreaRightMenu extends JTextArea implements MouseListener {

		private static final long serialVersionUID = 1L;
		private UndoManager um = new UndoManager();// 撤销管理类
		private JPopupMenu pop = null; // 弹出菜单
		private JMenuItem copy = null, paste = null, cut = null, selectAll = null, revoke = null, delete = null; // 功能菜单

		public AreaRightMenu() {
			super(10, 20);// 10行20列的排布
			setFont(new Font("宋体", Font.PLAIN, 16));// 设置字体和大小
			setCaretColor(Color.RED);// 设置光标颜色
			setSelectedTextColor(Color.BLUE);// 设置选中颜色
			this.getDocument().addUndoableEditListener(new UndoableEditListener() {

				@Override
				public void undoableEditHappened(UndoableEditEvent e) {
					um.addEdit(e.getEdit());
				}
			});
			init();
		}

		/**
		 * 绑定功能菜单
		 */
		private void init() {
			this.addMouseListener(this);
			pop = new JPopupMenu();// 右键菜单
			pop.setPopupSize(new Dimension(100, 150));

			// 关联右键菜单项
			pop.add(copy = new JMenuItem("复制(C)"));
			pop.add(paste = new JMenuItem("粘贴(V)"));
			pop.add(cut = new JMenuItem("剪切(X)"));
			pop.add(delete = new JMenuItem("删除(D)"));
			pop.add(selectAll = new JMenuItem("全选(A)"));
			pop.add(revoke = new JMenuItem("撤销(Z)"));
			// 设置快捷键
			copy.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
			paste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
			cut.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_MASK));
			selectAll.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_MASK));
			delete.setAccelerator(KeyStroke.getKeyStroke('D', InputEvent.CTRL_MASK));
			revoke.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_MASK));
			copy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					action(e);
				}
			});
			paste.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					action(e);
				}
			});
			cut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					action(e);
				}
			});
			selectAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					action(e);
				}
			});
			revoke.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					um.undo();
				}
			});
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					action(e);
				}
			});
			this.add(pop);
		}

		/**
		 * 菜单动作
		 * 
		 * @param e
		 */
		public void action(ActionEvent e) {
			String str = e.getActionCommand();
			if (str.equals(copy.getText())) { // 复制
				this.copy();
			} else if (str.equals(paste.getText())) { // 粘贴
				this.paste();
			} else if (str.equals(cut.getText())) { // 剪切
				this.cut();
			} else if (str.equals(selectAll.getText())) {
				this.selectAll();// 全选
			} else if (str.equals(delete.getText())) {// 删除
				this.replaceSelection("");
			} else if (str.equals(revoke.getText())) {// 撤销
				um = new UndoManager();
				this.getDocument().addUndoableEditListener(new UndoableEditListener() {

					@Override
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
			}
		}

		public JPopupMenu getPop() {
			return pop;
		}

		public void setPop(JPopupMenu pop) {
			this.pop = pop;
		}

		/**
		 * 剪切板中是否有文本数据可供粘贴
		 *
		 * @return true为有文本数据
		 */
		public boolean isClipboardString() {
			boolean b = false;
			Clipboard clipboard = this.getToolkit().getSystemClipboard();
			Transferable content = clipboard.getContents(this);
			try {
				if (content.getTransferData(DataFlavor.stringFlavor) instanceof String) {
					b = true;
				}
			} catch (Exception e) {
			}
			return b;
		}

		/**
		 * 文本组件中是否具备复制的条件
		 *
		 * @return true为具备
		 */
		public boolean isCanCopy() {
			boolean b = false;
			int start = this.getSelectionStart();
			int end = this.getSelectionEnd();
			if (start != end)
				b = true;
			return b;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				copy.setEnabled(isCanCopy());
				paste.setEnabled(isClipboardString());
				cut.setEnabled(isCanCopy());
				selectAll.setEnabled(isClipboardString());
				revoke.setEnabled(isCanCopy());
				delete.setEnabled(isCanCopy());
				pop.show(this, e.getX(), e.getY());
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}

/**
 * 文件过滤器
 * 
 * @author admin
 *
 */
class MyFileFilter extends FileFilter {

	String ends; // 文件后缀
	String description; // 文件描述文字

	public MyFileFilter(String ends, String description) { // 构造函数
		this.ends = ends; // 设置文件后缀
		this.description = description; // 设置文件描述文字
	}

	@Override
	// 只显示符合扩展名的文件，目录全部显示
	public boolean accept(File file) {
		if (file.isDirectory())
			return true;
		String fileName = file.getName();
		if (fileName.toUpperCase().endsWith(this.ends.toUpperCase()))
			return true;
		return false;
	}

	@Override
	// 返回这个扩展名过滤器的描述
	public String getDescription() {
		return this.description;
	}

	// 返回这个扩展名过滤器的扩展名
	public String getEnds() {
		return this.ends;
	}
}
