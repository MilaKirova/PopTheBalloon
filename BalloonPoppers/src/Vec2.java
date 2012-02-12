
public class Vec2 {
	
	public Vec2(int x,int y) {
		this.X=x;
		this.Y=y;
	}
	
	public int X;
	public int Y;
	
	public static Vec2 Add(Vec2 a, Vec2 b) {
		return new Vec2(a.X+b.X,a.Y+b.Y);
	}
}
