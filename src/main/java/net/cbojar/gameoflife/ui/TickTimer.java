package net.cbojar.gameoflife.ui;

public final class TickTimer {
	public static final int MIN_SPEED = 1;
	public static final int MAX_SPEED = 20;

	private int time = 0;
	private int speed = 1;
	private boolean paused = false;

	private TickTimer() {
		// Private construction
	}

	public static TickTimer create() {
		return new TickTimer();
	}

	public int speed() {
		return speed;
	}

	public void setSpeed(final int speed) {
		this.speed = speed;
	}

	public boolean shouldTick() {
		return !paused && time % tickInterval() == 0;
	}

	public void increment() {
		time = (time + 1) % tickInterval();
	}

	public boolean togglePaused() {
		paused = !paused;
		return paused;
	}

	private int tickInterval() {
		return MAX_SPEED - speed + 1;
	}
}
