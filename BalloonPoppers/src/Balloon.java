
import java.awt.*;

public class Balloon {
	
	public static double Radius=15;
	
	public Color Color;
	public boolean IsAlive;
	public Vec2 Location;
	
	private Vec2 movementVec;
	
	public Balloon(Vec2 location, Vec2 movementVec, Color color) {
		this.Color=color;
		this.Location=location;
		this.movementVec=movementVec;
		this.IsAlive=true;
	}
	
	public void Update() {
		if (!IsAlive) return;
		
		Location = Vec2.Add(Location, movementVec);
	}
	
	public void Render() {
		StdDraw.setPenColor(Color);
		StdDraw.filledCircle(Location.X, Location.Y, Radius);
	}
	
	public void Pop() {
		IsAlive=false;
	}
}
