/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

/**
 *
 * @author vdab
 */
public class MensException extends RuntimeException {

    /**
     * Creates a new instance of <code>MensException</code> without detail
     * message.
     */
    public MensException() {
    }

    /**
     * Constructs an instance of <code>MensException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MensException(String msg) {
        super(msg);
    }
}
