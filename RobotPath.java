public class RobotPath {
	static int row = 4;
	static int column = 4;
	static int count = 0;
	public static void main(String[] args) {
		boolean check[][] = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				check[i][j] = false;
			}
		}
		getTotalPath(0,0, check);
		System.out.println(count);
	}

	private static void getTotalPath(int r, int c, boolean visit[][]) {
		if ((r == row - 1) && (c == column - 1)) {
			count++;
			return;
		} else {
				visit[r][c] = true;
				if (checkValidity(r+1, c) && !visit[r+1][c]) {
					getTotalPath(r+1,c,visit);
				}
				if (checkValidity(r-1, c) && !visit[r-1][c]) {
					getTotalPath(r-1,c,visit);
				}
				if (checkValidity(r, c-1) && !visit[r][c-1]) {
					getTotalPath(r,c-1,visit);
				}
				if (checkValidity(r, c+1) && !visit[r][c+1]) {
					getTotalPath(r,c+1,visit);
				}
		}
		visit[r][c] = false;
	}

	private static boolean checkValidity(int r, int c) {
		
		if (r < 0 || c < 0 || r >= row || c >= column) {
			return false;
		}
		return true;
	}
}
