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
public class VolumeException extends RuntimeException {

    public VolumeException() {
    }
    public VolumeException(String msg) {
        super(msg);
    }

    public VolumeException(Throwable cause) {
        super(cause);
    }

    public VolumeException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    
}
