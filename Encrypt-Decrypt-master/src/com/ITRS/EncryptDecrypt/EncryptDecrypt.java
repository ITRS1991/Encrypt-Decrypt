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
		private JMenuBar jb;// �˵���
		private JMenu m1,m2,m3;// �˵�
		private JMenuItem m1_1, m1_2,m2_1,m3_1;// �˵���
		private JLabel jl,bq;
		private JTextField jt;
		private JButton jbutton;
		private FileDialog fd;
		private File file1 = null;
		private JTextArea jta1, jta2;
		// һ��������ʹ��JTextArea����Ҫ����JScrollPane
		private JScrollPane jsp1, jsp2;
		// ȡ����Ļ�Ŀ��
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// ȡ����Ļ�ĸ߶�
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		public EncryptDecrypt()
		{
			jb = new JMenuBar();

			m1 = new JMenu("�ļ�");
			m2 = new JMenu("��ϵ");
			m3 = new JMenu("����");

			m1_1 = new JMenuItem("��");
			m1_2 = new JMenuItem("����");
			m2_1 = new JMenuItem("��ϵ");
			m3_1 = new JMenuItem("����");

			jl = new JLabel("�ļ�����");
			jt = new JTextField();
			
			bq = new JLabel("Copyright @ 2017  ������ʿ--����ƽ");
			
			jbutton = new JButton("�������");

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
			
			//����
			jb.add(m1);
			jb.add(m2);
			jb.add(m3);
			m1.add(m1_1);
			m1.add(m1_2);
			m2.add(m2_1);
			m3.add(m3_1);
			
			//�����
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

			// ����
			this.setTitle("TXT�ĵ����ݼ���V1.0--������ð�");
			// �����С�;���
			this.setBounds((width - 700) / 2, (height - 600) / 2, 700, 600);
			// ������ı��С
			this.setResizable(false);
			// ���ڹر��˳�����
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			// �����ò���
			this.setLayout(null);
			// �Ƿ���ʾ
			this.setVisible(true);
		}

		public void actionPerformed(ActionEvent c)
		{
			// ����������i1
			if (c.getSource() == m1_1)
			{
				fd = new FileDialog(this, "��ѡ��򿪵��ļ�", FileDialog.LOAD);
				fd.setVisible(true); // ��������ʾ���ļ��Ի���
				if ((fd.getDirectory() != null) && (fd.getFile() != null))// ·�����ı����ݶ���Ϊ��
				{
					jt.setText(fd.getFile());// ���ı�������ʾ�ļ���
					try
					{
						// �Ի�������ʽ��ȡ�ļ�����
						file1 = new File(fd.getDirectory(), fd.getFile());
						FileReader fr = new FileReader(file1);
						BufferedReader br = new BufferedReader(fr);
						String aline;
						while ((aline = br.readLine()) != null){
							// ���ж�ȡ�ı���append������׷��
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
				fd = new FileDialog(this, "��ѡ�񱣴��·��", FileDialog.SAVE);
				if (file1 == null)
				{
					fd.setFile("*.txt");
				} else
				{
					fd.setFile(file1.getName());
				}
				fd.setVisible(true); // ��������ʾ�����ļ��Ի���
				if ((fd.getDirectory() != null) && (fd.getFile() != null))
				{
					file1 = new File(fd.getDirectory(), fd.getFile());
					save(file1);
					jt.setText(fd.getFile());// ���ı�������ʾ�ļ���
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
				JOptionPane.showMessageDialog(this,"�绰��15638800289\nQQ��1257142154\n΢�ţ�fan19910114");
			}
			if (c.getSource() == m3_1)
			{
				JOptionPane.showMessageDialog(this,"����&���ܣ��ļ� \' ��\n���棺�ļ� \' ����(�����Ҳ��ı�������)");
			}
		}

		public void save(File file12)
		{
			try
			{
				// ���ı�������д���ַ������
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


