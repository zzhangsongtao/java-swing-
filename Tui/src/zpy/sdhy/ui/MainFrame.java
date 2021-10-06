package zpy.sdhy.ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MainFrame extends Frame implements KeyListener {
	private JLabel lab_tank;
	// 1����שͷ 4 ����tree
	private int[][] maps = {

			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 8, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 8, 1 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 8, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

	};
	private int ty;
	private int tx;
	// ������ɼ�����
	int num = 0;
	// �����������
	int total = 3;
	JLabel[][] sheeps = new JLabel[13][17];

	public MainFrame() {
		// �������
		// inPutlaolong();
		// ������˹�
		tankInPut();
		// ����ϰ�
		zhuanInPut();
		// ����� ������
		inPutYang();
		// ���ô��ڱ���
		backgroundInit();
		// ���û�����������
		setMainFrameUI();

		// ���ü���
		this.addKeyListener(this);
	}

	private void inPutlaolong() {
		// TODO Auto-generated method stub
		Icon i = new ImageIcon("laolong.png");
		// ʹ��JLabel����
		JLabel lab_lao1 = new JLabel(i);
		// ����ͼƬҪ��ʾ��λ��
		lab_lao1.setBounds(20 + 50 * 15, 60 + 50 * 4, 50, 50);
		// ��ӵ�����
		this.add(lab_lao1);
		maps[4][15] = 8;

		// ʹ��JLabel����
		JLabel lab_lao2 = new JLabel(i);
		// ����ͼƬҪ��ʾ��λ��
		lab_lao2.setBounds(20 + 50 * 15, 60 + 50 * 5, 50, 50);
		// ��ӵ�����
		this.add(lab_lao2);
		maps[5][15] = 8;

		// ʹ��JLabel����
		JLabel lab_lao3 = new JLabel(i);
		// ����ͼƬҪ��ʾ��λ��
		lab_lao3.setBounds(20 + 50 * 15, 60 + 50 * 6, 50, 50);
		// ��ӵ�����
		this.add(lab_lao3);
		maps[6][15] = 8;
	}

	private void inPutYang() {
		// TODO Auto-generated method stub
		// ����һ��ͼƬ
		Icon i = new ImageIcon("yang.png");
		// ʹ��JLabel����
		JLabel lab_sheep1 = new JLabel(i);
		// ����ͼƬҪ��ʾ��λ��
		lab_sheep1.setBounds(20 + 50 * 6, 60 + 50 * 4, 50, 50);
		// ��ӵ�����
		this.add(lab_sheep1);
		maps[4][6] = 4;
		sheeps[4][6] = lab_sheep1;

		JLabel lab_sheep2 = new JLabel(i);
		// ����ͼƬҪ��ʾ��λ��
		lab_sheep2.setBounds(20 + 50 * 6, 60 + 50 * 6, 50, 50);
		// ��ӵ�����
		this.add(lab_sheep2);
		maps[6][6] = 4;
		sheeps[6][6] = lab_sheep2;
		JLabel lab_sheep3 = new JLabel(i);
		// ����ͼƬҪ��ʾ��λ��
		lab_sheep3.setBounds(20 + 50 * 6, 60 + 50 * 8, 50, 50);
		// ��ӵ�����
		this.add(lab_sheep3);
		maps[8][6] = 4;
		sheeps[8][6] = lab_sheep3;
	}

	private void zhuanInPut() {
		// TODO Auto-generated method stub
		Icon ic = new ImageIcon("tree.png");
		Icon l = new ImageIcon("laolong.png");
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length; j++) {
				if (maps[i][j] == 8) {
					// ʹ��JLabel����
					JLabel lab_lao1 = new JLabel(l);
					// ����ͼƬҪ��ʾ��λ��
					lab_lao1.setBounds(20 + 50 * j, 60 + 50 * i, 50, 50);
					// ��ӵ�����
					this.add(lab_lao1);
					// maps[i][j]=8;
				}
				// �ж�һ��ԭʼ���������ֵ�����1�����ϰ�
				if (maps[i][j] == 1) {
					// �ϰ��ĳ�ʼ��
					// 2.����JLabel
					JLabel lab_tree = new JLabel(ic);
					// 3.���ô�Сλ��
					lab_tree.setBounds(20 + 50 * j, 60 + 50 * i, 50, 50);
					// 4.��ӵ�������
					this.add(lab_tree);
				}

			}
		}
	}

	private void tankInPut() {
		tx = 1;
		ty = 1;
		// TODO Auto-generated method stub
		Icon i = new ImageIcon("down.png");
		lab_tank = new JLabel(i);
		// 20 60 Ϊ���Ͻǵ���ʼֵ����Ϊ������ֵ
		lab_tank.setBounds(20 + tx * 50, 60 + ty * 50, 50, 50);
		this.add(lab_tank);
		// ��tank��������ӵ�������
		// maps[(260-20)/80][(300-60)/80]=8;

	}

	private void backgroundInit() {
		// TODO Auto-generated method stub
		// ����һ��ͼƬ
		Icon i = new ImageIcon("bg.png");
		// ʹ��JLabel��������
		JLabel lab_back = new JLabel(i);
		// ����ͼƬҪ��ʾ��λ��
		lab_back.setBounds(20, 60, 1360, 820);
		// ��ӵ�����
		this.add(lab_back);

	}

	private void setMainFrameUI() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		this.setTitle("������V1.0");
		this.setVisible(true);
		 setResizable(false);
		this.setSize(1120, 730);
		this.setLocationRelativeTo(null);
		// this.setLocation(50, 50);
		this.addWindowListener(new Mywindow());
	}

	class Mywindow extends WindowAdapter {
		public void windowClosing(WindowEvent e) {

			System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// ��ȡ����ȥ�İ���
		// 38 ��
		// 40 ��
		// 37 ��
		// 39 ��
		// System.out.println(e.getKeyCode());
		int key = e.getKeyCode();
		if (key == 39) {
			// ������
			// �����ϵ�һλ��������ty tx+1
			// �����ϵڶ�λ�������� ty tx+2

			if (maps[ty][tx + 1] == 0 || maps[ty][tx + 1] == 8) {
				tx = tx + 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x + 50, y);
				Icon i = new ImageIcon("right.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty][tx + 1] == 1) {
				return;
			}
			// ǰ��������+�ϰ�������
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 1) {
				return;
			}
			// ǰ�����������ӵ����
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 4) {
				return;
			}
			// ǰ�������� + �Ѿ�����Ŀ�ĵص����ӵ����
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 12) {
				return;
			}
			// ǰ���� ����Ŀ�ĵص����� + �ϰ�������
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 1) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� + ����
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 4) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� + ����Ŀ�ĵص�����
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 12) {
				return;
			}
			// �������ӿ�����ǰ��
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 0) {
				maps[ty][tx + 1] = 0;
				maps[ty][tx + 2] = 4;
			}
			// �������������� Ŀ��ص�
			if (maps[ty][tx + 1] == 4 && maps[ty][tx + 2] == 8) {
				maps[ty][tx + 1] = 0;
				maps[ty][tx + 2] = 12;
				num++;
			}
			// ��Ŀ������������Ƴ�����
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 0) {
				maps[ty][tx + 1] = 8;
				maps[ty][tx + 2] = 4;
				num--;
			}
			// ����Ŀ��� ������
			if (maps[ty][tx + 1] == 12 && maps[ty][tx + 2] == 8) {
				maps[ty][tx + 1] = 8;
				maps[ty][tx + 2] = 12;
			}
			sheeps[ty][tx + 1].setLocation(20 + tx * 50 + 100, 60 + ty * 50);
			sheeps[ty][tx + 2] = sheeps[ty][tx + 1];
			sheeps[ty][tx + 1] = null;
			tx = tx + 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x + 50, y);
			Icon i = new ImageIcon("right.png");
			lab_tank.setIcon(i);
			// ʤ�����ж�
			victory();
			return;
		}
		if (key == 40) {
			// ����

			if (maps[ty + 1][tx] == 0 || maps[ty + 1][tx] == 8) {
				ty = ty + 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x, y + 50);
				Icon i = new ImageIcon("down.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty + 1][tx] == 1) {
				return;
			}
			// ǰ��������+�ϰ�������
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 1) {
				return;
			}
			// ǰ�����������ӵ����
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 4) {
				return;
			}
			// ǰ�������� + �Ѿ�����Ŀ�ĵص����ӵ����
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 12) {
				return;
			}
			// ǰ���� ����Ŀ�ĵص����� + �ϰ�������
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 1) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� + ����
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 4) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� + ����Ŀ�ĵص�����
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 12) {
				return;
			}
			// �������ӿ�����ǰ��
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 0) {
				maps[ty + 1][tx] = 0;
				maps[ty + 2][tx] = 4;
			}
			// �������������� Ŀ��ص�
			if (maps[ty + 1][tx] == 4 && maps[ty + 2][tx] == 8) {
				maps[ty + 1][tx] = 0;
				maps[ty + 2][tx] = 12;
				num++;
			}
			// ��Ŀ������������Ƴ�����
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 0) {
				maps[ty + 1][tx] = 8;
				maps[ty + 2][tx] = 4;
				num--;
			}
			// ����Ŀ��� ������
			if (maps[ty + 1][tx] == 12 && maps[ty + 2][tx] == 8) {
				maps[ty + 1][tx] = 8;
				maps[ty + 2][tx] = 12;
			}
			sheeps[ty + 1][tx].setLocation(20 + tx * 50, 60 + ty * 50 + 100);
			sheeps[ty + 2][tx] = sheeps[ty + 1][tx];
			sheeps[ty + 1][tx] = null;
			ty = ty + 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x, y + 50);
			Icon i = new ImageIcon("down.png");
			lab_tank.setIcon(i);
			// ʤ�����ж�
			victory();
			return;

		}
		if (key == 38) {
			// ��up

			if (maps[ty - 1][tx] == 0 || maps[ty - 1][tx] == 8) {
				ty = ty - 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x, y - 50);
				Icon i = new ImageIcon("up.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty - 1][tx] == 1) {
				return;
			}
			// ǰ��������+�ϰ�������
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 1) {
				return;
			}
			// ǰ�����������ӵ����
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 4) {
				return;
			}
			// ǰ�������� + �Ѿ�����Ŀ�ĵص����ӵ����
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 12) {
				return;
			}
			// ǰ���� ����Ŀ�ĵص����� + �ϰ�������
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 1) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� + ����
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 4) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� + ����Ŀ�ĵص�����
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 12) {
				return;
			}
			// �������ӿ�����ǰ��
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 0) {
				maps[ty - 1][tx] = 0;
				maps[ty - 2][tx] = 4;
			}
			// �������������� Ŀ��ص�
			if (maps[ty - 1][tx] == 4 && maps[ty - 2][tx] == 8) {
				maps[ty - 1][tx] = 0;
				maps[ty - 2][tx] = 12;
				num++;
			}
			// ��Ŀ������������Ƴ�����
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 0) {
				maps[ty - 1][tx] = 8;
				maps[ty - 2][tx] = 4;
				num--;
			}
			// ����Ŀ��� ������
			if (maps[ty - 1][tx] == 12 && maps[ty - 2][tx] == 8) {
				maps[ty - 1][tx] = 8;
				maps[ty - 2][tx] = 12;
			}
			sheeps[ty - 1][tx].setLocation(20 + tx * 50, 60 + ty * 50 - 100);
			sheeps[ty - 2][tx] = sheeps[ty - 1][tx];
			sheeps[ty - 1][tx] = null;
			ty = ty - 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x, y - 50);
			Icon i = new ImageIcon("up.png");
			lab_tank.setIcon(i);
			// ʤ�����ж�
			victory();
			return;

		}
		if (key == 37) {
			// ��zuo��
			// �����ϵ�һλ��������ty tx-1
			// �����ϵڶ�λ�������� ty tx-2

			if (maps[ty][tx - 1] == 0 || maps[ty][tx - 1] == 8) {
				tx = tx - 1;
				int x = (int) lab_tank.getLocation().getX();
				int y = (int) lab_tank.getLocation().getY();
				lab_tank.setLocation(x - 50, y);
				Icon i = new ImageIcon("left.png");
				lab_tank.setIcon(i);
				return;
			}
			if (maps[ty][tx - 1] == 1) {
				return;
			}
			// ǰ��������-�ϰ�������
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 1) {
				return;
			}
			// ǰ�����������ӵ����
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 4) {
				return;
			}
			// ǰ�������� - �Ѿ�����Ŀ�ĵص����ӵ����
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 12) {
				return;
			}
			// ǰ���� ����Ŀ�ĵص����� - �ϰ�������
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 1) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� - ����
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 4) {
				return;
			}
			// ǰ���е���Ŀ�ĵص����� - ����Ŀ�ĵص�����
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 12) {
				return;
			}
			// �������ӿ�����ǰ��
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 0) {
				maps[ty][tx - 1] = 0;
				maps[ty][tx - 2] = 4;
			}
			// �������������� Ŀ��ص�
			if (maps[ty][tx - 1] == 4 && maps[ty][tx - 2] == 8) {
				maps[ty][tx - 1] = 0;
				maps[ty][tx - 2] = 12;
				num++;
			}
			// ��Ŀ������������Ƴ�����
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 0) {
				maps[ty][tx - 1] = 8;
				maps[ty][tx - 2] = 4;
				num--;
			}
			// ����Ŀ��� ������
			if (maps[ty][tx - 1] == 12 && maps[ty][tx - 2] == 8) {
				maps[ty][tx - 1] = 8;
				maps[ty][tx - 2] = 12;
			}
			sheeps[ty][tx - 1].setLocation(20 + tx * 50 - 100, 60 + ty * 50);
			sheeps[ty][tx - 2] = sheeps[ty][tx - 1];
			sheeps[ty][tx - 1] = null;
			tx = tx - 1;
			int x = (int) lab_tank.getLocation().getX();
			int y = (int) lab_tank.getLocation().getY();
			lab_tank.setLocation(x - 50, y);
			Icon i = new ImageIcon("left.png");
			lab_tank.setIcon(i);
			// ʤ�����ж�
			victory();
			return;
		}

	}

	private void victory() {
		// TODO Auto-generated method stub
		// System.out.println(num);
		if (num == total) {
			// �Ƴ���������¼��������û��������
			this.removeKeyListener(this);
			System.out.println("win");
			JDialog victory = new JDialog(this, "��ϲ��ȡ����ʤ��", true);
			victory.setSize(400, 300);
			victory.setLocationRelativeTo(null);
			victory.setLayout(null);

			//JLabel info = new JLabel(new ImageIcon("win.jpg"));
			//info.setBounds(2, 2, 380, 180);
			//victory.add(info);
			JButton click = new JButton("��Ϸ����");
			click.setBounds(140, 200, 120, 30);

			victory.add(click);
			victory.setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
