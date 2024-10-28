package com.kca.web.app;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY
            = Persistence.createEntityManagerFactory("my_persistence_unit");

    public static EntityManagerFactory get() {
        return ENTITY_MANAGER_FACTORY;
    }
}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.kca.web.app;
//
///**
// *
// * @author moses-imbahale
// */
//public class EMF {
//    
//}

