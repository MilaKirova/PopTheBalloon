import java.awt.Color;
import java.util.Vector;




public class BalloonsManager {
	private Vector<Balloon> Balloons=new Vector<Balloon>();
	private Vector<Vec2> AddingPositions = new Vector<Vec2>();
	private Vector<Color> balloonColors = new Vector<Color>();
	
	public BalloonsManager() {
		balloonColors.add(Color.BLACK);
		balloonColors.add(Color.BLUE);
		balloonColors.add(Color.CYAN);
		balloonColors.add(Color.PINK);
		balloonColors.add(Color.RED);
		balloonColors.add(Color.ORANGE);
		balloonColors.add(Color.YELLOW);
		balloonColors.add(Color.GREEN);
		balloonColors.add(Color.WHITE);
		balloonColors.add(Color.MAGENTA);
	}
	
	public void Update() {
		for(Vec2 pos : AddingPositions) {
			int colorIndex = (int) Math.round(Math.random()*(balloonColors.size()-1));
			TryAddBalloonAt(pos,new Vec2(0,1), balloonColors.elementAt(colorIndex));
		}
		
		for (Balloon b : Balloons) {
			b.Update();
		}
		
		RemoveBalloonsOutsideOfCanvas();
	}
	
	public void Render() {
		for (Balloon b : Balloons) {
			b.Render();
		}
	}
	
	private boolean TryAddBalloonAt(Vec2 pos, Vec2 movementVec, Color color) {
		Balloon b = new Balloon(pos, movementVec, color);
		
		boolean intersectsWithBalloon=false;
		
		for (int i=0;i<Balloons.size();i++) {
			if (DoBalloonsIntersect(b,Balloons.get(i))) {
				intersectsWithBalloon=true;
				break;
			}
		}
		
		if (intersectsWithBalloon) return false;
		
		Balloons.add(b);
		return true;
	}
	
	private boolean DoBalloonsIntersect(Balloon b1, Balloon b2) {
		if (b1.Location.DistanceTo(b2.Location) < 2* Balloon.Radius)
			return true;
		return false;
	}
	
	public void AddAddingPosition(Vec2 pos) {
		if (!AddingPositions.contains(pos))
			AddingPositions.add(pos);
	}
	
	public void RemoveAddingPosition(Vec2 pos) {
		AddingPositions.remove(pos);
	}
	
	private void RemoveBalloonsOutsideOfCanvas() {
		Vector<Balloon> balloons = (Vector<Balloon>) Balloons.clone();
		for (int i=0;i<Balloons.size();i++) {
			Balloon b = balloons.elementAt(i);
			if (!IsBalloonInCanvas(b)) {
				b.IsAlive=false;
				Balloons.remove(b);
			}
		}
	}
	
	private boolean IsBalloonInCanvas(Balloon b) {
		return !(b.Location.X < 0 || b.Location.X > 600
				|| b.Location.Y < 0 || b.Location.Y > 600);
	}
}
