package ufv.dis.final2022.SPP;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControloadorIP {

    public ArrayList<IP> NewIP = new ArrayList<>();

////////post/////////
    @PostMapping(path = "/ip",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<IP>> nuevoEmpresa(@RequestBody IP nuevoIP) {

        /*
        LectorJSON Leer = new LectorJSON();
        DatosPadre AuxEmpresa = new DatosPadre();
        AuxEmpresa = Leer.LecturaJSON();

        this.NewDatosPadres.add(AuxEmpresa);
        */


        this.NewIP.add(nuevoIP);
        return new ResponseEntity<ArrayList<IP>>(this.NewIP, HttpStatus.CREATED);
    }

    @PostMapping(path = "/nuevaip",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<IP>> nuevoUsuario(@RequestBody IP nuevoDato) {
        this.NewIP.get(0).getIP().add(nuevoDato);
        return new ResponseEntity<ArrayList<IP>>(this.NewIP.get(0).getIP(), HttpStatus.CREATED);
    }
////////////fin post///////////////


///////////get//////////
    @GetMapping("/iP")
    public ArrayList<IP> GetIP(){return this.NewIP;}

    @GetMapping("/IP/{ip_from}")
    public ResponseEntity<IP> GetIP(@PathVariable long ip_from){

        IP auxDatos = new IP();

        for (int i = 0; i < NewIP.get(0).getIP().size(); i++) {
            if (NewIP.get(0).getIP().get(i).getIp_from() == ip_from) {
                auxDatos = NewIP.get(0).getIP().get(i);
                return new ResponseEntity<IP>(auxDatos, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
///////////////fin get////////////////



}
