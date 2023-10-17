package com.badshit.endlesstss;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class EndlessTSS extends Game{
	public final int PPM = 16;

    @Override
    public void create() {
    	setScreen(new GameScreen(this));
    }

    @Override
    public void dispose() {
    	
    }
}
