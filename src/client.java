/**
 * Created by Joonas on 11.5.2017.
 */
import java.io.*;
import java.net.*;

public class client {

    DataOutputStream dout;
    OutputStream out;

    public client(){
        try{

            Socket soc=new Socket("localhost",2014);
            //dout=new DataOutputStream(soc.getOutputStream());
            out =soc.getOutputStream();


        }catch(Exception e){
            e.printStackTrace();}
    }

    public void send(String mes){
        try{
            /*dout.writeUTF(mes);
            dout.flush();*/
            out.write(mes.getBytes("UTF-8"));
            out.flush();

        }catch(Exception e){
            e.printStackTrace();}
    }


}
