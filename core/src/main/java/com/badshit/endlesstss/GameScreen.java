package com.badshit.endlesstss;

import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

	private EndlessTSS game;
	private TiledMap map;
	private TiledMapRenderer renderer;
	private AssetManager asset_manager;
	private Texture tiles;
	private Texture texture;
	private SpriteBatch batch;
	private TextureRegion[][] split_tiles;

	private OrthographicCamera camera;
	private Viewport viewport;

	private Player player;

	public GameScreen(EndlessTSS endlessTSS) {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		game = endlessTSS;
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(true, (w / h) * 16f, 10f);
		viewport = new FitViewport(400, 400);

		generateMap((int) viewport.getWorldWidth(), (int) viewport.getWorldHeight());

		renderer = new OrthogonalTiledMapRenderer(map, 1 / 16F);
		
		batch = new SpriteBatch();

		player = new Player(new Vector2(0,0));
	}

	public void generateMap(int w, int h) {
		tiles = new Texture("tileset.png");

		split_tiles = TextureRegion.split(tiles, 16, 16);
		map = new TiledMap();
		MapLayers layers = map.getLayers();
		/*
		 * for (int layer_count = 0; layer_count < 2; layer_count++) { for (int width =
		 * 0; width <= w; width++) { for (int height = 0; height <= h; height++) {
		 * 
		 * } } }
		 */
		TiledMapTileLayer layer = new TiledMapTileLayer(w / game.PPM, h / game.PPM, 16, 16);
		for (int width = 0; width <= w; width++) {
			for (int height = 0; height <= h; height++) {
				Cell cell = new Cell();
				cell.setTile(new StaticTiledMapTile(split_tiles[0][(int)Math.random()]));
				layer.setCell(width, height, cell);
			}
		}
		layers.add(layer);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		renderer.setView(camera);
		renderer.render();

		batch.begin();
		player.act(delta);
		player.draw(batch, delta);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
