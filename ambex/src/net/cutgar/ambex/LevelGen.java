package net.cutgar.ambex;

import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxText;
import org.flixel.FlxTilemap;

public class LevelGen {
	public static void getLevel(PlayState p, int l){
		if(l == 0){
			p.level = new FlxTilemap();
			String levelData = 
							"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
			p.level.loadMap(levelData, "pack:tileset", 16, 16);
			p.add(p.level);
			
			Registry.player = new Player(32, 32);
			p.add(Registry.player);
			
			p.enemies = new FlxGroup();
			p.enemies.add(new Toaster(12*16, FlxG.height - 28));
			p.add(p.enemies);
			
			p.exit = new Exit(FlxG.width-48, 4*16);
			p.add(p.exit);
			
			FlxText main = new FlxText(16, 16, FlxG.width);
			main.setText("KEBAB: EXPLOASTER");
			main.setFormat(main.getFont(), 16, 0xffF7ABA1, "left");
			p.add(main);
			
			FlxText what = new FlxText(16, 32, FlxG.width);
			what.setText("PRESS X TO HIT TOASTER. JUMP IN AND GO.\nR TO RESTART");
			what.setFormat(main.getFont(), 8, 0xffF7ABA1, "left");
			p.add(what);
		}
		else if(l == 1){
			p.level = new FlxTilemap();
			String levelData = 
							"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
							"1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1\n"+
							"1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1\n"+
							"1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,1,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1"+"\n"+
							"1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
							"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
			p.level.loadMap(levelData, "pack:tileset", 16, 16);
			p.add(p.level);
			
			Registry.player = new Player(32, 32);
			p.add(Registry.player);
			
			p.enemies = new FlxGroup();
			p.enemies.add(new Toaster(6*16, 10*16));
			p.enemies.add(new Toaster(32, 14*16));
			p.add(p.enemies);
			
			p.exit = new Exit(32, 6*16);
			p.add(p.exit);
			
			FlxText main = new FlxText(16, 16, FlxG.width);
			main.setText("EXPLODABAB");
			main.setFormat(main.getFont(), 16, 0xffF7ABA1, "left");
			p.add(main);
			
			FlxText what = new FlxText(16, 32, FlxG.width);
			what.setText("TOASTERS DISAPPEAR AFTER USE JUST LIKE IN REALITY\nDON'T FORGET R TO RESTART");
			what.setFormat(main.getFont(), 8, 0xffF7ABA1, "left");
			p.add(what);
		}
		else if(l == 2){
				p.level = new FlxTilemap();
				String levelData = 
								"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1\n"+
								"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
								"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n"+
								"1,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,1\n"+
								"1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1\n"+
								"1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1"+"\n"+
								"1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1"+"\n"+
								"1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
								"1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
								"1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
								"1,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1"+"\n"+
								"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
								"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
								"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1"+"\n"+
								"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
				p.level.loadMap(levelData, "pack:tileset", 16, 16);
				p.add(p.level);
				
				Registry.player = new Player(32, 32);
				Registry.player.health = 100;
				p.add(Registry.player);
				
				FlxText healthText = new FlxText(8*16, FlxG.height-16, FlxG.width-(7*16));
				healthText.setText("< KEBAB HEALTH OR SOMETHING");
				healthText.setFormat(healthText.getFont(), 8, 0xffffff, "left");
				p.add(healthText);
				HealthBar h = new HealthBar(16, FlxG.height-16, 16*6, 100, Registry.player);
				p.healthBar = h;
				p.add(h);
				
				p.enemies = new FlxGroup();
				p.enemies.add(new Toaster(2*16, FlxG.height - (16*2)));
				p.enemies.add(new Toaster(7*16, FlxG.height - (16*6)));
				p.enemies.add(new Toaster(FlxG.width - (4*16), FlxG.height - (16*2)));
				p.add(p.enemies);
				
				p.exit = new Exit(FlxG.width-48, 4*16);
				p.add(p.exit);
				
				FlxText main = new FlxText(16, 16, FlxG.width);
				main.setText("TOE-STAB-SION: GENESIS");
				main.setFormat(main.getFont(), 16, 0xffF7ABA1, "left");
				p.add(main);
				
				FlxText what = new FlxText(16, 32, FlxG.width);
				what.setText("ALSO YOUR HEALTH GOES DOWN WHILE IN TOASTERS I GUESS");
				what.setFormat(main.getFont(), 8, 0xffF7ABA1, "left");
				p.add(what);
		}
		else{
			FlxText ft = new FlxText(0, FlxG.height/2-16, FlxG.width);
			ft.setText("UH, WORK IN PROGRESS\n\nX to quit.");
			ft.setAlignment("center");
			p.add(ft);
		}
	}
	
}
