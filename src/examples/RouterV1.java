package examples;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class RouterV1 {

	protected JFrame windows;
	protected JPanel panelmain;
	protected JPanel panelshow;
	protected JPanel panellog;
	protected JPanel paneltable;
	protected JPanel panelcontrol;
	protected JTextArea worktext;
	protected JScrollPane scrollPane;
	protected JScrollPane scrollPane_1;
	protected JTable table;
	protected JLabel lblRemoteHost;
	protected JLabel lblSend;
	protected JComboBox combosend;
	protected JLabel lblRecieve;
	protected JComboBox comborecieve;
	protected JButton btnClearLog;
	protected JButton btnClearTable;
	protected JButton btnExit;
	protected JButton btnPing;
	protected JLabel lblWorkingSpeed;
	protected JComboBox combospeed;
	protected JPanel panelpic;
	protected JLabel label;
	protected JLabel lblComputer;
	protected JLabel lblComputer_1;
	protected JLabel lblComputer_2;
	protected JLabel lblComputer_3;
	protected JLabel lblRouter;
	protected JLabel lblRemoteHost_1;
	private JLabel lblWorkingLog;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RouterV1 window = new RouterV1();
					window.setfream();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		void setfream() {
		windows = new JFrame();
		//windows.setIconImage(Toolkit.getDefaultToolkit().getImage(RouterV1.class.getResource("/network/project/router/networking-icon.png")));
		windows.setTitle("Router");
		windows.setResizable(false);
		windows.setAlwaysOnTop(true);
		windows.setBounds(0, 0, 800, 480);
		windows.setLocationRelativeTo(null);
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.getContentPane().setLayout(null);
		windows.setVisible(true);
		panelmain = new JPanel();
		panelmain.setBounds(0, 0, 794, 451);
		windows.getContentPane().add(panelmain);
		panelmain.setLayout(null);
		
		lblWorkingLog = new JLabel("Working log");
		lblWorkingLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkingLog.setBounds(570, 11, 214, 27);
		panelmain.add(lblWorkingLog);
		
		panelshow = new JPanel();
		panelshow.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelshow.setBounds(10, 11, 550, 240);
		panelmain.add(panelshow);
		panelshow.setLayout(null);
		
		panelpic = new JPanel();
		panelpic.setBounds(10, 11, 530, 218);
		panelshow.add(panelpic);
		panelpic.setLayout(null);
		
		lblComputer = new JLabel("Computer 1");
		lblComputer.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputer.setBounds(50, 70, 70, 14);
		panelpic.add(lblComputer);
		
		lblComputer_1 = new JLabel("Computer 2");
		lblComputer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputer_1.setBounds(50, 182, 70, 14);
		panelpic.add(lblComputer_1);
		
		lblComputer_2 = new JLabel("Computer 3");
		lblComputer_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputer_2.setBounds(416, 70, 70, 14);
		panelpic.add(lblComputer_2);
		
		lblComputer_3 = new JLabel("Computer 4");
		lblComputer_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputer_3.setBounds(416, 182, 70, 14);
		panelpic.add(lblComputer_3);
		
		lblRouter = new JLabel("Router");
		lblRouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouter.setBounds(236, 168, 70, 14);
		panelpic.add(lblRouter);
		
		lblRemoteHost_1 = new JLabel("Remote Host");
		lblRemoteHost_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoteHost_1.setBounds(231, 7, 80, 14);
		panelpic.add(lblRemoteHost_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(RouterV1.class.getResource("/network/project/router/backgroundnew.jpg")));
		label.setBounds(0, 0, 530, 218);
		panelpic.add(label);
		
		panellog = new JPanel();
		panellog.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panellog.setBounds(570, 37, 214, 214);
		panelmain.add(panellog);
		panellog.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 214, 214);
		panellog.add(scrollPane);
		
		worktext = new JTextArea();
		worktext.setForeground(Color.WHITE);
		worktext.setFont(new Font("Consolas", Font.PLAIN, 11));
		worktext.setText("Router working log . . .");
		worktext.append("\n");
		worktext.append("\n");
		worktext.setBackground(Color.BLACK);
		worktext.setWrapStyleWord(true);
		worktext.setLineWrap(true);
		worktext.setEditable(false);
		worktext.setLocation(14, 0);
		scrollPane.setViewportView(worktext);
		
		panelcontrol = new JPanel();
		panelcontrol.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelcontrol.setBounds(346, 262, 438, 178);
		panelmain.add(panelcontrol);
		panelcontrol.setLayout(null);
		
		lblRemoteHost = new JLabel("Remote Host");
		lblRemoteHost.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoteHost.setBounds(169, 11, 100, 14);
		panelcontrol.add(lblRemoteHost);
		
		lblSend = new JLabel("Send :");
		lblSend.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSend.setBounds(50, 55, 60, 14);
		panelcontrol.add(lblSend);
		
		combosend = new JComboBox();
		combosend.setModel(new DefaultComboBoxModel(new String[] {"", "Computer 1", "Computer 2", "Computer 3", "Computer 4"}));
		combosend.setBounds(120, 52, 165, 20);
		panelcontrol.add(combosend);
		
		lblRecieve = new JLabel("Recieve :");
		lblRecieve.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecieve.setBounds(50, 93, 60, 14);
		panelcontrol.add(lblRecieve);
		
		comborecieve = new JComboBox();
		comborecieve.setModel(new DefaultComboBoxModel(new String[] {"", "Computer 1", "Computer 2", "Computer 3", "Computer 4"}));
		comborecieve.setBounds(120, 90, 165, 20);
		panelcontrol.add(comborecieve);
		
		btnClearLog = new JButton("CLEAR LOG");
		btnClearLog.setBounds(308, 52, 120, 30);
		panelcontrol.add(btnClearLog);
		
		btnClearTable = new JButton("CLEAR TABLE");
		btnClearTable.setBounds(308, 93, 120, 30);
		panelcontrol.add(btnClearTable);
		
		btnExit = new JButton("EXIT");
		btnExit.setBounds(308, 134, 120, 30);
		panelcontrol.add(btnExit);
		
		btnPing = new JButton("PING");
		btnPing.setBounds(308, 11, 120, 30);
		panelcontrol.add(btnPing);
		
		lblWorkingSpeed = new JLabel("Working speed:");
		lblWorkingSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWorkingSpeed.setBounds(10, 131, 100, 14);
		panelcontrol.add(lblWorkingSpeed);
		
		combospeed = new JComboBox();
		combospeed.setModel(new DefaultComboBoxModel<Object>(new String[] {"Normal", "Fast"}));
		combospeed.setBounds(120, 128, 165, 20);
		panelcontrol.add(combospeed);
		
		paneltable = new JPanel();
		paneltable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paneltable.setBounds(10, 262, 326, 178);
		panelmain.add(paneltable);
		paneltable.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 326, 178);
		paneltable.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No. PC", "Mac Address"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane_1.setViewportView(table);
	}
}
