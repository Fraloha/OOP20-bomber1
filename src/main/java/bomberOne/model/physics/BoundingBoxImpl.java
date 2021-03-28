package bomberOne.model.physics;

import bomberOne.model.common.P2d;

public class BoundingBoxImpl implements BoundingBox {

	P2d lTCorner;
	P2d rBCorner;
	
	public BoundingBoxImpl(P2d lTop, P2d rBottom) {
		this.lTCorner = lTop;
		this.rBCorner = rBottom;
	}
	
	public enum Collision{
		TOP,
		BOTTOM,
		LEFT,
		RIGHT,
		NONE;
	}
	
	@Override
	public boolean isCollidingWith(BoundingBox obj) {
		//obj collide on top
		if(this.lTCorner.y < obj.getRightBottomCorner().y && this.rBCorner.y > obj.getRightBottomCorner().y && this.lTCorner.x <= obj.getLeftTopCorner().x  &&  this.rBCorner.x >= obj.getLeftTopCorner().x || this.lTCorner.y < obj.getRightBottomCorner().y && this.rBCorner.y > obj.getRightBottomCorner().y && this.lTCorner.x >= obj.getLeftTopCorner().x && this.lTCorner.x <= obj.getRightBottomCorner().x) {
			return true;
		}
		//obj collide on bottom
		if(this.rBCorner.y > obj.getLeftTopCorner().y && this.lTCorner.y < obj.getLeftTopCorner().y && this.lTCorner.x <= obj.getLeftTopCorner().x  &&  this.rBCorner.x >= obj.getLeftTopCorner().x || this.rBCorner.y > obj.getLeftTopCorner().y && this.lTCorner.y < obj.getLeftTopCorner().y && this.lTCorner.x >= obj.getLeftTopCorner().x && this.lTCorner.x <= obj.getRightBottomCorner().x) {
			return true;
		}
//		//obj collide on left
//		if(this.lTCorner.x <= obj.getRightBottomCorner().x && (this.lTCorner.y <= obj.getLeftTopCorner().y && this.lTCorner.y >= obj.getRightBottomCorner().y) || (this.rBCorner.y <= obj.getLeftTopCorner().y && this.rBCorner.y >= obj.getRightBottomCorner().y)) {
//			return true;
//		}
//		//obj collide on right
//		if(this.rBCorner.x >= obj.getLeftTopCorner().x && (this.lTCorner.y <= obj.getLeftTopCorner().y && this.lTCorner.y >= obj.getRightBottomCorner().y) || (this.rBCorner.y <= obj.getLeftTopCorner().y && this.rBCorner.y >= obj.getRightBottomCorner().y)) {
//			return true;
//		}
		return false;
	}

	@Override
	public P2d getLeftTopCorner() {
		return this.lTCorner;
	}

	@Override
	public P2d getRightBottomCorner() {
		return this.rBCorner;
	}

}
