/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.ejb.ApplicationException;

/**
 *
 * @author ivanb
 */

@ApplicationException(rollback = true)
public class ServicioException extends Exception {
    
    public ServicioException(String s) {
        super(s);
    }
}
