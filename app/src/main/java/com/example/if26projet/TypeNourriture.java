package com.example.if26projet;

import androidx.annotation.NonNull;

import java.util.EnumMap;

public interface TypeNourriture {

    enum Viande implements TypeNourriture{
        POULET,
        BOEUF,
        PORC,
        CREVETTE,
        CANARD,
        CALAMARS,
        GRENOUILLES,
        GAMBAS,
        TOFU;

        public static EnumMap PrixMapViande(){
            EnumMap<Viande, Double> enumMap=new EnumMap<>(Viande.class);
            enumMap.put(POULET,11.8);
            enumMap.put(BOEUF,10.8);
            enumMap.put(PORC,10.8);
            enumMap.put(CREVETTE,11.8);
            enumMap.put(CANARD,12.8);
            enumMap.put(CALAMARS,12.8);
            enumMap.put(GRENOUILLES,13.8);
            enumMap.put(GAMBAS,14.8);
            enumMap.put(TOFU,12.8);
            return enumMap;
        }

        @Override
        public String toString() {

            return "{Viande},{" +Viande.PrixMapViande().toString()+"}";
        }

    }


    enum Legume implements TypeNourriture{

        POIVRONS,
        ONIONS,
        CHOUX,
        MAIS,
        CHAMPIGNONS,
        CAROTTES;



        @Override
        public String toString() {
            return "Legume";
        }
    }

    enum Sauce implements TypeNourriture{
        SAUCE_HUILE,
        SOJA,
        CURRY,
        PIQUANTE,
        SATE,
        SEL_ET_POIVRE,
        AU_POIVRE,
        CARAMEL,
        AGRE_DOUCE,
        LAIL_ET_BEURRE;

        @Override
        public String toString() {
            return "Sauce{}";
        }
    }
}
