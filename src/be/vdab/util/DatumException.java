/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author vdab
 */
public class DatumException extends RuntimeException {

    /**
     * Creates a new instance of <code>DatumException</code> without detail
     * message.
     */
    public DatumException() {
    }

    /**
     * Constructs an instance of <code>DatumException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DatumException(String msg) {
        super(msg);
    }

    public DatumException(Throwable cause) {
        super(cause);
    }

    public DatumException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    
    
}
