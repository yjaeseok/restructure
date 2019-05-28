

public class ControlRoomDisplay {
	private EC ctrl ;

	public ControlRoomDisplay(EC ec) {
		this.ctrl = ec ;
	}
	public void update() {
		int curFlr = ctrl.getCurFlr() ;
		System.out.println("Control Room: " + curFlr) ;
	}
}
