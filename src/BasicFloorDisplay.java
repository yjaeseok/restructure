
public class BasicFloorDisplay extends AbstractFloorDisplay {
	public BasicFloorDisplay(final ElevatorController ctrl, final IFloorDisplayImplementor imp) {
		super(ctrl, imp);
	}
	
	@Override
	public void showPos(final int flr) {
		IFloorDisplayImplementor imp = getImp();
		imp.showCurrentPosition(flr);
	}
	@Override
	public void showDir(final Direction dir) {
		IFloorDisplayImplementor imp = getImp();
		imp.showDirection(dir);
	}
}
