/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.daoTemp;
import view.telaPrincipal;

/**
 *
 * @author Luiza Mistro
 */
public class TempControl {
    
    
    daoTemp dao = new daoTemp();

    public void mostrarTemperatura() {
        telaPrincipal.jButton1.setText(dao.retornaTemperatura().toString());
        
    }
    
    
    
}
