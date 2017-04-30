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

/**
 * Generic options-related exception class.
 * 
 * Constructor can specify an 'origin', which creates and stores a more specific
 * exception as an 'inner' exception.
 * 
 * @author Wade Harkins (vdtdev@gmail.com)
 */
public class OptionsException extends Exception {
    
    public static enum ExceptionOrigin {
        PACK,
        PROCESS,
        GENERIC
    }
    
    private ExceptionOrigin origin;
    private Exception innerException = null;
    
    /**
     * Accessor for exception origin property
     * @return Exception Origin indicated as enum value
     */
    public ExceptionOrigin getOrigin(){
        return this.origin;
    }
    
    /**
     * Accessor for inner exception
     * @return Inner exception, if any. Defaults to null
     */
    public Exception getInnerException(){
        return this.innerException;
    }
    
    /**
     * No-argument constructor for generic exceptions
     */
    public OptionsException(){
        this(ExceptionOrigin.GENERIC);
    }
    
    /**
     * Exception constructor with a specific origin but no message
     * @param origin Exception origin
     */
    public OptionsException(ExceptionOrigin origin){
        this(origin, null);
    }
    
    /**
     * Exception constructor with a specific origin and message
     * @param origin Exception origin
     * @param message Exception message
     */
    public OptionsException(ExceptionOrigin origin, String message) {
        this.origin = origin;
        switch(origin){
            case PACK:
                this.innerException = new OptionsNotProcessedException();
                break;
            case PROCESS:
                if(message == null){
                    this.innerException = new OptionsProcessingException();
                } else {
                    this.innerException = new OptionsProcessingException(message);
                }
        }
    }
    
    /**
     * Exception indicating {@code pack} being used before options were parsed
     * @see OptionsException
     */
    public static class OptionsNotProcessedException extends Exception {
        public OptionsNotProcessedException(){
            super("Pack called before CLI arguments were processed.");
        }
    }
    
    /**
     * Exception indicating an error in processing options from CLI arguments
     * @see OptionsException
     */
    public static class OptionsProcessingException extends Exception {
        public OptionsProcessingException(){
            this("Unknown");
        }
        public OptionsProcessingException(String details){
            super(String.format("Error occured while processing CLI arguments: %s", details));
        }
    }
    
}
