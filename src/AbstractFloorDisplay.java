

abstract class AbstractFloorDisplay {
	protected ElevatorController ctrl ;
	private IFloorDisplayImplementor imp;
	
	public AbstractFloorDisplay(ElevatorController ctrl, IFloorDisplayImplementor imp) {
		this.ctrl = ctrl;
		this.imp = imp;
	}
	public void update() {
		int curFlr = ctrl.getCurFlr() ;
		Direction curDir = ctrl.getCurrentElevatorDirection();
		showPos(curFlr);
		showDir(curDir);
	}
	public void displayOn() { imp.activateDisplay(); }
	public void displayOff() { imp.deactivateDisplay(); }
	public void setDisplay(boolean set) {
		if ( set  ) imp.activateDisplay();
		else imp.deactivateDisplay();
	}
	protected IFloorDisplayImplementor getImp() { return imp; }
	public abstract void showPos(int flr);
	public abstract void showDir(Direction dir);
}
