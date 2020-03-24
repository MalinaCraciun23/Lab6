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
public class AddCommand implements Command {

    public List<String> commandArgs;

    public AddCommand() {
        super();
    }

    @Override
    public void setArguments(List<String> commandArgs) {

        this.commandArgs = commandArgs;
    }

    @Override
    public void executeCommand(Catalog catalog) throws InvalidArgsException {
        if (commandArgs.size() < 4) {
            throw new InvalidArgsException();
        } else {
            catalog.add(new Document(commandArgs.get(1), commandArgs.get(2), commandArgs.get(3)));
        }

    }

}
