package com.sys;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.fife.ui.rsyntaxtextarea.TokenUtils;

import com.sys.vo.Faaliyet;

public class FaaliyetForm extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1742866129587896284L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel lblAlmKonusu;
	private JLabel lblTalepTarihi;
	private JLabel lblYaklakMaliyetBedeli;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JTextArea textArea;
	public FaaliyetForm(boolean editable) {
		setSize(1011, 811);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {300, 0, 32};
		gridBagLayout.rowHeights = new int[] {0, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 320, 72};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);

		JLabel lblSNo = new JLabel("S. No :");
		lblSNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSNo.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblSNo = new GridBagConstraints();
		gbc_lblSNo.fill = GridBagConstraints.BOTH;
		gbc_lblSNo.insets = new Insets(32, 16, 8, 16);
		gbc_lblSNo.gridx = 0;
		gbc_lblSNo.gridy = 0;
		//add(lblSNo, gbc_lblSNo);

		if(Statics.selectedFaaliyet!=null)textField = new JTextField(Statics.selectedFaaliyet.getId());
		else textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(32, 16, 8, 16);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		//add(textField, gbc_textField);
		textField.setColumns(10);

		lblAlmKonusu = new JLabel("Al\u0131m Konusu :");
		lblAlmKonusu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmKonusu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblAlmKonusu = new GridBagConstraints();
		gbc_lblAlmKonusu.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAlmKonusu.insets = new Insets(8, 16, 8, 16);
		gbc_lblAlmKonusu.gridx = 0;
		gbc_lblAlmKonusu.gridy = 1;
		add(lblAlmKonusu, gbc_lblAlmKonusu);

		if(Statics.selectedFaaliyet!=null)textField_1 = new JTextField(Statics.selectedFaaliyet.getKonu());
		else textField_1 = new JTextField();
		if(!editable)textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(8, 16, 8, 16);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);

		lblTalepTarihi = new JLabel("Talep Tarihi :");
		lblTalepTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTalepTarihi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTalepTarihi = new GridBagConstraints();
		gbc_lblTalepTarihi.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTalepTarihi.insets = new Insets(8, 16, 8, 16);
		gbc_lblTalepTarihi.gridx = 0;
		gbc_lblTalepTarihi.gridy = 2;
		add(lblTalepTarihi, gbc_lblTalepTarihi);

		if(Statics.selectedFaaliyet!=null)textField_2 = new JTextField(Statics.selectedFaaliyet.getTalepTarihi());
		else textField_2 = new JTextField();
		if(!editable)textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(8, 16, 8, 16);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		add(textField_2, gbc_textField_2);

		lblYaklakMaliyetBedeli = new JLabel("Yakla\u015F\u0131k Maliyet Bedeli :");
		lblYaklakMaliyetBedeli.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYaklakMaliyetBedeli.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblYaklakMaliyetBedeli = new GridBagConstraints();
		gbc_lblYaklakMaliyetBedeli.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblYaklakMaliyetBedeli.insets = new Insets(8, 16, 8, 16);
		gbc_lblYaklakMaliyetBedeli.gridx = 0;
		gbc_lblYaklakMaliyetBedeli.gridy = 3;
		add(lblYaklakMaliyetBedeli, gbc_lblYaklakMaliyetBedeli);

		if(Statics.selectedFaaliyet!=null)textField_3 = new JTextField(Double.toString(Statics.selectedFaaliyet.getMaliyetBedeli()));
		else textField_3 = new JTextField();
		if(!editable)textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(8, 16, 8, 16);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		add(textField_3, gbc_textField_3);

		label_3 = new JLabel("Ödenek :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_3.insets = new Insets(8, 16, 8, 16);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 4;
		add(label_3, gbc_label_3);

		if(Statics.selectedFaaliyet!=null)textField_4 = new JTextField(Statics.selectedFaaliyet.getOdenek());
		else textField_4 = new JTextField();
		if(!editable)textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(8, 16, 8, 16);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		add(textField_4, gbc_textField_4);

		label_4 = new JLabel("İhale Tarihi :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_4.insets = new Insets(8, 16, 8, 16);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		add(label_4, gbc_label_4);

		if(Statics.selectedFaaliyet!=null)textField_5 = new JTextField(Statics.selectedFaaliyet.getIhaleTarihi());
		else textField_5 = new JTextField();
		if(!editable)textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(8, 16, 8, 16);
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		add(textField_5, gbc_textField_5);

		label_5 = new JLabel("Sözleşme Tarihi :");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_5.insets = new Insets(8, 16, 8, 16);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 6;
		add(label_5, gbc_label_5);

		if(Statics.selectedFaaliyet!=null)textField_6 = new JTextField(Statics.selectedFaaliyet.getSozlesmeTarihi());
		else textField_6 = new JTextField();
		if(!editable)textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(8, 16, 8, 16);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 6;
		add(textField_6, gbc_textField_6);

		label_6 = new JLabel("Teslim Süresi :");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_6.insets = new Insets(8, 16, 8, 16);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 7;
		add(label_6, gbc_label_6);

		if(Statics.selectedFaaliyet!=null)textField_7 = new JTextField(Statics.selectedFaaliyet.getTeslimSuresi());
		else textField_7 = new JTextField();
		if(!editable)textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(8, 16, 8, 16);
		gbc_textField_7.fill = GridBagConstraints.BOTH;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 7;
		add(textField_7, gbc_textField_7);

		label_7 = new JLabel("Sözleşme/Alım Bedeli :");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_7.insets = new Insets(8, 16, 8, 16);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 8;
		add(label_7, gbc_label_7);

		if(Statics.selectedFaaliyet!=null)textField_8 = new JTextField(Double.toString(Statics.selectedFaaliyet.getSozlesmeAlimBedeli()));
		else textField_8 = new JTextField();
		if(!editable)textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(8, 16, 8, 16);
		gbc_textField_8.fill = GridBagConstraints.BOTH;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 8;
		add(textField_8, gbc_textField_8);

		label_8 = new JLabel("İlave Sipariş Bedeli :");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_8.insets = new Insets(8, 16, 8, 16);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 9;
		add(label_8, gbc_label_8);

		if(Statics.selectedFaaliyet!=null)textField_9 = new JTextField(Double.toString(Statics.selectedFaaliyet.getIlaveSiparisBedeli()));
		else textField_9 = new JTextField();
		if(!editable)textField_9.setEditable(false);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(8, 16, 8, 16);
		gbc_textField_9.fill = GridBagConstraints.BOTH;
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 9;
		add(textField_9, gbc_textField_9);

		label_9 = new JLabel("Ödenen :");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_9.insets = new Insets(8, 16, 8, 16);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 10;
		add(label_9, gbc_label_9);

		if(Statics.selectedFaaliyet!=null)textField_10 = new JTextField(Double.toString(Statics.selectedFaaliyet.getOdenen()));
		else textField_10 = new JTextField();
		if(!editable)textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(8, 16, 8, 16);
		gbc_textField_10.fill = GridBagConstraints.BOTH;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 10;
		add(textField_10, gbc_textField_10);

		label_10 = new JLabel("İhale Üzerine Kalan Firma :");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_10.insets = new Insets(8, 16, 8, 16);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 11;
		add(label_10, gbc_label_10);

		if(Statics.selectedFaaliyet!=null)textField_11 = new JTextField(Statics.selectedFaaliyet.getFirma());
		else textField_11 = new JTextField();
		if(!editable)textField_11.setEditable(false);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(8, 16, 8, 16);
		gbc_textField_11.fill = GridBagConstraints.BOTH;
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 11;
		add(textField_11, gbc_textField_11);

		label_11 = new JLabel("Açıklama :");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_11.insets = new Insets(8, 16, 8, 16);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 12;
		add(label_11, gbc_label_11);

		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		if(Statics.selectedFaaliyet!=null)
			textArea.setText(Statics.selectedFaaliyet.getAciklama());
		if(!editable)textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(textArea.getSize().width-64, textArea.getSize().height));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(8, 16, 8, 16);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 12;
		add(scrollPane, gbc_textArea);

		label_12 = new JLabel("Sorumlu :");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.BOTH;
		gbc_label_12.insets = new Insets(8, 16, 32, 16);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 13;
		add(label_12, gbc_label_12);

		if(Statics.selectedFaaliyet!=null)textField_12 = new JTextField(Statics.selectedFaaliyet.getSorumlu());
		else textField_12 = new JTextField();
		if(!editable)textField_12.setEditable(false);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(8, 16, 32, 16);
		gbc_textField_12.fill = GridBagConstraints.BOTH;
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 13;
		add(textField_12, gbc_textField_12);
	}

	public void setFaaliyet() {
		if(Statics.selectedFaaliyet!=null)textField.setText(Integer.toString(Statics.selectedFaaliyet.getId()));
		if(Statics.selectedFaaliyet!=null)textField_1.setText(Statics.selectedFaaliyet.getKonu());
		if(Statics.selectedFaaliyet!=null)textField_2.setText(Statics.selectedFaaliyet.getTalepTarihi());
		if(Statics.selectedFaaliyet!=null)textField_3.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet.getMaliyetBedeli())));
		if(Statics.selectedFaaliyet!=null)textField_4.setText(Statics.selectedFaaliyet.getOdenek());
		if(Statics.selectedFaaliyet!=null)textField_5.setText(Statics.selectedFaaliyet.getIhaleTarihi());
		if(Statics.selectedFaaliyet!=null)textField_6.setText(Statics.selectedFaaliyet.getSozlesmeTarihi());
		if(Statics.selectedFaaliyet!=null)textField_7.setText(Statics.selectedFaaliyet.getTeslimSuresi());
		if(Statics.selectedFaaliyet!=null)textField_8.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet.getSozlesmeAlimBedeli())));
		if(Statics.selectedFaaliyet!=null)textField_9.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet.getIlaveSiparisBedeli())));
		if(Statics.selectedFaaliyet!=null)textField_10.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet.getOdenen())));
		if(Statics.selectedFaaliyet!=null)textField_11.setText(Statics.selectedFaaliyet.getFirma());
		if(Statics.selectedFaaliyet!=null)textArea.setText(Statics.selectedFaaliyet.getAciklama());
		if(Statics.selectedFaaliyet!=null)textField_12.setText(Statics.selectedFaaliyet.getSorumlu());
	}

	public void setFaaliyet1() {
		if(Statics.selectedFaaliyet1!=null)textField.setText(Integer.toString(Statics.selectedFaaliyet1.getId()));
		if(Statics.selectedFaaliyet1!=null)textField_1.setText(Statics.selectedFaaliyet1.getKonu());
		if(Statics.selectedFaaliyet1!=null)textField_2.setText(Statics.selectedFaaliyet1.getTalepTarihi());
		if(Statics.selectedFaaliyet1!=null)textField_3.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet1.getMaliyetBedeli())));
		if(Statics.selectedFaaliyet1!=null)textField_4.setText(Statics.selectedFaaliyet1.getOdenek());
		if(Statics.selectedFaaliyet1!=null)textField_5.setText(Statics.selectedFaaliyet1.getIhaleTarihi());
		if(Statics.selectedFaaliyet1!=null)textField_6.setText(Statics.selectedFaaliyet1.getSozlesmeTarihi());
		if(Statics.selectedFaaliyet1!=null)textField_7.setText(Statics.selectedFaaliyet1.getTeslimSuresi());
		if(Statics.selectedFaaliyet1!=null)textField_8.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet1.getSozlesmeAlimBedeli())));
		if(Statics.selectedFaaliyet1!=null)textField_9.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet1.getIlaveSiparisBedeli())));
		if(Statics.selectedFaaliyet1!=null)textField_10.setText(toTurkishStyle(Double.toString(Statics.selectedFaaliyet1.getOdenen())));
		if(Statics.selectedFaaliyet1!=null)textField_11.setText(Statics.selectedFaaliyet1.getFirma());
		if(Statics.selectedFaaliyet1!=null)textArea.setText(Statics.selectedFaaliyet1.getAciklama());
		if(Statics.selectedFaaliyet1!=null)textField_12.setText(Statics.selectedFaaliyet1.getSorumlu());
	}
	
	public void setEditables(boolean status) {
		textField.setEditable(false);
		textField_1.setEditable(status);
		textField_2.setEditable(status);
		textField_3.setEditable(status);
		textField_4.setEditable(status);
		textField_5.setEditable(status);
		textField_6.setEditable(status);
		textField_7.setEditable(status);
		textField_8.setEditable(status);
		textField_9.setEditable(status);
		textField_10.setEditable(status);
		textField_11.setEditable(status);
		textArea.setEditable(status);
		textField_12.setEditable(status);
	}

	public static String toNormalStyle(String s) {
		String s1 = "";
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i))) {
				s1 += s.charAt(i);
			} else if(s.charAt(i) == ',') {
				s1 += '.';
			}
		}
		return s1;
	}

	public static String toTurkishStyle(String s) {
		s = s.replace('.', ',');
		int i = s.indexOf(',') - 3;
		while(i>0) {
			s = s.substring(0, i)+"."+s.substring(i);
			i-=3;
		}
		return s;
	}
	
	public Faaliyet getFaaliyet() {
		Faaliyet faaliyet = new Faaliyet();
		faaliyet.setId(Integer.parseInt(textField.getText()));
		faaliyet.setKonu(textField_1.getText());
		faaliyet.setTalepTarihi(textField_2.getText());
		faaliyet.setMaliyetBedeli(Double.parseDouble(toNormalStyle(textField_3.getText())));
		faaliyet.setOdenek(textField_4.getText());
		faaliyet.setIhaleTarihi(textField_5.getText());
		faaliyet.setSozlesmeTarihi(textField_6.getText());
		faaliyet.setTeslimSuresi(textField_7.getText());
		faaliyet.setSozlesmeAlimBedeli(Double.parseDouble(toNormalStyle(textField_8.getText())));
		faaliyet.setIlaveSiparisBedeli(Double.parseDouble(toNormalStyle(textField_9.getText())));
		faaliyet.setOdenen(Double.parseDouble(toNormalStyle(textField_10.getText())));
		faaliyet.setFirma(textField_11.getText());
		faaliyet.setAciklama(textArea.getText());
		faaliyet.setSorumlu(textField_12.getText());
		return faaliyet;
	}

}
