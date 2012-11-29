package net.cutgar.ambex;

import org.flixel.FlxSprite;

public class HealthBar extends FlxSprite {

	FlxSprite target;
	int hmax;
	int maxwidth;
	
	public HealthBar(int x, int y, int maxwidth, int hmax, FlxSprite target){
		super(x+4, y);
		makeGraphic((int) (maxwidth*(target.health/hmax)), 8, 0xff000000);
		this.maxwidth = maxwidth;
		this.hmax = hmax;
		this.target = target;
	}
	
	public void update(){
		makeGraphic((int) (maxwidth*(target.health/hmax)), 8, 0xff000000);
	}
	
}
