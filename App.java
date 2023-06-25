package track;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    String[] lines = getStdin();
    int[] gardens = parseInput(lines);
    int[] greennessOnOtherSide = calculateGreennessOnOtherSide(gardens);
    for(int i = 0; i < greennessOnOtherSide.length; i++) {
      System.out.println(greennessOnOtherSide[i]);
    }
  }

  private static String[] getStdin() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> lines = new ArrayList<>();
    while (scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }
    return lines.toArray(new String[lines.size()]);
  }
  
  private static int[] parseInput(String[] lines) {
    int[] gardens = new int[lines.length - 1];
    for (int i = 1; i < lines.length; i++) {
      gardens[i - 1] = Integer.parseInt(lines[i]);
    }
    return gardens;
  } 
  
  private static int[] calculateGreennessOnOtherSide(int[] gardens) {
    int[] greennessOnOtherSide = new int[gardens.length];
    
    if (gardens.length == 1) {
      greennessOnOtherSide[0] = gardens[0];
    } else {
      greennessOnOtherSide[0] = gardens[1];
      greennessOnOtherSide[gardens.length - 1] = gardens[gardens.length - 2];
      
      for (int i = 1; i < gardens.length - 1; i++) {
        greennessOnOtherSide[i] = Math.max(gardens[i - 1], gardens[i + 1]);
      }
    }
    
    return greennessOnOtherSide;
  }
}
