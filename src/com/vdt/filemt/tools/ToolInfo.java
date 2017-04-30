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
package com.vdt.filemt.tools;

/**
 * Stores identifying information about a tool
 * @author Wade Harkins (vdtdev@gmail.com)
 */
public class ToolInfo {
    
    private String identifier = null;
    private String name = null;
    private String displayName = null;
    
    /**
     * Unique tool identifier
     * @return String uniquely identifying tool
     */
    public String getId() { return this.identifier; }
    /**
     * Tool name
     * @return Internal tool name
     */
    public String getName() { return this.name; }
    /**
     * Display name
     * @return Tool display name
     */
    public String getDisplayName() { return this.displayName; }
    
    
    /**
     * Shorthand constructor taking id, name and display name as an array
     * @param info Array containing id, name and display name in that order
     */
    public ToolInfo(String[] info){
        this(info[0], info[1], info[2]);
    }
    
    /**
     * Constructor for ToolInfo
     * @param id Tool identifier
     * @param name Internal name
     * @param displayName Display name
     */
    public ToolInfo(String id, String name, String displayName){
        this.identifier = id;
        this.name= name;
        this.displayName = displayName;
    }
    
}
