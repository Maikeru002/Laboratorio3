package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    public ArrayList<Integer> idPeople = new ArrayList<Integer>();


    public boolean duplicated (int idPerson){
        int aux = 0;
        
        boolean result = false;
        for(int i = 0; i < idPeople.size(); i++){
            if(idPerson == idPeople.get(i)){
                return true;
            }
        }
        return result;
    }
    public RegisterResult registerVoter(Person p) {

        RegisterResult result = RegisterResult.VALID; 
        if (p.getAge() < 18) {
            result =  RegisterResult.UNDERAGE;
        }
        if (p.isAlive() == false) {
            result =  RegisterResult.DEAD;
        }
        if (p.getAge() < 0) {
            result =  RegisterResult.INVALID_AGE;
        }
        System.out.println("prueba"+idPeople);
        System.out.println(duplicated(p.getId()));

        if (duplicated(p.getId())) {
            result =  RegisterResult.DUPLICATED ;
        }
        if(result == RegisterResult.VALID){
            idPeople.add(p.getId());
        }        
        return result;
    } 
}