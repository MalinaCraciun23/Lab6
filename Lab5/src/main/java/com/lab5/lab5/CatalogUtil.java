/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab5.lab5;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {
        try ( ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        try {
            Catalog catalog;
            try ( FileInputStream file = new FileInputStream(path);  ObjectInputStream in = new ObjectInputStream(file)) {
                catalog = (Catalog) in.readObject();
            }
            return catalog;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
        return null;
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        String location = doc.getLocation();
        if (location.matches("^(https?|ftp)://.*$")) {
            try {
                URI uri = new URI(location);
                desktop.browse(uri);
            } catch (URISyntaxException | IOException e) {
                System.err.println(e);
            }
        } else {
            try {
                File file = new File(location);
                desktop.open(file);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
