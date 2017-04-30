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
package com.vdt.filemt.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Interprets CLI arguments and encapsulates them for transportation
 *
 * @author Wade Harkins (vdtdev@gmail.com)
 */
public class OptionsProcessor {

    private HashMap<String, Object> options;
    private String[] source;

    private boolean isProcessed = false;

    public OptionsProcessor(String[] arguments) {
        this.source = arguments;
    }

    /**
     * Process options from CLI arguments
     *
     * @return Boolean indicating whether operation yielded any results; is true
     * if created options hash contains {@code > 0} keys, false otherwise.
     * 
     * @throws com.vdt.filemt.util.OptionsProcessor.OptionsParseException
     */
    public boolean process() throws OptionsParseException {
        this.isProcessed = false; // reset processed var in case interrupted
        this.options = new HashMap<>();

        // TODO: Process CLI arguments into options map
        
        this.isProcessed = true; // indicate processing completed
        return (this.options.size() > 0);
    }

    /**
     * Store option information in an OptionsMap instance for transport
     *
     * @return OptionsMap containing processed option information
     * @throws OptionsNotParsedException
     */
    public OptionsMap pack() throws OptionsNotParsedException {
        if (isProcessed) {
            OptionsMap map = OptionsMap.fromHashMap(options, source);
            return map;
        } else {
            throw new OptionsNotParsedException();
        }
    }

    /**
     * Exception indicating {@code pack} was called before CLI arguments were
     * processed
     */
    public static class OptionsNotParsedException extends Exception {

        public OptionsNotParsedException() {
            super("CLI arguments have not been processed, unable to pack");
        }
    }

    /**
     * Exception indicating an error while processing options from CLI arguments
     */
    public static class OptionsParseException extends Exception {

        public OptionsParseException() {
            this("Unknown");
        }

        public OptionsParseException(String details) {
            super(String.format(
                    "Error processing options from CLI arguments: %s", details)
            );
        }
    }

}
