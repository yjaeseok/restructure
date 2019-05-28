

public interface IFloorDisplayImplementor {
	public void activateDisplay();
	public void deactivateDisplay();
	
	public void showCurrentPosition(int floor);
	public void expressCurrentPositionByVoice(int floor);
	public void showDirection(int direction);
	public void expressDirectionByVoice(int direction);
}
