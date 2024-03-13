package global;

public enum Contrainte {

    ALCOOLISE, SANS_ALCOOL, GLUTEN, LACTOSE, FRUCTOSE, HISTAMINE, ADDITIF , FRUIT_COQUE, SUCREE, SALE;

    public static Contrainte getContrainte(String contrainte){
        for(Contrainte c : Contrainte.values()){
            if(c.name().equalsIgnoreCase(contrainte)){
                return c;
            }
        }
        return null;
    }
}
