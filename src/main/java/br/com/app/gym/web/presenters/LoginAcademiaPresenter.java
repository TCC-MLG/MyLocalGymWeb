/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.app.gym.web.presenters;

import br.com.app.gym.web.model.Academia;

/**
 *
 * @author Matheus
 */
public class LoginAcademiaPresenter {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public Academia convert(){
        
        Academia academia = new Academia();
        
        academia.setId(this.id);
        
        return academia;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
}
