import java.util.Random;

public class geoLocation { //klase atsakinga uz geografiniu koordinaciu ilgumos ir platumos valdyma

    private double platuma; //saugo platuma
    private double ilguma; //saugo ilguma
    private static int numbLocations = 0; // skaiciuoja geoLocation objekto skaiciu
    private static final Random random = new Random(); //atsitiktiniam koordinaciu generavimui

    // Konstruktorius be parametru - sukuria geoLocation objekta su atsitiktinemis koord. ir padidina objekto skaiciu
    public geoLocation() {
        this.platuma = Math.round((random.nextDouble() * 180 - 90) * 1000000) / 1000000.0;
        this.ilguma = Math.round((random.nextDouble() * 180 - 90) * 1000000) / 1000000.0;
        numbLocations++;
    }

    // Konstruktorius su 2 parametrais - sukuria geoLocation objekta su nurodytomis koord. ir padidina objekto skaiciu
    public geoLocation(double platuma, double ilguma) {
        this.platuma = platuma;
        this.ilguma = ilguma;
        numbLocations++;
    }

    // Kopijavimo konstruktorius - sukuria geoLocation objekta nukopijuodamas kito objekto koord. su random pakeitimais ir padidina objekto skaiciu
    public geoLocation(geoLocation other) {
        this.platuma = Math.round((other.platuma + random.nextDouble() * 0.2 - 0.1) * 1000000) / 1000000.0; // gauname reiksmes [-0.1, 0.1], suapvaliname iki 6 sk po kabl.
        this.ilguma = Math.round((other.ilguma + random.nextDouble() * 0.2 - 0.1) * 1000000) / 1000000.0; //gauname reiksmes [-0.1, 0.1]
        numbLocations++;
    }

    // metodas objektams isvesti - Atspausdina koordinates
    public void print() {
        System.out.printf("[%f, %f]\n", platuma, ilguma);
    }

    // Gauti bendrą vietovių skaičių
    public static int getNumbLocations() {
        return numbLocations;
    }
//haversino formule - atstumo tarp 2 geografiniu vietos tasku apskaičiavimas
    public static double distance(geoLocation loc1, geoLocation loc2) {
        return geoHaversino.haversinoDistance(loc1.platuma, loc1.ilguma, loc2.platuma, loc2.ilguma);
    }


    public static void main(String[] args) { //pagrindine programos dalis
        geoLocation someLocation = new geoLocation();
        geoLocation vilnius = new geoLocation(54.683333, 25.283333);
        geoLocation kaunas = new geoLocation(54.897222, 23.886111);
        geoLocation nearVilnius = new geoLocation(vilnius);

        someLocation.print(); //geoLocation objektas
        vilnius.print(); //geoLocation objektas
        nearVilnius.print(); //geoLocation objektas

        System.out.println("Number of locations: " + geoLocation.getNumbLocations());

        System.out.println("Nuo Vilniaus iki Kauno: " + geoLocation.distance(vilnius, kaunas));
        System.out.println("Nuo Vilniaus iki atsitiktinės vietos: " + geoLocation.distance(vilnius, someLocation));
        System.out.println("Nuo Vilniaus iki atsitiktinės artimos vietovės: " + geoLocation.distance(vilnius, nearVilnius));
    }
}
