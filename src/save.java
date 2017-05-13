import java.util.ArrayList;

/**
 * Created by Joonas on 13.5.2017.
 */
public class save {

    public save(client talker, ArrayList<String> moves, String name){
        System.out.print("Starting saving\n");
        int size = moves.size();
        System.out.print(Integer.valueOf(size));
        for (int i = 0; i<size;i++){
            if (i == size-1){
                talker.send("!Save " + moves.get(i) + " " + name + " STAPH"+ "\r\n");
            }
            else{
                talker.send("!Save " + moves.get(i) + " " + name + " GO"+ "\r\n");
            }
        }
    }

}
