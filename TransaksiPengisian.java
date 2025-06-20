public class TransaksiPengisian {
    Kendaraan kendaraan;
    BBM bbm;
    double liter;
    double totalBayar;

    public TransaksiPengisian(Kendaraan kendaraan, BBM bbm, double liter){
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        totalBayar = bbm.hargaPerliter * liter;
    }
}
