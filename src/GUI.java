import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GUI {

	public GUI() {
		
		Var.jf1 = new JFrame();
		Var.jf1.setSize(Var.screenwidth, Var.screenheight);
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jf1.setLocationRelativeTo(null);
		Var.jf1.setLayout(null);
		Var.jf1.setTitle("Star Rift");
		Var.jf1.setResizable(false);
		Var.jf1.addKeyListener(new KeyHandler());
		
		Var.lbl1 = new Label();
		Var.lbl1.setBounds(0, 0, Var.screenwidth, Var.screenheight);
		Var.lbl1.setVisible(true);
		
		Var.btnstart = new JButton();
		Var.btnstart.setText("Start");
		Var.btnstart.setBounds(500, 550, 200, 50);
		Var.btnstart.setVisible(true);
		Var.btnstart.addActionListener(new ActionHandler());
		Var.btnstart.setBackground(Color.LIGHT_GRAY);
		Var.btnstart.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnstart.setForeground(Color.BLACK);
		Var.btnstart.setBorder(null);
		Var.btnstart.setFocusPainted(false);
		Var.btnstart.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnstart.setBackground(new Color(0, 230, 115));
				Var.btnstart.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnstart.setBackground(Color.LIGHT_GRAY);
				Var.btnstart.setForeground(Color.BLACK);
			}
		});
		
		Var.btnresume = new JButton();
		Var.btnresume.setText("Resume");
		Var.btnresume.setBounds(500, 100, 200, 50);
		Var.btnresume.setVisible(false);
		Var.btnresume.addActionListener(new ActionHandler());
		Var.btnresume.setBackground(Color.BLACK);
		Var.btnresume.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnresume.setForeground(Color.WHITE);
		Var.btnresume.setBorder(null);
		Var.btnresume.setFocusPainted(false);
		Var.btnresume.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnresume.setBackground(new Color(0, 230, 115));
				Var.btnresume.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnresume.setBackground(Color.BLACK);
				Var.btnresume.setForeground(Color.WHITE);
			}
		});
		
		Var.btnshop = new JButton();
		Var.btnshop.setText("Shop");
		Var.btnshop.setBounds(500, 200, 200, 50);
		Var.btnshop.setVisible(false);
		Var.btnshop.addActionListener(new ActionHandler());
		Var.btnshop.setBackground(Color.BLACK);
		Var.btnshop.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnshop.setForeground(Color.WHITE);
		Var.btnshop.setBorder(null);
		Var.btnshop.setFocusPainted(false);
		Var.btnshop.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnshop.setBackground(new Color(0, 230, 115));
				Var.btnshop.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnshop.setBackground(Color.BLACK);
				Var.btnshop.setForeground(Color.WHITE);
			}
		});
		
		
		Var.btnoptions = new JButton();
		Var.btnoptions.setText("Options");
		Var.btnoptions.setBounds(500, 300, 200, 50);
		Var.btnoptions.setVisible(false);
		Var.btnoptions.addActionListener(new ActionHandler());
		Var.btnoptions.setBackground(Color.BLACK);
		Var.btnoptions.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnoptions.setForeground(Color.WHITE);
		Var.btnoptions.setBorder(null);
		Var.btnoptions.setFocusPainted(false);
		Var.btnoptions.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnoptions.setBackground(new Color(0, 230, 115));
				Var.btnoptions.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnoptions.setBackground(Color.BLACK);
				Var.btnoptions.setForeground(Color.WHITE);
			}
		});
		
		
		Var.btnexit = new JButton();
		Var.btnexit.setText("Exit");
		Var.btnexit.setBounds(500, 400, 200, 50);
		Var.btnexit.setVisible(false);
		Var.btnexit.addActionListener(new ActionHandler());
		Var.btnexit.setBackground(Color.BLACK);
		Var.btnexit.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnexit.setForeground(Color.WHITE);
		Var.btnexit.setBorder(null);
		Var.btnexit.setFocusPainted(false);
		Var.btnexit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnexit.setBackground(new Color(0, 230, 115));
				Var.btnexit.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnexit.setBackground(Color.BLACK);
				Var.btnexit.setForeground(Color.WHITE);
			}
		});
		
		Var.btnmute = new JButton();
		Var.btnmute.setText("Mute");
		Var.btnmute.setBounds(500, 300, 200, 50);
		Var.btnmute.setVisible(false);
		Var.btnmute.addActionListener(new ActionHandler());
		Var.btnmute.setBackground(Color.BLACK);
		Var.btnmute.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnmute.setForeground(Color.WHITE);
		Var.btnmute.setBorder(null);
		Var.btnmute.setFocusPainted(false);
		Var.btnmute.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnmute.setBackground(new Color(0, 230, 115));
				Var.btnmute.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnmute.setBackground(Color.BLACK);
				Var.btnmute.setForeground(Color.WHITE);
			}
		});
		
		Var.btntrack1 = new JButton();
		Var.btntrack1.setText("Track 1");
		Var.btntrack1.setBounds(500, 400, 200, 50);
		Var.btntrack1.setVisible(false);
		Var.btntrack1.addActionListener(new ActionHandler());
		Var.btntrack1.setBackground(Color.BLUE);
		Var.btntrack1.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btntrack1.setForeground(Color.WHITE);
		Var.btntrack1.setBorder(null);
		Var.btntrack1.setFocusPainted(false);
		Var.btntrack1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btntrack1.setBackground(new Color(0, 230, 115));
				Var.btntrack1.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				if(Var.activetrack == 1) {
					Var.btntrack1.setBackground(Color.BLUE);
				} else {
					Var.btntrack1.setBackground(Color.BLACK);
				}
				Var.btntrack1.setForeground(Color.WHITE);
			}
		});
		
		Var.btntrack2 = new JButton();
		Var.btntrack2.setText("Track 2");
		Var.btntrack2.setBounds(500, 500, 200, 50);
		Var.btntrack2.setVisible(false);
		Var.btntrack2.addActionListener(new ActionHandler());
		Var.btntrack2.setBackground(Color.BLACK);
		Var.btntrack2.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btntrack2.setForeground(Color.WHITE);
		Var.btntrack2.setBorder(null);
		Var.btntrack2.setFocusPainted(false);
		Var.btntrack2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btntrack2.setBackground(new Color(0, 230, 115));
				Var.btntrack2.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				if(Var.activetrack == 2) {
					Var.btntrack2.setBackground(Color.BLUE);
				} else {
					Var.btntrack2.setBackground(Color.BLACK);
				}
				Var.btntrack2.setForeground(Color.WHITE);
			}
		});
		
		Var.btntimelapse = new JButton();
		Var.btntimelapse.setText("+ " + Var.addtimelapse + "s");
		Var.btntimelapse.setBounds(700, 210, 200, 50);
		Var.btntimelapse.setVisible(false);
		Var.btntimelapse.addActionListener(new ActionHandler());
		Var.btntimelapse.setBackground(Color.BLACK);
		Var.btntimelapse.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btntimelapse.setForeground(Color.WHITE);
		Var.btntimelapse.setBorder(null);
		Var.btntimelapse.setFocusPainted(false);
		Var.btntimelapse.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				if(Var.coinscollected >= Var.pricetimelapse) {
					Var.btntimelapse.setBackground(new Color(0, 230, 115));
					Var.btntimelapse.setForeground(Color.BLACK);
				} else {
					Var.btntimelapse.setBackground(Color.RED);
					Var.btntimelapse.setForeground(Color.BLACK);
				}
			}
			public void mouseExited(MouseEvent evt) {
				Var.btntimelapse.setBackground(Color.BLACK);
				Var.btntimelapse.setForeground(Color.WHITE);
			}
		});
		
		Var.btnlives = new JButton();
		Var.btnlives.setText("+ 1");
		Var.btnlives.setBounds(700, 330, 200, 50);
		Var.btnlives.setVisible(false);
		Var.btnlives.addActionListener(new ActionHandler());
		Var.btnlives.setBackground(Color.BLACK);
		Var.btnlives.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnlives.setForeground(Color.WHITE);
		Var.btnlives.setBorder(null);
		Var.btnlives.setFocusPainted(false);
		Var.btnlives.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				if(Var.coinscollected >= Var.pricelife) {
					Var.btnlives.setBackground(new Color(0, 230, 115));
					Var.btnlives.setForeground(Color.BLACK);
				} else {
					Var.btnlives.setBackground(Color.RED);
					Var.btnlives.setForeground(Color.BLACK);
				}
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnlives.setBackground(Color.BLACK);
				Var.btnlives.setForeground(Color.WHITE);
			}
		});

		Var.btnrockets = new JButton();
		Var.btnrockets.setText("+ " + Var.addrockets);
		Var.btnrockets.setBounds(700, 450, 200, 50);
		Var.btnrockets.setVisible(false);
		Var.btnrockets.addActionListener(new ActionHandler());
		Var.btnrockets.setBackground(Color.BLACK);
		Var.btnrockets.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnrockets.setForeground(Color.WHITE);
		Var.btnrockets.setBorder(null);
		Var.btnrockets.setFocusPainted(false);
		Var.btnrockets.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				if(Var.coinscollected >= Var.pricerockets) {
					Var.btnrockets.setBackground(new Color(0, 230, 115));
					Var.btnrockets.setForeground(Color.BLACK);
				} else {
					Var.btnrockets.setBackground(Color.RED);
					Var.btnrockets.setForeground(Color.BLACK);
				}
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnrockets.setBackground(Color.BLACK);
				Var.btnrockets.setForeground(Color.WHITE);
			}
		});

		Var.btnshield = new JButton();
		Var.btnshield.setText("+ " + Var.addshield);
		Var.btnshield.setBounds(700, 570, 200, 50);
		Var.btnshield.setVisible(false);
		Var.btnshield.addActionListener(new ActionHandler());
		Var.btnshield.setBackground(Color.BLACK);
		Var.btnshield.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnshield.setForeground(Color.WHITE);
		Var.btnshield.setBorder(null);
		Var.btnshield.setFocusPainted(false);
		Var.btnshield.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				if(Var.coinscollected >= Var.priceshield) {
					Var.btnshield.setBackground(new Color(0, 230, 115));
					Var.btnshield.setForeground(Color.BLACK);
				} else {
					Var.btnshield.setBackground(Color.RED);
					Var.btnshield.setForeground(Color.BLACK);
				}
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnshield.setBackground(Color.BLACK);
				Var.btnshield.setForeground(Color.WHITE);
			}
		});
		
		Var.btnrestart = new JButton();
		Var.btnrestart.setText("Restart");
		Var.btnrestart.setBounds(500, 400, 200, 50);
		Var.btnrestart.setVisible(false);
		Var.btnrestart.addActionListener(new ActionHandler());
		Var.btnrestart.setBackground(Color.LIGHT_GRAY);
		Var.btnrestart.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnrestart.setForeground(Color.BLACK);
		Var.btnrestart.setBorder(null);
		Var.btnrestart.setFocusPainted(false);
		Var.btnrestart.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnrestart.setBackground(new Color(0, 230, 115));
				Var.btnrestart.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnrestart.setBackground(Color.LIGHT_GRAY);
				Var.btnrestart.setForeground(Color.BLACK);
			}
		});
		
		Var.btnclose = new JButton();
		Var.btnclose.setText("Close");
		Var.btnclose.setBounds(500, 500, 200, 50);
		Var.btnclose.setVisible(false);
		Var.btnclose.addActionListener(new ActionHandler());
		Var.btnclose.setBackground(Color.LIGHT_GRAY);
		Var.btnclose.setFont(new Font("Arial", Font.BOLD, 40));
		Var.btnclose.setForeground(Color.BLACK);
		Var.btnclose.setBorder(null);
		Var.btnclose.setFocusPainted(false);
		Var.btnclose.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				Var.btnclose.setBackground(Color.RED);
				Var.btnclose.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent evt) {
				Var.btnclose.setBackground(Color.LIGHT_GRAY);
				Var.btnclose.setForeground(Color.BLACK);
			}
		});
		
		Var.jf1.add(Var.btnstart);
		Var.jf1.add(Var.btnresume);
		Var.jf1.add(Var.btnshop);
		Var.jf1.add(Var.btnoptions);
		Var.jf1.add(Var.btnexit);
		Var.jf1.add(Var.btnmute);
		Var.jf1.add(Var.btntrack1);
		Var.jf1.add(Var.btntrack2);
		Var.jf1.add(Var.btntimelapse);
		Var.jf1.add(Var.btnlives);
		Var.jf1.add(Var.btnrockets);
		Var.jf1.add(Var.btnshield);
		Var.jf1.add(Var.btnmute);
		Var.jf1.add(Var.btnrestart);
		Var.jf1.add(Var.btnclose);
		
		Var.jf1.add(Var.lbl1);
		
		Var.jf1.requestFocus();
		Var.jf1.setVisible(true);
		
	}

}
