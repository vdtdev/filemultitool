/*
 * The MIT License
 *
 * Copyright 2017 vdtdev@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.vdt.filemt;

import com.vdt.filemt.util.OptionsMap;
import com.vdt.filemt.util.OptionsProcessor;

/**
 *
 * Contains entry point and logic for initializing command-line argument
 * processing.
 *
 * @author Wade Harkins (vdtdev@gmail.com)
 */
public class Launcher {

    private OptionsMap options = null;
    
    /**
     * Static entry-point
     *
     * @param args Array of CLI arguments passed on execution
     */
    public static void main(String[] args) {
        OptionsProcessor optionsProc = new OptionsProcessor(args);
        OptionsMap options = null;

        boolean hasOptions = false;

        try {
            hasOptions = optionsProc.process();
        } catch (OptionsProcessor.OptionsParseException exception) {
            printException(exception);
        }

        // If options are present, pack them
        if (hasOptions) {
            // Try to pack parsed options
            try {
                options = optionsProc.pack();
            } catch (OptionsProcessor.OptionsNotParsedException exception) {
                printException(exception);
            }
        }
        // Instansiate Launcher with options map
        new Launcher(options);
    }

    /**
     * Constructor for Launcher that starts application
     * @param options Processed map of CLI args as options
     */
    public Launcher(OptionsMap options) {
        this.options = options;
        printBanner();
    }

    public void printBanner(){
        System.out.printf("File Multi-Tool v%1$d.%2$dr%3$d\n");
    }
    
    /**
     * Static method for displaying exception error messages to user in CLI
     *
     * @param exception Exception to display
     */
    public static void printException(Exception exception) {
        System.out.printf("Exception caught: \n\t%s\n", exception.getMessage());
    }

}
