class Coffre {

    private int nombreSurLeCadran = 50;

    public int tournerADroite(final int nomBreDeCliques) {
        nombreSurLeCadran = (100 + nombreSurLeCadran + nomBreDeCliques) % 100;
        return nombreSurLeCadran;
    }

    public int tournerAGauche(final int nomBreDeCliques) {
        nombreSurLeCadran = (100 + nombreSurLeCadran - nomBreDeCliques) % 100;
        return nombreSurLeCadran;
    }
}
