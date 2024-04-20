public class Ma_io extends Player {
	public int hitPoint;
	public boolean invincible;
	public boolean fire;

	@Override
	public void talk() {
		if (hitPoint > 0) {
			System.out.print("It's-a me, Mario!");
		} else {
			System.out.print("zzz.");
		}
	}

	@Override
	public void hit() {
		if (hitPoint > 0 && !invincible) {
			hitPoint--;
			fire = false;
		}
	}

	@Override
	public void mushroom() {
		if (hitPoint == 1) {
			hitPoint = 2;
		}
	}

	@Override
	public void flower() {
		if (hitPoint == 1) {
			hitPoint = 2;
		} else if (hitPoint == 2) {
			fire = true;
		}
	}

	@Override
	public void star() {
		invincible = true;
	}

	@Override
	public void timeout() {
		invincible = false;
	}

	@Override
	public void attack() {
		if (fire) {
			System.out.print("Fire!");
		}
	}

	public Ma_io() {
		hitPoint = 1;
		invincible = false;
		fire = false;
	}
}