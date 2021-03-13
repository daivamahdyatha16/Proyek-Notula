package dicoding.belajarjava.Proyek;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class proyekNotula {
    public static void main(String[] args) throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        String pilihanUser;
        boolean lanjutkanProgram = true;



        while (lanjutkanProgram) {
            System.out.println("Database Notula\n");
            System.out.println("1.\t Lihat seluruh notula");
            System.out.println("2.\t Cari data notula");
            System.out.println("3.\t Tambah data notula");
            System.out.println("4.\t Edit data notula");
            System.out.println("5.\t Hapus data notula");

            System.out.print("\n\nPilihan data: ");
            pilihanUser = terminalInput.next();

            switch (pilihanUser) {
                case "1":
                    System.out.println("LIST SELURUH NOTULA");
                    tampilkanData();
                    break;
                case "2":
                    System.out.println("CARI NOTULA");
                    break;
                case "3":
                    System.out.println("TAMBAH NOTULA");
                    break;
                case "4":
                    System.out.println("EDIT NOTULA");
                    break;
                case "5":
                    System.out.println("HAPUS NOTULA");
                    break;
                default:
                    System.err.println("\nInput data anda tidak tersedia\nSilahkan input [1-5]");
            }

            lanjutkanProgram = getYesorNo("Apakah anda ingin melanjutkan");
        }
        clearScreen();
    }

        private static void tampilkanData() throws IOException{

            FileReader fileInput;
            BufferedReader bufferedInput;

            try{
                fileInput = new FileReader("databaseNotula.txt");
                bufferedInput = new BufferedReader(fileInput);
            }catch (Exception e){
                System.err.println("Database Tidak Ditemukan");
                System.err.println("Silahkan Tambah Database Terlebih dahulu");
                return;
            }

            System.out.println("\n| No |\tTanggal |\tDirektorat yang menyelenggarakan        |\tRapat               |");
            System.out.println("----------------------------------------------------------------------------------------------------------");

            String data = bufferedInput.readLine();
            int nomorData = 0;
            while(data != null){
                nomorData++;

                StringTokenizer stringToken = new StringTokenizer(data, ",");

                stringToken.nextToken();
                System.out.printf("| %2d ", nomorData);
                System.out.printf("| %4s   ", stringToken.nextToken());
                System.out.printf("|\t%-20s   ", stringToken.nextToken());
                System.out.printf("|\t%-20s   ", stringToken.nextToken());
                System.out.print("\n");

                data = bufferedInput.readLine();
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");

    }

        private static boolean getYesorNo (String message){
            Scanner terminalInput = new Scanner(System.in);
            System.out.print("\n"+message+"(ya/tidak)?");
            String pilihanUser = terminalInput.next();

            while(!pilihanUser.equalsIgnoreCase("ya")&& !pilihanUser.equalsIgnoreCase("tidak")){
                System.err.println("Pilihan anda bukan ya atau tidak");
                System.out.print("\n"+message+"(ya/tidak)?");
                pilihanUser = terminalInput.next();
            }

            return pilihanUser.equalsIgnoreCase("ya");

    }

        private static void clearScreen(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033\143");
            }
        }catch (Exception e){
            System.err.println("Tidak bisa clearscreen");
        }
        }
}
