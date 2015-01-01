import beads.*;

class PlaySample implements Element {
  String fileName;
  float gain;
  
  PlaySample(String fileName, float gain) {
    this.fileName = fileName;
    this.gain = gain;
  }
  
  public void play(AudioContext ac) {
    SamplePlayer sp = new SamplePlayer(ac, SampleLibrary.get(fileName));
    Gain g = new Gain(ac, 1, gain);
    sp.setKillOnEnd(true);
    g.addInput(sp);
    sp.setToLoopStart();
    ac.out.addInput(g);
    sp.start();
  }
}
