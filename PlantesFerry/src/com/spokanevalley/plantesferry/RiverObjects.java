package com.spokanevalley.plantesferry;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class RiverObjects
  extends Actor
{
  private Rectangle bounds = new Rectangle();
  
  public RiverObjects(float paramFloat1, float paramFloat2)
  {
    setWidth(160.0F);
    setHeight(85.0F);
    setPosition(paramFloat1, paramFloat2 - getHeight() / 2.0F);
    
    int i = MathUtils.random(0, 3);
    if (i == 0) {
      setColor(Color.RED);
    }
    if (i == 1) {
      setColor(Color.GREEN);
    }
    if (i == 2) {
      setColor(Color.BLUE);
    }
    if (i == 3) {
      setColor(Color.ORANGE);
    }
    
    addAction(Actions.moveTo(-getWidth(), getY(), MathUtils.random(4.0F, 6.0F)));
  }
  
  private void updateBounds()
  {
    this.bounds.set(getX(), getY(), getWidth(), getHeight());
  }
  
  public void act(float paramFloat)
  {
    super.act(paramFloat);
    updateBounds();
  }
  
  public void collision(boolean paramBoolean1, boolean paramBoolean2)
  {
    clearActions();
    addAction(Actions.rotateBy(360));
    addAction(Actions.fadeOut(1.0F));
    if ((paramBoolean1) && (paramBoolean2)) {
      addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(-360.0F, 1.5F), Actions.moveBy(200.0F, 200.0F, 1.5F)), Actions.removeActor()));
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(360.0F, 1.5F), Actions.moveBy(200.0F, -200.0F, 1.5F)), Actions.removeActor()));
    }
    if ((!paramBoolean1) && (paramBoolean2)) {
      addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(360.0F, 1.5F), Actions.moveBy(-200.0F, 200.0F, 1.5F)), Actions.removeActor()));
    }
    if ((!paramBoolean1) && (!paramBoolean2)) {
      addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(-360.0F, 1.5F), Actions.moveBy(-200.0F, -200.0F, 1.5F)), Actions.removeActor()));
    }
  }
  
  public void draw(SpriteBatch paramSpriteBatch, float paramFloat)
  {
    paramSpriteBatch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
    /*
    int i = MathUtils.random(0, 3);
    if (i == 0) {
        paramSpriteBatch.draw(Assets.obstruction1, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
        return;
    }
    if (i == 1) {
        paramSpriteBatch.draw(Assets.obstruction2, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
        return;
    }
    if (i == 2) {
        paramSpriteBatch.draw(Assets.obstruction3, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
        return;
    }
    if (i == 3) {
        paramSpriteBatch.draw(Assets.obstruction4, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
        setColor(Color.RED);
        return;
    }
    */
    paramSpriteBatch.draw(Assets.obstruction1, getX(), getY(), getWidth() / 2.0F, getHeight() / 2.0F, getWidth(), getHeight(), 1.0F, 1.0F, getRotation());
  }
  
  public Rectangle getBounds()
  {
    return this.bounds;
  }
}