
public class Vec2 {

	public double X;
	public double Y;
	
	public Vec2(double x,double y) {
		this.X=x;
		this.Y=y;
	}
	
	public static Vec2 Add(Vec2 a, Vec2 b) {
		return new Vec2(a.X+b.X,a.Y+b.Y);
	}
	
	public double DistanceTo(Vec2 v) {
		double dx = this.X - v.X;
		double dy = this.Y - v.Y;
		
		return Math.sqrt(dx*dx+dy*dy);
	}
}
