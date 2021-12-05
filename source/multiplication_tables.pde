import processing.pdf.*;

float pi = 3.141592653589793238462643383279;
int b = 1;
int n = 1;
int z = 1;
int t = 1;
String input = "";
IntList Full = new IntList();;
IntList Last = new IntList();



void setup() {
  size(1000,1000);
  colorMode(HSB,1);
  strokeWeight(5);
  noStroke();
  textAlign(CENTER, CENTER);
  textSize(20);
}

void draw(){
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
    fill(float(v)/n,1,1);
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


void keyPressed(){
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
    n = int( input );
    input = "";
  }
}

void mousePressed(){
  int x = mouseX*n/1000;
  int y = mouseY*n/1000;
  
  println(x*y%n);
}
