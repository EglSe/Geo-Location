public class geoHaversino {

        public static double haversinoDistance(double platuma1, double ilguma1, double platuma2, double ilguma2) {
        final int R = 6371; // zemės spindulys kilometrais

        double platumosDistance = Math.toRadians(platuma2 - platuma1);
        double ilgumosDistance = Math.toRadians(ilguma2 - ilguma1);

        double a = Math.sin(platumosDistance / 2) * Math.sin(platumosDistance / 2)
                + Math.cos(Math.toRadians(platuma1)) * Math.cos(Math.toRadians(platuma2))
                * Math.sin(ilgumosDistance / 2) * Math.sin(ilgumosDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.round(R * c * 10) / 10.0; // apvalina vienas sk po kablelio
    }
}

