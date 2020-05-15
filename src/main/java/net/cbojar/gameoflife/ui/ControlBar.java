package net.cbojar.gameoflife.ui;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.ChangeListener;

final class ControlBar extends JPanel {
	private static final long serialVersionUID = 7304252118338492410L;

	private ControlBar() {
		// Prevent external instantiation
	}

	public static ControlBar create(final TickTimer timer) {
		final JButton pausePlay = new JButton("||");
		pausePlay.addActionListener((actionEvent) -> {
			if (timer.togglePaused()) {
				pausePlay.setText(">");
			} else {
				pausePlay.setText("||");
			}
		});

		final JSlider speed = new JSlider();
		speed.setMaximum(TickTimer.MAX_SPEED);
		speed.setMinimum(TickTimer.MIN_SPEED);
		speed.setMajorTickSpacing(1);
		speed.setPaintTicks(true);
		speed.setSnapToTicks(true);
		speed.setValue(timer.speed());
		speed.addChangeListener(speedListener(timer));

		final ControlBar controlBar = new ControlBar();
		controlBar.setLayout(new BorderLayout());
		controlBar.add(pausePlay, BorderLayout.LINE_START);
		controlBar.add(speed, BorderLayout.CENTER);

		return controlBar;
	}

	private static ChangeListener speedListener(final TickTimer timer) {
		return (changeEvent) -> {
			final JSlider speedSlider = (JSlider)changeEvent.getSource();
			timer.setSpeed(speedSlider.getValue());
		};
	}
}
