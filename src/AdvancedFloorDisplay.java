

public class AdvancedFloorDisplay extends AbstractFloorDisplay {
	public AdvancedFloorDisplay(final ElevatorController ctrl, final IFloorDisplayImplementor imp) {
		super(ctrl, imp);
	}
	@Override
	public void showPos(final Floor flr) {
		IFloorDisplayImplementor imp = getImp();
		imp.showCurrentPosition(flr);
		imp.expressCurrentPositionByVoice(flr);
	}
	@Override
	public void showDir(final Direction dir) {
		IFloorDisplayImplementor imp = getImp();
		imp.showDirection(dir);
		imp.expressDirectionByVoice(dir);
	}
}
