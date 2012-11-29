package net.cutgar.ambex;

import org.flixel.FlxG;
import org.flixel.FlxSprite;
import org.flixel.FlxTimer;
import org.flixel.event.AFlxTimer;

public class Toaster extends FlxSprite {

	boolean pushed = false;
	private FlxTimer detonate;
	private FlxTimer kill;
	
	public Toaster(int x, int y){
		super(x,y);
		loadGraphic("pack:toaster", true, true, 16);
		addAnimation("idle", new int[]{0});
		addAnimation("push", new int[]{0,1,2}, 5, false);
		addAnimation("explode", new int[]{3,4}, 4, false);
		
		play("idle");
		
		width = 12;
		height = 4;
		offset.y = 12;
		offset.x = 2;
		
		acceleration.y = 10000;
		
	}
	
	@Override
	public void update(){
		super.update();
		if(detonate != null){
			detonate.update();
		}
		if(kill != null){
			kill.update();
		}
		velocity.x = 0;
	}
	
	public void pushDown(){
		if(pushed)
			return;
		pushed = true;
		play("push");
		detonate = new FlxTimer();
		detonate.start(3.0f, 1, new AFlxTimer(){

			@Override
			public void callback(FlxTimer Timer){
				explode();
			}
			
		});
	}
	
	public void explode(){
		play("explode");
		if(FlxG.collide(this, Registry.player)){
			Registry.player.velocity.y = -600;
		}
		
		kill = new FlxTimer();
		kill.start(0.5f, 1, new AFlxTimer(){

			@Override
			public void callback(FlxTimer Timer){
				kill();
			}
			
		});
	}
	
}
