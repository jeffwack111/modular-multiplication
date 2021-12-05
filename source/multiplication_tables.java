import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class multiplication_tables extends PApplet {



float pi = 3.141592653589793238462643383279f;
int b = 1;
int n = 1;
int z = 1;
int t = 1;
String input = "";
IntList Full = new IntList();;
IntList Last = new IntList();



public void setup() {
  
  colorMode(HSB,1);
  strokeWeight(5);
  noStroke();
  textAlign(CENTER, CENTER);
  textSize(20);
}

public void draw(){
int u = 0;
Full = new IntList();
Last = new IntList();

for(int j=0; j<n; j++){
  int v = 0;
    for(int k=0; k<n; k++){
      Full.append(v);
      v = u + v;
      v = v%n;
    }
  u++;
}    

for(int k=0; k<Full.size(); k++){
  int v = Full.get(k);
  if (v == 0){
    Last.append(k);
  }
  else{
    fill(PApplet.parseFloat(v)/n,1,1);
    rect((k%n)*1000/(n),(k/n)*1000/(n),1000/(n)+1,1000/(n)+1);
    if(t==1){
      stroke(0,0,0);
      fill(0,0,0);
      text(v,(k%n)*1000/(n)+500/n,(k/n)*1000/(n)+500/n);
    }
    noStroke();
  }
  
  
}
fill(0,1,1);
for(int j=0; j<Last.size(); j++){
  int k = Last.get(j);
  if(z==1){
    stroke(0,0,0);
    //fill(0,0,0);
  }
  fill(0,1,1);
  rect((k%n)*1000/(n),(k/n)*1000/(n),1000/(n)+1,1000/(n)+1);
  if(t==1){
    fill(0,0,0);
    text(0,(k%n)*1000/(n)+500/n,(k/n)*1000/(n)+500/n);
   
  }
   noStroke();
}

}


public void keyPressed(){
  if( key == 't'){
    t = t*(-1);
  }
  if( key == 'z'){
    z = z*(-1);
  }
  if( key >= '0' && key <= '9' ){
   input += key; 
  }
  if( key == ENTER || key == RETURN ){
    n = PApplet.parseInt( input );
    input = "";
  }
}

public void mousePressed(){
  int x = mouseX*n/1000;
  int y = mouseY*n/1000;
  
  println(x*y%n);
}
  public void settings() {  size(1000,1000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "multiplication_tables" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
