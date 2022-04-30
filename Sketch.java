import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  
  
  // Set global variables
	PImage imgBird;
  float fltBirdX = 500;
  float fltBirdY = 500;
  boolean isUp = false;
  boolean isDown = false;
  boolean isLeft = false;
  boolean isRight = false;

  /**
   * Sets the size of the call
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void settings(){
    size(1000, 1000);
  }

  /**
   * Initializes background and loads the bird image
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void setup(){
    background(210, 255, 173);
    imgBird = loadImage("BIRD.png");
    imgBird.resize(width / 20, height / 20);
  }

  /**
   * Draws everything inside the method 60 times per second
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void draw() {
    if (keyPressed){
      if (keyCode == UP){
        fltBirdY = fltBirdY - 5;
      } 
      else if (keyCode == DOWN){
        fltBirdY = fltBirdY + 5;
      } 
      else if (keyCode == LEFT){
        fltBirdX = fltBirdX - 5;
      }
      else if (keyCode == RIGHT){
        fltBirdX = fltBirdX + 5; 
      }
    }
    if (isUp){
      fltBirdY = fltBirdY - 5;
    } 
    if (isDown){
      fltBirdY = fltBirdY + 5;
    }
    if (isLeft){
      fltBirdX = fltBirdX - 5;
    }
    if (isRight){
      fltBirdX = fltBirdX + 5;
    }
    noStroke();
    fill(210, 255, 173);
    rect(fltBirdX - 10, fltBirdY, width/15, height/15);
    image(imgBird, fltBirdX, fltBirdY);
  }
  
  /**
   * Draws a flower where the user clicks their mouse
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void mouseClicked(){
    fill(123, 232, 102);
    translate(mouseX, mouseY);    
    for (int intPetal = 0; intPetal < 8; intPetal++){
      
      // Draw 8 petals 
      strokeWeight(25);
      stroke(204, 102, 0);    
      rotate(TWO_PI/8);
      line(0, 0, (float)(width / 10), 0);
    }
    
    // Draw central circle after petals to avoid overlap
    strokeWeight(1);
    ellipse(0, 0, (float)(width / 20), (float)(height / 20));
  }


  /**
   * Draws grass where the user drags their mouse
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void mouseDragged(){
    if (mousePressed){
      fill(124, 252, 0);
      noStroke();
      rect(mouseX, mouseY, (float)(width / 200), (float)(height / 20));
    }
  }

  /**
   * Draws a cloud where the user scrolls their mouse wheel
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void mouseWheel(){

    fill(176, 224, 230);
    noStroke();
    float fltShift = 0;
    for (int intCloud = 0; intCloud < 6; intCloud++){
    ellipse(mouseX + fltShift, mouseY, (float)(width / 20), (float)(height / 20));
    ellipse(mouseX + fltShift, mouseY + (float)(height / 40), (float)(width / 20), (float)(height / 20));
    fltShift = fltShift + (float)(width / 40);
    }
  }

  /**
   * Determines if the 'w', 'a', 's', or 'd' keys are being pressed
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void keyPressed(){
    if (key == 'w'){
      isUp = true;
    }
    else if (key == 's'){
      isDown = true;
    }
    else if (key == 'a'){
      isLeft = true;
    }
    else if (key == 'd'){
      isRight = true;
    }
  }
  
  /**
   * Determines if the 'w', 'a', 's', or 'd' keys are released
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void keyReleased(){
    if (key == 'w'){
      isUp = false;
    }
    else if (key == 's'){
      isDown = false;
    }
    else if (key == 'a'){
      isLeft = false;
    }
    else if (key == 'd'){
      isRight = false;
    }
  }

}

