/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab5.lab5;

/**
 *
 * @author Mally
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Shell {

    private Map<String, Command> commands;
    private Catalog catalog;

    public Shell(Catalog catalog) {
        this.catalog = catalog;
        commands = new HashMap<String, Command>();

        commands.put("add", new AddCommand());
    }

    public void initiate() {
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] auxArgs = line.split(" ");
            List<String> commandArgs = Arrays.asList(auxArgs);

            try {
                this.runCommand(commandArgs);
            } catch (InvalidArgsException e) {
                System.err.println(e);
            }
        }
    }

    private void runCommand(List<String> commandArgs) throws InvalidArgsException {
        if (commandArgs.isEmpty()) {
            throw new InvalidArgsException();
        } else {
            commands.get(commandArgs.get(0)).setArguments(commandArgs);
            commands.get(commandArgs.get(0)).executeCommand(catalog);
        }
    }
}
