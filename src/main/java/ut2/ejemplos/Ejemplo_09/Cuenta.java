package ut2.ejemplos.Ejemplo_09;

public class Cuenta {
    private int saldo;

    public Cuenta(int s){
        saldo = s;
    }

    public synchronized int getSaldo(){
        return saldo;
    }

    public synchronized void restar(int cantidad){
        saldo = saldo - cantidad;
    }

    public synchronized void retirarDinero(int cant, String nom){
    //public void retirarDinero(int cant, String nom){
        if(getSaldo() >= cant){
            System.out.println(nom + ": Va a retirar saldo (actual es: " + getSaldo() +")");
            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            restar(cant);

            System.out.println("\t" + nom + " retira => " + cant + " ACTUAL(" + getSaldo() + ")");
        }else{
            System.out.println(nom + " No puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
        }
        if(getSaldo() < 0){
            System.out.println("SALDO NEGATIVO => " + getSaldo());
        }
    }
}
