package br.com.json;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class escreveJson {

    public static void main(String[] args) throws Exception {

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Junio");
        usuario1.setSenha("123");
        usuario1.setCpf("123.456");
        usuario1.setEmail("junin@yahoo.com.br");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Jamilto");
        usuario2.setSenha("456");
        usuario2.setCpf("789.012");
        usuario2.setEmail("jamilto@yahoo.com.br");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonUser = gson.toJson(usuarios);

        System.out.println(jsonUser);

        FileWriter escreveArquivo = new FileWriter("C:\\Users\\PICHAU\\Documents\\jsonarq.json");
        escreveArquivo.write(jsonUser);
        escreveArquivo.flush();
        escreveArquivo.close();

        /*____________________________________________LER ARQUIVO_________________________________________________*/

        FileReader leArquivo = new FileReader("C:\\Users\\PICHAU\\Documents\\jsonarq.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(leArquivo);

        List<Usuario> usuarioList = new ArrayList<Usuario>();

        for (JsonElement jsonElement : jsonArray) {

            Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
            usuarioList.add(usuario);
        }

        System.out.println("Leitura de arquivo JSON: " + usuarioList);
    }
}