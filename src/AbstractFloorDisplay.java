

abstract class AbstractFloorDisplay {
	protected ElevatorController ctrl ;
	private IFloorDisplayImplementor imp;
	
	public AbstractFloorDisplay(final ElevatorController ctrl, final IFloorDisplayImplementor imp) {
		this.ctrl = ctrl;
		this.imp = imp;
	}
	public void update() {
		int curFlr = ctrl.getCurrentElevatorFloor() ;
		Direction curDir = ctrl.getCurrentElevatorDirection();
		showPos(curFlr);
		showDir(curDir);
	}
	public void displayOn() { imp.activateDisplay(); }
	public void displayOff() { imp.deactivateDisplay(); }
	public void setDisplay(final boolean set) {
		if ( set  ) imp.activateDisplay();
		else imp.deactivateDisplay();
	}
	protected IFloorDisplayImplementor getImp() { return imp; }
	public abstract void showPos(final int flr);
	public abstract void showDir(final Direction dir);
}
