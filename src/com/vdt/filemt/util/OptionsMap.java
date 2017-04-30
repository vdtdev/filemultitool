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
 * Minimal class extending HashMap used for transporting processed CLI
 * arguments, along with additional information
 *
 * @author Wade Harkins (vdtdev@gmail.com)
 */
public class OptionsMap extends HashMap<String, Object> {

    private String[] source = new String[]{};

    /**
     * Setter method for CLI arguments source string array
     *
     * @param source New value of source string array
     */
    public void setSource(String[] source) {
        this.source = source;
    }

    /**
     * Getter method for CLI arguments source string array
     *
     * @return Current source string array value
     */
    public String[] getSource() {
        return this.source;
    }

    /**
     * Copy-constructor for OptionsMap, accepting a source HashMap and original
     * argument string array
     *
     * @param options HashMap containing processed options from CLI arguments
     * @param source Array of original CLI arguments
     */
    public OptionsMap(HashMap<String, Object> options, String[] source) {
        for (Map.Entry<String, Object> option : options.entrySet()) {
            this.put(option.getKey(), option.getValue());
        }
        this.setSource(source);
    }

    /**
     * Static 'constructor' that casts source HashMap to OptionsMap and stores
     * source argument array
     *
     * @param options HashMap containing processed options from CLI arguments
     * @param source Array of original CLI arguments
     * @return Newly cast OptionsMap
     */
    public static OptionsMap fromHashMap(HashMap<String, Object> options,
            String[] source) {
        OptionsMap newInstance = (OptionsMap) options;
        newInstance.setSource(source);
        return newInstance;
    }

}
