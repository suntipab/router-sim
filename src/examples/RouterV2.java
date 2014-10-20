package examples;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RouterV2 extends RouterV1 implements ActionListener {
	int sendnum1;
	int recievenum1;
	boolean maccom1 = true, maccom2 = true, maccom3 = true, maccom4 = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RouterV2 window = new RouterV2();
					window.setfream();
					window.addAction();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void working() {
		int speed = 1000;
		if (combospeed.getSelectedIndex() == 1) {
			speed = 300;
		}
		System.out.println(combospeed.getSelectedIndex());
		Timer timer = new Timer();
		MyTask t = new MyTask();
		timer.schedule(t, 0, speed);

	}

	protected void addAction() {
		btnExit.addActionListener(this);
		btnClearLog.addActionListener(this);
		btnClearTable.addActionListener(this);
		btnPing.addActionListener(this);
		combosend.addActionListener(this);
		comborecieve.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnExit)) {
			System.exit(0);
		}
		if (e.getSource().equals(btnClearLog)) {
			worktext.setText("Router working log . . .");
			worktext.append("\n");
			worktext.append("\n");
			JOptionPane.showMessageDialog(windows, "Clear log success !");
		}
		if (e.getSource().equals(btnClearTable)) {
			table.setModel(new DefaultTableModel(new Object[][] {,},
					new String[] { "No. PC", "Mac Address" }));
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			JOptionPane.showMessageDialog(windows, "Clear table success !");
			maccom1 = true;
			maccom2 = true;
			maccom3 = true;
			maccom4 = true;
		}

		if (e.getSource().equals(btnPing)) {
			int sendnum = combosend.getSelectedIndex();
			int recievenum = comborecieve.getSelectedIndex();
			if (sendnum == 0 || recievenum == 0) {
				JOptionPane.showMessageDialog(windows,
						"Please select computer !");
			} else {

				combosend.setSelectedIndex(0);
				comborecieve.setSelectedIndex(0);
				sendnum1 = sendnum;
				recievenum1 = recievenum;
				working();
			}
		}

	}

	class MyTask extends TimerTask {

		private int times = 0;

		public void run() {
			times++;

			if (times <= 20) {
				combosend.setEnabled(false);
				comborecieve.setEnabled(false);
				combospeed.setEnabled(false);
				btnPing.setEnabled(false);
				worktext.setCaretPosition(worktext.getDocument().getLength());
				if (times == 1) {

					worktext.append("Computer " + sendnum1
							+ " ping to computer " + recievenum1 + "\n");

					if (sendnum1 == recievenum1) {
						worktext.append("Computer " + sendnum1+ " send ICMP to computer " + sendnum1 + "\n");
						worktext.append("Success !\n");
						worktext.append("\n");
						times=20;
					}
				}
				if (times == 2) {
					worktext.append("Computer " + sendnum1
							+ " send ARP to router" + "\n");
				}
				if (times == 3) {
					worktext.append("Router search mac address " + "Computer "
							+ recievenum1 + "\n");

				}
				if (times == 5) {
					checkrow();
					if (recievenum1 == 1) {
						if (maccom1 == true) {
							worktext.append("Not found mac address computer "
									+ recievenum1 + "\n");
						} else {
							worktext.append("Found mac address computer "
									+ recievenum1 + "\n");
							times = 11;
						}
					}
					if (recievenum1 == 2) {
						if (maccom2 == true) {
							worktext.append("Not found mac address computer "
									+ recievenum1 + "\n");
						} else {
							worktext.append("Found mac address computer "
									+ recievenum1 + "\n");
							times = 11;
						}

					}
					if (recievenum1 == 3) {
						if (maccom3 == true) {
							worktext.append("Not found mac address computer "
									+ recievenum1 + "\n");
						} else {
							worktext.append("Found mac address computer "
									+ recievenum1 + "\n");
							times = 11;
						}
					}
					if (recievenum1 == 4) {
						if (maccom4 == true) {
							worktext.append("Not found mac address computer "
									+ recievenum1 + "\n");
						} else {
							worktext.append("Found mac address computer "
									+ recievenum1 + "\n");
							times = 11;
						}
					}

				}
				if (times == 6) {
					worktext.append("Router send ICMP to computer " + sendnum1
							+ "\n");
				}
				if (times == 7) {
					worktext.append("Computer " + sendnum1 + " rejected" + "\n");
				}
				if (times == 8) {
					worktext.append("Router ping to Computer " + recievenum1
							+ "\n");
				}
				if (times == 9) {
					worktext.append("Router seve mac address computer "
							+ recievenum1 + " to table " + "\n");
					savemac();
				}
				if (times == 10) {
					worktext.append("Success !\n");
					worktext.append("\n");
					times = 20;
				}
				if (times == 12) {
					worktext.append("Computer " + sendnum1
							+ " send ICMP to Router " + "\n");
				}
				if (times == 13) {
					worktext.append("Router send ICMP to computer "
							+ recievenum1 + "\n");
				}
				if (times == 14) {
					worktext.append("Computer " + recievenum1
							+ " send ICMP to Router " + "\n");
				}
				if (times == 15) {
					worktext.append("Router send ICMP to computer " + sendnum1
							+ "\n");
				}
				if (times == 16) {
					worktext.append("Success !\n");
					worktext.append("\n");
					times = 20;

				}
			} else {
				worktext.setCaretPosition(worktext.getDocument().getLength());
				System.out.println("End!");
				btnPing.setEnabled(true);
				combosend.setEnabled(true);
				comborecieve.setEnabled(true);
				combospeed.setEnabled(true);
				this.cancel();
			}

		}

	}

	public void savecom1() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Vector<String> row = new Vector<String>();
		row.add("Computer 1");
		row.add("255.255.255.255");
		model.addRow(row);
	}

	public void savecom2() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Vector<String> row = new Vector<String>();
		row.add("Computer 2");
		row.add("255.255.255.255");
		model.addRow(row);
	}

	public void savecom3() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Vector<String> row = new Vector<String>();
		row.add("Computer 3");
		row.add("255.255.255.255");
		model.addRow(row);
	}

	public void savecom4() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Vector<String> row = new Vector<String>();
		row.add("Computer 4");
		row.add("255.255.255.255");
		model.addRow(row);
	}

	public void savemac() {
		if (recievenum1 == 1 && maccom1 == true) {
			savecom1();
		}
		if (recievenum1 == 2 && maccom2 == true) {
			savecom2();
		}
		if (recievenum1 == 3 && maccom3 == true) {
			savecom3();
		}
		if (recievenum1 == 4 && maccom4 == true) {
			savecom4();
		}

	}

	public void checkrow() {
		String check[] = new String[4];
		if (table.getRowCount() != 0) {
			for (int i = 0; i < table.getRowCount(); i++) {
				Object obj1 = GetData(table, i, 0);
				check[i] = (String) obj1;
				System.out.println(obj1);
				if ("Computer 1" == check[i]) {
					maccom1 = false;
				}
				if ("Computer 2" == check[i]) {
					maccom2 = false;
				}
				if ("Computer 3" == check[i]) {
					maccom3 = false;
				}
				if ("Computer 4" == check[i]) {
					maccom4 = false;
				}
			}
		} else {

		}

	}

	public Object GetData(JTable table, int row_index, int col_index) {
		return table.getModel().getValueAt(row_index, col_index);
	}

}