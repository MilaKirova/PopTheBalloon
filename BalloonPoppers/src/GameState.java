
public class GameState {
	BalloonsManager bm = new BalloonsManager();
	
	public GameState() {
		for (int x=15;x<600;x+=40) {
			bm.AddAddingPosition(new Vec2(x,0));
		}
	}
	
	public void Update() {
		bm.Update();
	}
	
	public void Render() {
		bm.Render();
	}
}
