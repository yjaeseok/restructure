
public class BasicFloorDisplay extends AbstractFloorDisplay {
	public BasicFloorDisplay(EC ctrl, IFloorDisplayImplementor imp) {
		super(ctrl, imp);
	}
	
	@Override
	public void showPos(int flr) {
		IFloorDisplayImplementor imp = getImp();
		imp.showCurrentPosition(flr);
	}
	@Override
	public void showDir(int dir) {
		IFloorDisplayImplementor imp = getImp();
		imp.showDirection(dir);
	}
}
