
public class Bullet {
	public Vec2 Location;
	private Vec2 movementVector;
	
	public boolean IsAlive;
	
	public Bullet(Vec2 location,Vec2 movingVector) {
		this.Location = location;
		this.movementVector = movingVector;
		this.IsAlive=true;
	}
	
	public void Update() {
		if (!IsAlive) return;
		
		Location = Vec2.Add(Location, movementVector);
	}
	
	public void SetIsAliveToFalse() {
		IsAlive = false;
	}
}
