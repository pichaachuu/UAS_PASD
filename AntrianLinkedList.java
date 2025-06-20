public class AntrianLinkedList {
    NodeKendaraan head;
    NodeKendaraan tail;
    int size;
    static int motor = 0;
    static int mobil = 0;

    public AntrianLinkedList(){
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(Kendaraan kendaraan){
        NodeKendaraan data = new NodeKendaraan(kendaraan, null);
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
        if(tail.data.tipe.equalsIgnoreCase("Sepeda Motor")){
            motor++;
        } else if(tail.data.tipe.equalsIgnoreCase("Mobil")){
            mobil++;
        } else{
            System.out.println("Kendaraan tidak tersedia");
        }
    }

    public void print(){
        if (!isEmpty()) {
            NodeKendaraan tmp = head;
            System.out.println("\n--- Antrian Kendaraan ---");
            System.out.println("Antrian Kendaraan:");
            while (tmp != null) {
                tmp.data.tampilkanInformasi();
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public int jumlahAntrian(){
        return size;
    }

    public Kendaraan layaniKendaraan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada kendaraan untuk dilayani.");
            return null;
        }
        Kendaraan kendaraan = head.data;
        if(kendaraan.tipe.equalsIgnoreCase("Sepeda Motor")){
                motor--;
            } else if(kendaraan.tipe.equalsIgnoreCase("Mobil")){
                mobil--;
            } else{
                System.out.println("Data Kendaraan Tidak Tersedia");
            }
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return kendaraan;
    }

    public String getTipe(){
        return head.data.tipe;
    }

    public void tampilkanKendaraanBerdasarkanTipe(String tipe) {
        NodeKendaraan current = head;
        
        System.out.println("Daftar kendaraan dengan tipe: " + tipe.toUpperCase());
        System.out.println("=======================================");

        while (current != null) {
            if (current.data.tipe.equals(tipe)) {
                current.data.tampilkanInformasi();
            }
            current = current.next;
        }

        if(tipe.equalsIgnoreCase("Sepeda Motor")){
            System.out.println("Total kendaraan dengan tipe " + tipe + ": " + motor);
        } else if(tipe.equalsIgnoreCase("Mobil")){
            System.out.println("Total kendaraan dengan tipe " + tipe + ": " + mobil);
        } else{
            System.out.println("Data Kendaraan Tidak Tersedia");
        }
    }
}
