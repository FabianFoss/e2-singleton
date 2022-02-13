package com.singleton.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Helicopter {
    private Vector3 position;
    private Sprite heli;
    private Vector3 velocity;

    private static Helicopter heliInstance = new Helicopter();

    public static Helicopter getHeliInstance(){
        return heliInstance;
    }

    private Helicopter(){
        heli = new Sprite(new Texture("helicopter.png"));
        position = new Vector3(0,0,0);
        velocity = new Vector3(7,7,0);
    }

    public void render(SpriteBatch batch){
        move();
        batch.draw(heli,position.x,position.y);
    }
    public void move(){
        position.add(velocity.x, velocity.y, 0);
    }
    public void changeYmovement(){
        velocity.y = velocity.y<0 ?7:-7;
    }
    public void changeXmovement(){
        heli.flip(true,false);
        velocity.x = velocity.x<0 ? 7:-7;
    }
    public Vector3 getPosition(){
        return position;
    }

    public void dispose(){
        heli.getTexture().dispose();
    }
}
