/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bidcomstore;

import java.io.Serializable;

/**
 *
 * @author Ramiro
 */
public abstract class Usuario implements Serializable {
    private String username;
    private String password;

    public Usuario(String username, String password) {
        setUsername(username);
        setPassword(password);
    }
    public Usuario(){}
    
    public abstract boolean menu(SistemaBidCom sistema);
    
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString() {
        return getUsername();
    }
    
}
