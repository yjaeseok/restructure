

public class AdvancedFloorDisplay extends AbstractFloorDisplay {
	public AdvancedFloorDisplay(ElevatorController ctrl, IFloorDisplayImplementor imp) {
		super(ctrl, imp);
	}
	@Override
	public void showPos(int flr) {
		IFloorDisplayImplementor imp = getImp();
		imp.showCurrentPosition(flr);
		imp.expressCurrentPositionByVoice(flr);
	}
	@Override
	public void showDir(int dir) {
		IFloorDisplayImplementor imp = getImp();
		imp.showDirection(dir);
		imp.expressDirectionByVoice(dir);
	}
}
