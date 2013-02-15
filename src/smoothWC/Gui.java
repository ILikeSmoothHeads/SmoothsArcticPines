package smoothWC;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
	
	public Gui() {
		initComponents();
	}

	private void startButtonActionPerformed(ActionEvent e) {
		Variables.beaver = beaverButton.isSelected();
		Variables.urns = urnButton.isSelected();
		Variables.nests = nestButton.isSelected();
		
		Variables.guiOpen = false;
		this.dispose();
	}

	private void initComponents() {
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		urnButton = new JRadioButton();
		label4 = new JLabel();
		nestButton = new JRadioButton();
		label5 = new JLabel();
		beaverButton = new JRadioButton();
		startButton = new JButton();

		
		setFont(new Font("Dialog", Font.PLAIN, 14));
		Container contentPane = getContentPane();
		
		
		label1.setText("Smooth's");
		label1.setFont(new Font("Tahoma", Font.BOLD, 28));
		label1.setForeground(new Color(0, 255, 156));
		label1.setHorizontalTextPosition(SwingConstants.LEFT);

		label2.setText("Urns:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label3.setText("Arctic Pines");
		label3.setFont(new Font("Tahoma", Font.BOLD, 28));
		label3.setForeground(new Color(0, 255, 156));

		label4.setText("Nests/Seeds:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 18));

		label5.setText("Beaver:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 18));

		startButton.setText("Start");
		startButton.setFont(startButton.getFont().deriveFont(startButton.getFont().getStyle() | Font.BOLD));
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(label4, GroupLayout.Alignment.TRAILING)
										.addComponent(label2, GroupLayout.Alignment.TRAILING)
										.addComponent(label5, GroupLayout.Alignment.TRAILING))
									.addGap(29, 29, 29)
									.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(nestButton)
										.addComponent(beaverButton)
										.addComponent(urnButton)))
								.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addComponent(label3))))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(37, 37, 37)
							.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label3)
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(label2)
						.addComponent(urnButton))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label4)
						.addComponent(nestButton))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label5)
						.addComponent(beaverButton))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(startButton)
					.addContainerGap(9, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		
	}


	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JRadioButton urnButton;
	private JLabel label4;
	private JRadioButton nestButton;
	private JLabel label5;
	private JRadioButton beaverButton;
	private JButton startButton;
	
	
}
