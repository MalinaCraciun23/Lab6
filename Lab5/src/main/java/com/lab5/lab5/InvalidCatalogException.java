/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab5.lab5;

public class InvalidCatalogException extends Exception {

    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
}
