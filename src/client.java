/**
 * Created by Joonas on 11.5.2017.
 */
import java.io.*;
import java.net.*;

public class client {

    DataOutputStream dout;

    public client(){
        try{
            Socket soc=new Socket("localhost",2004);
            dout=new DataOutputStream(soc.getOutputStream());

        }catch(Exception e){
            e.printStackTrace();}
    }

    public void send(String mes){
        try{
            dout.writeUTF(mes);
        }catch(Exception e){
            e.printStackTrace();}
    }


}