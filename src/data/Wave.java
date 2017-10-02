package data;

import static helpers.Clock.Delta;
import static helpers.Clock.gameOver;

import java.util.ArrayList;

public class Wave {
	
	private float timeSinceLastSpawn;
	private double spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	public ArrayList<Enemy> deadEnemies;
	public int id = 0;
	
	public Wave(float spawnTime, Enemy enemyType) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		timeSinceLastSpawn = 0;
		enemyList = new ArrayList<Enemy>();
		deadEnemies = new ArrayList<Enemy>();
	}
	
	public void Update(Player p) {
		
		timeSinceLastSpawn += 0.7;
		if (timeSinceLastSpawn > spawnTime) {
			Spawn();
			timeSinceLastSpawn = 0;
			spawnTime -= 0.01;
		}
		
		for (Enemy e: enemyList) {
			if (e.isAlive()) {
			e.Update();
			e.Draw();
			}
			
			if ((Math.floor(p.getX() / 64)) == (Math.floor(e.getX() / 64)) && (Math.floor(p.getY() / 64)) == (Math.floor(e.getY() / 64))) {
				gameOver = true;
			}
			if ((Math.floor(p.getBullet().getX() / 64)) == (Math.floor(e.getX() / 64)) && (Math.floor(p.getBullet().getY() / 64)) == (Math.floor(e.getY() / 64))) {
				e.Die();
			}
		}	
	}    
	            
	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(ArrayList<Enemy> enemyList) {
		this.enemyList = enemyList;
	}

	private void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getX(), enemyType.getY(), 64, 64, enemyType.getSpeed()));
		id++;
	}

}
