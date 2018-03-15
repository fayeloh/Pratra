package com.fayeloh.tools.vcode.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCode {

	private int w = 70;//��
	private int h = 35;//��
	private Color bgcolor = new Color(250, 250, 250);//������ɫ
	private Random random = new Random();
	private StringBuilder sb= new StringBuilder(4);
	private String text;
	/**
	 * ��ȡ�����
	 */
	private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
	private String randomChar() {
		int index = random.nextInt(codes.length());
		return  codes.charAt(index)+"";
	}
	/**
	 * ����õ�������ɫ
	 */
	private Color randomColor() {
		int r = random.nextInt(150);
		int g = random.nextInt(150);
		int b = random.nextInt(150);
		return new Color(r, g, b);
	}
	/**
	 * ����
	 * @param img
	 */
	private void drawline(BufferedImage img){
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(1.5F));//��ƽ�����ߴ�1.5��
		for(int i=0;i<5;i++){
			int x1 = random.nextInt(w);
			int y1 = random.nextInt(h);
			int x2 = random.nextInt(w);
			int y2 = random.nextInt(h);
			g.drawLine(x1, y1, x2, y2);
			
		}
	}
	/**
	 * ����õ�����Ĵ�С����ʽ����ɫ
	 */
	private String[] fontNames = {"����", "���Ŀ���", "����", "΢���ź�", "����_GB2312"};
	private Font randomFont() {
		int index = random.nextInt(fontNames.length);
		String fontName = fontNames[index];
		int size = random.nextInt(5)+24;
		int style = random.nextInt(4);
		return new Font(fontName,style,size); 
		
	}
  

	/**
	 * ����ͼƬ
	 * 
	 * @return
	 */
	private BufferedImage createImage() {
		/*
		 * ����ͼƬ ���ñ���
		 */
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		img.getGraphics().setColor(bgcolor);
		//��������������γɱ���ɫ
		img.getGraphics().fillRect(0, 0, w, h);
		return img;
	}
	/**
	 * ��ȡ���ɵ�ͼƬ
	 * @return
	 */
	public BufferedImage getImage(){
		BufferedImage img = createImage();
		Graphics g = img.getGraphics();
		for(int i = 0;i<4;i++){
			String ch = this.randomChar();
		    sb.append(ch);//��¼���ɵ��ַ�
			g.setColor(this.randomColor());
			g.setFont(this.randomFont());
			g.drawString(ch, w/4*i, h-5);
		}
		text = sb.toString();
		this.drawline(img);
		return img;
	}
	/**
	 * ������֤��ͼ�ϵ���
	 * @return
	 */
	public String getText(){
		return text;
	}
	/**
	 * ����ͼƬ
	 * 
	 * @throws IOException
	 */
	public static void save(BufferedImage img,OutputStream out)
			throws IOException {
		ImageIO.write(img, "JPEG", out);
	}
}
