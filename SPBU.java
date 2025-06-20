import java.util.Scanner;
public class SPBU {
    public static void main(String[] args) {
        AntrianLinkedList antrian = new AntrianLinkedList();
        QueueTransaksi riwayat = new QueueTransaksi(100);
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraaan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Tampilkan banyaknya tipe kendaraan tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch(pilihan) {
                case 1 -> {
                    String namaJenis;
                    System.out.print("Masukkan Plat Nomor         : ");
                    String plat = sc.nextLine();
                    System.out.println("Masukkan Jenis Kendaraan    : ");
                    System.out.println("1. Mobil");
                    System.out.println("2. Motor");
                    System.out.print("Pilih Jenis Kendaraan (1/2): ");
                    int jenis = sc.nextInt();
                    sc.nextLine();
                    if (jenis == 1) {
                        namaJenis = "Mobil";
                    } else if (jenis == 2) {
                        namaJenis = "Motor";
                    } else {
                        System.out.println("Jenis kendaraan tidak valid. Silakan coba lagi.");
                        continue;
                    }
                    System.out.print("Masukkan Merk Kendaraan     : ");
                    String merk  = sc.nextLine();
                    
                    Kendaraan kendaraan = new Kendaraan(plat, namaJenis, merk);
                    antrian.enqueue(kendaraan);
                    System.out.println(">> Kendaraan masuk ke dalam antrian.");
                    break;
                }
                case 2 -> {
                    antrian.print();
                    break;
                }
                case 3 -> {
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrian.jumlahAntrian());
                    break;
                }
                case 4 -> {
                    if (antrian.isEmpty()) {
                        System.out.println(">> Tidak ada kendaraan dalam antrian.");
                        return;
                    }

                    int pilihanBBM;
                    Kendaraan kendaraan = antrian.layaniKendaraan();
                    System.out.println("Petugas melayani " + kendaraan.platNomor);
                    
                    do {
                        System.out.println("\n-- Pilih Jenis BBM --");
                        System.out.println("1. Pertalite - Rp 10.000/liter");
                        System.out.println("2. Pertamax - Rp 12.000/liter");
                        System.out.println("3. Solar - Rp 14.000/liter");
                        System.out.println("0. Kembali ke Menu Utama");
                        System.out.print("Pilihan BBM: ");
                        pilihanBBM = sc.nextInt();
                        
                        if (pilihanBBM == 0) {
                            return;
                        }
                        
                        if (pilihanBBM < 1 || pilihanBBM > 3) {
                            System.out.println(">> Pilihan tidak valid. Silakan pilih 1-3.");
                        }
                    } while (pilihanBBM < 1 || pilihanBBM > 3);

                    String namaBBM = "";
                    double hargaPerLiter = 0;
                    
                    switch(pilihanBBM) {
                        case 1:
                            namaBBM = "Pertalite";
                            hargaPerLiter = 10000;
                            break;
                        case 2:
                            namaBBM = "Pertamax";
                            hargaPerLiter = 12000;
                            break;
                        case 3:
                            namaBBM = "Solar";
                            hargaPerLiter = 14000;
                            break;
                    }
                    
                    double liter = 0;
                    while (true) {
                        System.out.print("Masukkan jumlah liter: ");
                        liter = sc.nextDouble();

                        if (liter <= 0) {
                            System.out.println(">> Jumlah liter tidak valid. Silakan coba lagi.");
                        } else {
                            break;
                        }
                    }

                    BBM bbm = new BBM(namaBBM, hargaPerLiter);
                    TransaksiPengisian transaksi = new TransaksiPengisian(kendaraan, bbm, liter);
                    riwayat.inputTransaksi(transaksi);
                    System.out.println(">> Transaksi berhasil dilayani.");
                    break;
                }
                case 5 -> {
                    riwayat.tampilkanRiwayat();
                    break;
                }
                case 6 -> {
                    System.out.println("Masukkan Jenis Kendaraan    : ");
                    System.out.println("1. Mobil");
                    System.out.println("2. Motor");
                    System.out.print("Pilih Jenis Kendaraan (1/2): ");
                    int jenis = sc.nextInt();
                    sc.nextLine();
                    String tipe;
                    if (jenis == 1) {
                        tipe = "Mobil";
                    } else if (jenis == 2) {
                        tipe = "Sepeda Motor";
                    } else {
                        System.out.println("Pilihan tidak valid.");
                        break;
                    }
                    antrian.tampilkanKendaraanBerdasarkanTipe(tipe);
                    break;
                }
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Menu tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}