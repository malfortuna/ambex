package net.cutgar.ambex;

import org.flixel.FlxG;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;

public class Player extends FlxSprite {
	
	public boolean attacking = false;

	public Player(int x, int y){
		super(x,y);
		loadGraphic("pack:kebab", true, true, 16);
		addAnimation("idle", new int[]{0});
		addAnimation("walk", new int[]{0,1,2,3}, 10, true);
		addAnimation("attack", new int[]{0,4,5,4}, 15, true);
		
		play("idle");
		
		acceleration.y = 400;
	}
	
	@Override
	public void update(){
		
		if(FlxG.keys.LEFT){
			velocity.x = -100;
			setFacing(FlxObject.LEFT);
		}
		else if(FlxG.keys.RIGHT){
			velocity.x = 100;
			setFacing(FlxObject.RIGHT);
		}
		else{
			velocity.x = 0;
		}
		
		if(FlxG.keys.SPACE && isTouching(FlxObject.FLOOR)){
			velocity.y = -200;
		}
		
		if(FlxG.keys.X){
			play("attack");
			attacking = true;
		}
		else{
			attacking = false;
			
			if(velocity.y != 0){
				play("idle");
			}
			else if(velocity.x != 0){
				play("walk");
			}
			else{
				play("idle");
			}
		
		}
		
	}
	
}
