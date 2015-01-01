import beads.*;
import java.util.Map;
import java.util.HashMap;

AudioContext ac;
Clock clock;


void setup() {
  size(400,400);
  
  ac = new AudioContext(); // create our AudioContext
  
  SampleLibrary.init(sketchPath(""));
  
  clock = new Clock(ac, 1000);
  Bead onTick = new Bead() {
    public void messageReceived(Bead msg) {
      kick();
    }
  };
  clock.addMessageListener(onTick);
  clock.setTicksPerBeat(8);
  ac.out.addDependent(clock);
  
  ac.start();
}

void draw() {
}

void mousePressed() {
  kick();
}

void kick() {
  println("Blaart!");
  new PlaySample(Samples.KICK_1, 0.2).play(ac);
}

