import beads.*;
import java.util.*;

class SampleLibrary {
  static SampleLibrary instance;

  Map smap = new HashMap();
  
  private SampleLibrary(String sketchPath) {
    loadSamples(sketchPath);
  }
  
  static void init(String sketchPath) {
    instance = new SampleLibrary(sketchPath);
  }

  void loadSamples(String sketchPath) {
    try {
      // FIXME: could we enumerate the sample names automatically?
      loadSample(sketchPath, Samples.KICK_1);
    } catch (Exception e) {
      System.out.println("Exception: " + e.toString());
      //exit();
    }
  }
  
  void loadSample(String sketchPath, String fileName) throws Exception {
    Sample s = new Sample(sketchPath + "Samples/" + fileName);
    smap.put(fileName, s);
  }
  
  static Sample get(String fileName) {
    return (Sample) instance.smap.get(fileName);
  }
}
