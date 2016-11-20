package com.ITRS.EncryptDecrypt;
	import java.awt.FileDialog;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JButton;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.JOptionPane;

	@SuppressWarnings("serial")
	public class EncryptDecrypt extends JFrame implements ActionListener
	{
		private JMenuBar jb;// 菜单条
		private JMenu m1,m2,m3;// 菜单
		private JMenuItem m1_1, m1_2,m2_1,m3_1;// 菜单项
		private JLabel jl,bq;
		private JTextField jt;
		private JButton jbutton;
		private FileDialog fd;
		private File file1 = null;
		private JTextArea jta1, jta2;
		// 一般我们在使用JTextArea，都要加入JScrollPane
		private JScrollPane jsp1, jsp2;
		// 取得屏幕的宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 取得屏幕的高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		public EncryptDecrypt()
		{
			jb = new JMenuBar();

			m1 = new JMenu("文件");
			m2 = new JMenu("联系");
			m3 = new JMenu("帮助");

			m1_1 = new JMenuItem("打开");
			m1_2 = new JMenuItem("保存");
			m2_1 = new JMenuItem("联系");
			m3_1 = new JMenuItem("帮助");

			jl = new JLabel("文件名：");
			jt = new JTextField();
			
			bq = new JLabel("Copyright @ 2017  爱梯人士--范亚平");
			
			jbutton = new JButton("清空数据");

			jta1 = new JTextArea(20, 15);
			jta2 = new JTextArea(20, 15);
			jsp1 = new JScrollPane(jta1);
			jsp2 = new JScrollPane(jta2);

			jl.setBounds(60, 50, 60, 20);//(x,y,width,height)
			jt.setBounds(110, 50, 150, 20);
			bq.setBounds(240, 520, 300, 20);
			
			jbutton.setBounds(450, 50, 100, 20);

			jsp1.setBounds(20, 100, 300, 400);
			jsp2.setBounds(360, 100, 300, 400);

			this.setJMenuBar(jb);
			
			//导航
			jb.add(m1);
			jb.add(m2);
			jb.add(m3);
			m1.add(m1_1);
			m1.add(m1_2);
			m2.add(m2_1);
			m3.add(m3_1);
			
			//主面板
			//this.add(m2);
			//this.add(m3);
			this.add(jl);
			this.add(jt);
			this.add(bq);
			this.add(jbutton);
			this.add(jsp1);
			this.add(jsp2);

			m1_1.addActionListener(this);
			m1_2.addActionListener(this);
			m2_1.addActionListener(this);
			m3_1.addActionListener(this);
			
			jbutton.addActionListener(this);

			// 标题
			this.setTitle("TXT文档内容加密V1.0--免费试用版");
			// 窗体大小和剧中
			this.setBounds((width - 700) / 2, (height - 600) / 2, 700, 600);
			// 不允许改变大小
			this.setResizable(false);
			// 窗口关闭退出程序
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			// 不采用布局
			this.setLayout(null);
			// 是否显示
			this.setVisible(true);
		}

		public void actionPerformed(ActionEvent c)
		{
			// 如果点击的是i1
			if (c.getSource() == m1_1)
			{
				fd = new FileDialog(this, "请选择打开的文件", FileDialog.LOAD);
				fd.setVisible(true); // 创建并显示打开文件对话框
				if ((fd.getDirectory() != null) && (fd.getFile() != null))// 路径和文本内容都不为空
				{
					jt.setText(fd.getFile());// 在文本框里显示文件名
					try
					{
						// 以缓冲区方式读取文件内容
						file1 = new File(fd.getDirectory(), fd.getFile());
						FileReader fr = new FileReader(file1);
						BufferedReader br = new BufferedReader(fr);
						String aline;
						while ((aline = br.readLine()) != null){
							// 按行读取文本，append方法是追加
							jta1.append(aline + "\r\n");
							jta2.append(EncryptDecrypt.EAndU(aline, 'f' ,'y')+"\r\n");
						}
						fr.close();
						br.close();
					} catch (IOException ioe)
					{
						System.out.println(ioe);
					}
				}

			}
			if (c.getSource() == m1_2)
			{
				fd = new FileDialog(this, "请选择保存的路径", FileDialog.SAVE);
				if (file1 == null)
				{
					fd.setFile("*.txt");
				} else
				{
					fd.setFile(file1.getName());
				}
				fd.setVisible(true); // 创建并显示保存文件对话框
				if ((fd.getDirectory() != null) && (fd.getFile() != null))
				{
					file1 = new File(fd.getDirectory(), fd.getFile());
					save(file1);
					jt.setText(fd.getFile());// 在文本框里显示文件名
				}
			}
			if (c.getSource() == jbutton)
			{
				jt.setText("");
				jta1.setText("");
				jta2.setText("");
			}
			if (c.getSource() == m2_1)
			{
				JOptionPane.showMessageDialog(this,"电话：15638800289\nQQ：1257142154\n微信：fan19910114");
			}
			if (c.getSource() == m3_1)
			{
				JOptionPane.showMessageDialog(this,"加密&解密：文件 \' 打开\n保存：文件 \' 保存(保存右侧文本框内容)");
			}
		}

		public void save(File file12)
		{
			try
			{
				// 将文本区内容写入字符输出流
				FileWriter fw = new FileWriter(file1);
				fw.write(jta2.getText());
				fw.close();
				jt.setText("");
				jta1.setText("");
				jta2.setText("");
			} catch (IOException ioe)
			{
				System.out.println(ioe);
			}
		}
		
		public static String EAndU(String value,char secret,char secret1){
			byte[] bt = value.getBytes();
			for(int i=0;i<bt.length;i++){
				bt[i]=(byte)(bt[i]^(int)secret^(int)secret1);
			}
			return new String(bt,0,bt.length);
		}

		public static void main(String[] args)
		{
			new EncryptDecrypt();
		}
	}


