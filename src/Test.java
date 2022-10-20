import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test {

  public static void main(String[] args){

    LinkedList<String> ceilingFan = new LinkedList<>();
    ceilingFan.add("speed 0 - Off");
    ceilingFan.add("speed 1");
    ceilingFan.add("speed 2");
    ceilingFan.add("speed 3");
    String nextSpeed = getNextFanSpeed(ceilingFan, 0, true);
    System.out.println(nextSpeed);
  }

  static String getNextFanSpeed(List<String> fan, int position, boolean reversed) {

    String errorMessage = validateInput(fan, position);
    if(errorMessage.isEmpty()){
      LinkedList<String> ceilingFan = (LinkedList<String>) fan;
      ListIterator<String> cord = ceilingFan.listIterator(position);

      if(!reversed){
        if(!cord.hasNext()){
          return ceilingFan.getFirst();
        }
        else {
          return cord.next();
        }
      }
      else {
        if(!cord.hasPrevious()){
          return ceilingFan.getLast();
        }
        else{
          return cord.previous();
        }
      }
    }
    else{
      return errorMessage;
    }

  }

  private static String validateInput(List<String> fan, int position) {
    String errorMessage = "";
    if(position < 0 || position > 3) {
      errorMessage =  "Unavailable Speed";
    }
    if(fan == null || fan.isEmpty()){
      errorMessage =  "Invalid Fan";
    }
    return errorMessage;
  }

}
