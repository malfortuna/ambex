package net.cutgar.ambex;

import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxObject;
import org.flixel.FlxState;
import org.flixel.FlxTilemap;
import org.flixel.event.AFlxCamera;
import org.flixel.event.AFlxCollision;

public class PlayState extends FlxState
{
	public FlxTilemap level;
	public FlxGroup enemies;
	public Exit exit;
	public int levelNum;
	public HealthBar healthBar;
	
	public PlayState(){
		this.levelNum = 0;
	}
	
	public PlayState(int levelNum){
		this.levelNum = levelNum;
	}

	@Override
	public void create()
	{
		//http://www.colourlovers.com/palette/708748/mute_ambivalence
		Registry.pstate = this;
		FlxG.setBgColor((int) 0xffAAB29F);
		LevelGen.getLevel(this, levelNum);
		
	}
	
	@Override
	public void update(){
		super.update();
		
		if(levelNum > 2){
			if(FlxG.keys.X){
				System.exit(0);
			}
		}
		
		if(healthBar != null){
			healthBar.update();
		}
		FlxG.collide(level, Registry.player); FlxG.collide(level, exit);
		FlxG.collide(enemies, Registry.player, new AFlxCollision(){

			@Override
			public void callback(FlxObject tst, FlxObject ply){
				Toaster toaster = (Toaster) tst;
				Player player = (Player) ply;
				
				if(toaster.pushed && healthBar != null){
					player.health -= FlxG.elapsed * 40;
					if(player.health <= 0){
						FlxG.switchState(new PlayState(levelNum));
					}
				}
				
				if(player.getFacing() == FlxObject.RIGHT && player.attacking && player.x <= toaster.x
				|| player.getFacing() == FlxObject.LEFT && player.attacking && player.x >= toaster.x+toaster.width){
					toaster.pushDown();
				}
			}
			
		});
		FlxG.collide(level, enemies);
		
		FlxG.collide(Registry.player, exit, new AFlxCollision(){

			@Override
			public void callback(FlxObject Object1, FlxObject Object2){
				FlxG.fade(0xff000000, 1.0f, new AFlxCamera(){

					@Override
					public void callback(){
						FlxG.switchState(new PlayState(levelNum+1));
					}
					
				});
			}
			
		});
		
		if(FlxG.keys.R){
			FlxG.switchState(new PlayState(levelNum));
		}
	}
}