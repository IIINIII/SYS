package com.sys;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import com.sys.MsgBox.MessageBox;
import com.sys.dao.JDBCFaaliyetDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;

public class DetailPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2621664989738592461L;
	public static boolean tumu = true;
	public static JLabel back = null;
	public static boolean ekle = false;
	public static boolean arama = false;
	public static boolean degisme = false;
	
	public DetailPanel(boolean editable) {
		setBorder(new MatteBorder(0, 2, 0, 2, Color.decode("#333333")));
		setLayout(null);
		
		JLabel lblPnlTitle = new JLabel("");
		lblPnlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnlTitle.setIcon(new ImageIcon(ChangPwdPanel.class.getResource("/com/sys/imgs/detail.png")));
		lblPnlTitle.setForeground(Color.WHITE);
		lblPnlTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPnlTitle.setBounds(2, 16, 48, 48);
		lblPnlTitle.setOpaque(true);
		lblPnlTitle.setBackground(Color.decode("#333333"));
		add(lblPnlTitle);
		
		if(arama) {
			if(degisme) {
				JLabel okLabel = new JLabel("");
				okLabel.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/save.png")));
				okLabel.setOpaque(true);
				okLabel.setHorizontalAlignment(SwingConstants.CENTER);
				okLabel.setForeground(Color.WHITE);
				okLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
				okLabel.setBackground(new Color(51, 51, 51));
				okLabel.setBounds(2, 75, 48, 48);
				okLabel.addMouseListener(new MouseListener() {
					
					boolean pressed = false;
					
					@Override
					public void mouseReleased(MouseEvent e) {
						okLabel.setBackground(Color.decode("#333333"));
						pressed = false;
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						okLabel.setBackground(Color.decode("#68C6EF"));
						pressed = true;
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						okLabel.setBackground(Color.decode("#333333"));
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!pressed)
							okLabel.setBackground(Color.decode("#535353"));
						else
							okLabel.setBackground(Color.decode("#68C6EF"));
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						okLabel.setBackground(Color.decode("#333333"));
						if(MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(okLabel), "Değişiklikler kaydolsun mu?", true, MessageBox.CONFIRM_MESSAGE, SwingUtilities.getRoot(okLabel).getLocation().x+Manager.width-399, SwingUtilities.getRoot(okLabel).getLocation().y+601)==MessageBox.OK_RESULT) {
							JDBCFaaliyetDAO dao = new JDBCFaaliyetDAO();
							dao.getConnection();
							if(dao.update(Statics.faaliyetForm.getFaaliyet())) {
								MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(okLabel), "Faaliyet başarıyla değiştirildi!", true, MessageBox.DONE_MESSAGE, SwingUtilities.getRoot(okLabel).getLocation().x+Manager.width-399, SwingUtilities.getRoot(okLabel).getLocation().y+601);
							}
						}
					}
				});
				add(okLabel);
			}
			else {
				JLabel cancelLabel = new JLabel("");
				cancelLabel.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/cancel.png")));
				cancelLabel.setOpaque(true);
				cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
				cancelLabel.setForeground(Color.WHITE);
				cancelLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
				cancelLabel.setBackground(new Color(51, 51, 51));
				cancelLabel.setBounds(2, 75, 48, 48);
				cancelLabel.addMouseListener(new MouseListener() {
					
					boolean pressed = false;
					
					@Override
					public void mouseReleased(MouseEvent e) {
						cancelLabel.setBackground(Color.decode("#333333"));
						pressed = false;
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						cancelLabel.setBackground(Color.decode("#E91E63"));
						pressed = true;
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						cancelLabel.setBackground(Color.decode("#333333"));
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!pressed)
							cancelLabel.setBackground(Color.decode("#535353"));
						else
							cancelLabel.setBackground(Color.decode("#E91E63"));
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						Listeners.removeAllPanels(Manager.viewPanel, "forFun");
						Manager.viewPanel.repaint();
						if(Listeners.secilmis!=null) {
							Listeners.secilmis.setBackground(Color.decode("#333333"));
							Listeners.secilmis = null;
						}
						cancelLabel.setBackground(Color.decode("#333333"));
					}
				});
				add(cancelLabel);
			}
		} else if(ekle) {
			JLabel okLabel = new JLabel("");
			okLabel.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/ok.png")));
			okLabel.setOpaque(true);
			okLabel.setHorizontalAlignment(SwingConstants.CENTER);
			okLabel.setForeground(Color.WHITE);
			okLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			okLabel.setBackground(new Color(51, 51, 51));
			okLabel.setBounds(2, 75, 48, 48);
			okLabel.addMouseListener(new MouseListener() {
				
				boolean pressed = false;
				
				@Override
				public void mouseReleased(MouseEvent e) {
					okLabel.setBackground(Color.decode("#333333"));
					pressed = false;
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					okLabel.setBackground(Color.decode("#68C6EF"));
					pressed = true;
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					okLabel.setBackground(Color.decode("#333333"));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					if(!pressed)
						okLabel.setBackground(Color.decode("#535353"));
					else
						okLabel.setBackground(Color.decode("#68C6EF"));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					okLabel.setBackground(Color.decode("#333333"));
					if(MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(okLabel), "Yeni faaliyet eklensin mi?", true, MessageBox.CONFIRM_MESSAGE, SwingUtilities.getRoot(okLabel).getLocation().x+Manager.width-399, SwingUtilities.getRoot(okLabel).getLocation().y+601)==MessageBox.OK_RESULT) {
						JDBCFaaliyetDAO dao = new JDBCFaaliyetDAO();
						dao.getConnection();
						if(dao.insert(Statics.faaliyetForm.getFaaliyet())) {
							MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(okLabel), "Faaliyet başarıyla eklendi!", true, MessageBox.DONE_MESSAGE, SwingUtilities.getRoot(okLabel).getLocation().x+Manager.width-399, SwingUtilities.getRoot(okLabel).getLocation().y+601);
							SwingUtilities.getRoot(Manager.viewPanel).repaint();
						}
					}
				}
			});
			add(okLabel);
			
			JLabel cancelLabel = new JLabel("");
			cancelLabel.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/cancel.png")));
			cancelLabel.setOpaque(true);
			cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
			cancelLabel.setForeground(Color.WHITE);
			cancelLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			cancelLabel.setBackground(new Color(51, 51, 51));
			cancelLabel.setBounds(2, 134, 48, 48);
			cancelLabel.addMouseListener(new MouseListener() {
				
				boolean pressed = false;
				
				@Override
				public void mouseReleased(MouseEvent e) {
					cancelLabel.setBackground(Color.decode("#333333"));
					pressed = false;
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					cancelLabel.setBackground(Color.decode("#E91E63"));
					pressed = true;
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					cancelLabel.setBackground(Color.decode("#333333"));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					if(!pressed)
						cancelLabel.setBackground(Color.decode("#535353"));
					else
						cancelLabel.setBackground(Color.decode("#E91E63"));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if(MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(cancelLabel), "Ekleme iptal edilsin mi?", true, MessageBox.CONFIRM_MESSAGE, SwingUtilities.getRoot(cancelLabel).getLocation().x+Manager.width-399, SwingUtilities.getRoot(cancelLabel).getLocation().y+601)==MessageBox.OK_RESULT) {
						Listeners.removeAllPanels(Manager.viewPanel, "forFun");
						Manager.viewPanel.repaint();
						if(Listeners.secilmis!=null) {
							Listeners.secilmis.setBackground(Color.decode("#333333"));
							Listeners.secilmis = null;
						}
					}
					cancelLabel.setBackground(Color.decode("#333333"));
				}
			});
			add(cancelLabel);
		} else {
			back = new JLabel("");
			if(tumu) back.setIcon(new ImageIcon(ChangPwdPanel.class.getResource("/com/sys/imgs/butun_isler.png")));
			else     back.setIcon(new ImageIcon(ChangPwdPanel.class.getResource("/com/sys/imgs/islerim.png")));
			back.setOpaque(true);
			back.setHorizontalAlignment(SwingConstants.CENTER);
			back.setForeground(Color.WHITE);
			back.setFont(new Font("Tahoma", Font.PLAIN, 24));
			back.setBackground(new Color(51, 51, 51));
			back.setBounds(2, 75, 48, 48);
			back.addMouseListener(Listeners.btnDesign);
			add(back);
			if(!tumu) {
				JLabel okLabel = new JLabel("");
				okLabel.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/save.png")));
				okLabel.setOpaque(true);
				okLabel.setHorizontalAlignment(SwingConstants.CENTER);
				okLabel.setForeground(Color.WHITE);
				okLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
				okLabel.setBackground(new Color(51, 51, 51));
				okLabel.setBounds(2, 134, 48, 48);
				okLabel.addMouseListener(new MouseListener() {
					
					boolean pressed = false;
					
					@Override
					public void mouseReleased(MouseEvent e) {
						okLabel.setBackground(Color.decode("#333333"));
						pressed = false;
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						okLabel.setBackground(Color.decode("#68C6EF"));
						pressed = true;
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						okLabel.setBackground(Color.decode("#333333"));
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						if(!pressed)
							okLabel.setBackground(Color.decode("#535353"));
						else
							okLabel.setBackground(Color.decode("#68C6EF"));
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						okLabel.setBackground(Color.decode("#333333"));
						if(MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(okLabel), "Değişiklikler kaydolsun mu?", true, MessageBox.CONFIRM_MESSAGE, SwingUtilities.getRoot(okLabel).getLocation().x+Manager.width-399, SwingUtilities.getRoot(okLabel).getLocation().y+601)==MessageBox.OK_RESULT) {
							JDBCFaaliyetDAO dao = new JDBCFaaliyetDAO();
							dao.getConnection();
							if(dao.update(Statics.faaliyetForm.getFaaliyet())) {
								MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(okLabel), "Faaliyet başarıyla değiştirildi!", true, MessageBox.DONE_MESSAGE, SwingUtilities.getRoot(okLabel).getLocation().x+Manager.width-399, SwingUtilities.getRoot(okLabel).getLocation().y+601);
							}
						}
					}
				});
				add(okLabel);
			}
		}
		
		Statics.faaliyetForm = new FaaliyetForm(editable);
		JScrollPane scrollPane = new JScrollPane(Statics.faaliyetForm);
		scrollPane.setPreferredSize(Statics.faaliyetForm.getSize());
		scrollPane.setBounds(64, 16, 1008, 604);
		add(scrollPane);
		
		setVisible(false);
	}
}
