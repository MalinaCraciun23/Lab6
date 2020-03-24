/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab5.lab5;

import java.util.List;

/**
 *
 * @author Mally
 */
public interface Command {

    void setArguments(List<String> commandArgs);

    void executeCommand(Catalog catalog) throws InvalidArgsException;

}
