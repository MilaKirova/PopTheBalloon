import java.awt.Color;
import java.util.Vector;




public class BalloonsManager {
	public Vector<Balloon> Balloons=new Vector<Balloon>();
	
	public boolean TryAddBalloonAt(Vec2 pos, Vec2 movementVec, Color color) {
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
}
