/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

/**
 *
 * @author vcisneros
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

public class ManejadorArchivos {

    public static boolean eliminarDirectorio(String path) {
        File logo = new File(path);
        if (!logo.isDirectory()) {
            return false;
        }
        if (!logo.exists()) {
            return false;
        }
        borraArchivos(logo);
        logo.deleteOnExit();
        return logo.delete();
    }

    private static void borraArchivos(File directortioLogo) {
        File[] ficheros = directortioLogo.listFiles();
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isDirectory()) {
                borraArchivos(ficheros[i]);
            } else {
                ficheros[i].delete();
            }
        }
    }

    public static byte[] ImagenToArreglo(String path)
            throws Exception {
        File logo = new File(path);
        FileInputStream fis = null;
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(logo);
            bos = new ByteArrayOutputStream();
            byte[] buf = new byte['?'];
            int readNum;
            while ((readNum = fis.read(buf)) != -1) {
                bos.write(buf, 0, readNum);
            }
            bytes = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger("ByteArrayImageSource").log(Level.SEVERE, null, ex);
        } finally {
            fis.close();
            bos.close();
            logo = null;
            fis = null;
            bos = null;
        }
        return bytes;
    }

    public static String convertStreamToString(InputStream is)
            throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char['?'];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        }
        return "";
    }

    public static void escribirArchivo(File f, String contenido) {
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(contenido);

            wr.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            f = null;
        }
    }

    public static boolean escribirArchivo(File file, byte[] contenido) {
        boolean correcto = false;
        try {
            OutputStream out = new FileOutputStream(file);
            out.write(contenido);
            out.close();
            correcto = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return correcto;
    }

    public static boolean crearArchivoContenido(String path, byte[] contenido) {
        boolean correcto = false;
        File file = new File(path);
        try {
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            out.write(contenido);
            out.close();
            correcto = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return correcto;
    }

    public static byte[] convierteArchivoToArregloBytes(File file) {
        byte[] archivo = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte['?'];
            int readNum;
            while ((readNum = fis.read(buf)) != -1) {
                bos.write(buf, 0, readNum);
            }
            archivo = bos.toByteArray();
            bos.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return archivo;
    }

    public static String subirImagen(MultipartFile imagen, String path) {
        try {
            crearArchivoContenido(path, imagen.getBytes());
            return "1";
        } catch (IOException ex) {
            Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }

    public static void borrarArchivosAndContenido(File carpeta) {
        for (File archivo : carpeta.listFiles()) {
            if (archivo.isDirectory()) {
                borrarArchivosAndContenido(archivo);
            } else {
                archivo.delete();
            }
        }
        carpeta.delete();
    }
    
    public static boolean crearPath(String path){
        File file = new File(path);
        if(file.exists())
            return true;
        return file.mkdirs();
    }
}
