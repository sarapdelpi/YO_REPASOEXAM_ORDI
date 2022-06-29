package ufv.dis.final2022.SPP;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorJson {

    public ArrayList<IP> LecturaJSON(){
        String json;
        ArrayList<IP> Datas = new ArrayList<>();
        //Data datosPadre = new Data();

        Gson gson = new Gson();

        json = "";

        try (BufferedReader br = new BufferedReader(new FileReader("LocalizaIP.json"))){
            String linea;

            while ((linea = br.readLine()) != null){
                json+= linea;
                System.out.println(linea);
            }

            Datas = gson.fromJson(json, ArrayList.class);
            System.out.println("Sesion guardada con exito");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Datas;
    }
}
