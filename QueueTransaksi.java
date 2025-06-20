public class QueueTransaksi {
    TransaksiPengisian[] data;
    int front;
    int rear;
    int size;
    int max;

    public QueueTransaksi(int max){
        this.max = max;
        this.data = new TransaksiPengisian[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty(){
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull(){
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void inputTransaksi(TransaksiPengisian transaksi){
        if (isFull()) {
            System.out.println("Transaksi sudah penuh. Tidak dapat menambah transaksi");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = transaksi;
        size++;
    }

    public void tampilkanRiwayat(){
        if (isEmpty()) {
            System.out.println("Riwayat transaksi kosong.");
            return;
        }
        System.out.println("\n--- Riwayar Transaksi ---");
        System.out.println("Daftar Transaksi:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.println(data[index].kendaraan.platNomor + ": Rp " + data[index].totalBayar);
        }
    }
}
