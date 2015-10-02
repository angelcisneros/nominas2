/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quadrum.nominas2.servicios.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 *
 * @author vcisneros
 */
@NoArgsConstructor
public class GeneradorZip {

    @Getter
    private int partes;

    @Getter
    private String path;

    public GeneradorZip(String path) {
        this.path = path;
    }

    public boolean generarZip() {

        try {
            ZipFile folder = new ZipFile(path + "\\1.zip");
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            System.out.println(path);
            folder.addFolder(path, parameters);
//            File zipFile = new File(path + ".zip");
//            zipFile.delete();
            return true;
        } catch (ZipException ex) {
            Logger.getLogger(GeneradorZip.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;

    }

}
