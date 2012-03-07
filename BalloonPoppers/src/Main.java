import java.awt.Color;


public class Main {
	public static GameState GameState = new GameState();
	public static boolean shouldContinue = true;

	public static void main(String[] args) {
		StdDraw.setCanvasSize(600, 600);
		StdDraw.setXscale(0,600);
		StdDraw.setYscale(600,0);
		while (shouldContinue) {
			
			StdDraw.clear(Color.GRAY);
			
			GameState.Update();
			GameState.Render();
			
			StdDraw.show(16);
			
		}
	}
}
