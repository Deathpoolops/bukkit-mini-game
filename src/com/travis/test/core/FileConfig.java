package com.travis.test.core;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by travisws on 11/14/15.
 */
public class FileConfig {

    ModelObject modelObject = new ModelObject("Travis", 10, true, 4.8);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(modelObject);

    public void FileTester() {
        //TODO add json config file

        try {
            //Todo rename to plugin name
            //write converted json data to a file named "CountryGSON.json"
            FileWriter writer = new FileWriter("CountryGSON.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class ModelObject {
        String name;
        transient int val;
        boolean status;
        double f;

        public ModelObject(String name, int val, boolean status, double f) {
            super();
            this.name = name;
            this.val = val;
            this.status = status;
            this.f = f;
        }

        @Override
        public String toString() {
            return "ModelObject [name=" + name + ", val = " + val + ", status = " + status + ", f=" + f + "]";
        }
    }

    public static void GetSpawn() {

    }
}