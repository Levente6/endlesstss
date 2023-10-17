package com.badshit.endlesstss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor{
	
	private Sprite player;
	private final int speed = 5;
	
	public enum states{
		ALIVE, DEAD
	}
	
	public Player(Vector2 position) {
		player = new Sprite(new Texture("player.png"));
		setDimensions(120, 200);
	}
	
	@Override
	public void act(float delta) {
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			player.setY(player.getY()+speed);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			player.setY(player.getY()-speed);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.setX(player.getX()+speed);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.setX(player.getX()-speed);
		}
	}
	
	public void setDimensions(int pixelWidth, int pixelHeight) {
		player.setScale((float)(pixelWidth/player.getHeight()), (float)(pixelHeight/player.getWidth()));
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		player.draw(batch);
	}
	
	
}
