package coreClasses;

import java.util.List;

public class CubbyLarge extends CubbyDecorator
{

	public CubbyLarge(I_Cubby newCubby) {
		super(newCubby);
		// TODO Auto-generated constructor stub
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
