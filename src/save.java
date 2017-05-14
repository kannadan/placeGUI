import java.util.ArrayList;

/**
 * Created by Joonas on 13.5.2017.
 */
public class save {

    public save(client talker, ArrayList<String> moves, String name){
        int xMin = 53;
        int yMin = 71;
        String[] line;
        String color;
        int x, y;
        for (int i = 0; i < moves.size(); i++){
            line = moves.get(i).split(" ");
            line = line[0].split("-");
            x = Integer.parseInt(line[0]);
            y = Integer.parseInt(line[1]);
            if (xMin > x){
                xMin = x;
            }
            if (yMin > y){
                yMin = y;
            }
        }
        if (xMin != 0 || yMin != 0) {
            for (int i = 0; i < moves.size(); i++) {
                line = moves.get(i).split(" ");
                System.out.print(line[1] + "\n");
                color = line[1];
                line = line[0].split("-");
                x = Integer.parseInt(line[0])-xMin;
                y = Integer.parseInt(line[1])-yMin;
                moves.set(i, x + "-" + y + " " + color);
            }
        }


        System.out.print("Starting saving\n");
        int size = moves.size();
        System.out.print(Integer.valueOf(size));
        for (int i = 0; i<size;i++){
            if (i == size-1){
                System.out.print(moves.get(i));
                talker.send("!Save " + moves.get(i) + " " + name + " STAPH"+ "\r\n");
            }
            else{
                talker.send("!Save " + moves.get(i) + " " + name + " GO"+ "\r\n");
            }
        }
    }
}
