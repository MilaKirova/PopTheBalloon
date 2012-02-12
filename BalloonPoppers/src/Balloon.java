
import java.awt.*;

public class Balloon {
	public Balloon(Color color,int size, Vec2 location) {
		this.Color=color;
		this.Size=size;
		this.Location=location;
		this.IsAlive=false;
	}
	
	public Color Color;
	public int Size;
	public boolean IsAlive;
	public Vec2 Location;
	
	private Vec2 movementVec;
	
	public void Update() {
		if (IsAlive) {
			Location = Vec2.Add(Location, movementVec);
		}
	}
	
	public void Pop() {
		IsAlive=false;
	}
}
