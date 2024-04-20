public class DeepPoint extends Point{
	private int depth;

  public void setDepth(int d) {
		if (d <= 0) {
			depth = 1;
		} else if (d >= 11) {
			depth = 10;
		} else {
			depth = d;
		}
	}

	public int getDepth() {
		return depth;
	}

	@Override
	public void print() {
		for (int i = 0; i < depth; i++) {
			System.out.print("(");
		}
		System.out.printf("%d, %d", x, y);
		for (int i = 0; i < depth; i++) {
			System.out.print(")");
		}
	}

	public DeepPoint(int x, int y, int d) {
		super(x, y);
		setDepth(d);
	}
}
