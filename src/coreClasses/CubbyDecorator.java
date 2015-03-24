package coreClasses;

import java.util.List;

public class CubbyDecorator implements I_Cubby{

	protected I_Cubby cubby;
	
	public CubbyDecorator( I_Cubby newCubby)
	{
		this.cubby = newCubby;
	}
	
	@Override
	public String getCubbyId() {
		return cubby.getCubbyId();
	}

	@Override
	public List<Item> getCubbyItems() {
		return cubby.getCubbyItems();
	}

	@Override
	public int getCubbyHeight() {
		// TODO Auto-generated method stub
		return cubby.getCubbyHeight();
	}

	@Override
	public int getCubbyWidth() {
		// TODO Auto-generated method stub
		return cubby.getCubbyWidth();
	}

	@Override
	public int getCubbyDepth() {
		// TODO Auto-generated method stub
		return cubby.getCubbyDepth();
	}

}
