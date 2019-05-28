

public interface IFloorDisplayImplementor {
	public void activateDisplay();
	public void deactivateDisplay();
	
	public void showCurrentPosition(int floor);
	public void expressCurrentPositionByVoice(int floor);
	public void showDirection(Direction direction);
	public void expressDirectionByVoice(Direction direction);
}
