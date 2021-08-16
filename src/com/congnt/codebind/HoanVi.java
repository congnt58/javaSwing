package com.congnt.codebind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HoanVi {
    private int i, n, a[];
    private String mangKyTu[];
    private List<String> listString;
    StringBuilder stringB;
    Random r = new Random();

    public HoanVi(String t) {
        listString = new ArrayList<>();
        mangKyTu = t.trim().split(",");
        //n la so phan tu can hoan vi
        String a1 = mangKyTu[0].trim();
        stringB = new StringBuilder();

        for (int j = 0; j < 50 - (mangKyTu.length - 1); j++) {
            StringBuilder stringBuilder = new StringBuilder(a1 + " ");
            while (stringBuilder.length() < (254 - (a1 + " ").length())) {
                stringBuilder.append(a1 + " ");
            }

            char c = (char) (r.nextInt(26) + 'a');
            stringBuilder.append(c);
            stringBuilder.append(r.nextInt(9));


            stringB.append( stringBuilder + ",");
        }
        stringB.append(mangKyTu[1]);
        for (int k = 2; k < mangKyTu.length; k++) {
            stringB.append(", " + mangKyTu[k].trim());
        }

        System.out.println(stringB.toString());

        //this.n = mangKyTu.length;
        //Init();
        //sinhHoanVi();
    }

    public String getStringResult() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String t : listString) {
//            stringBuilder.append(t + "\n");
//        }
        return stringB.toString();
    }

    public ArrayList<String> getListResult() {
        return (ArrayList<String>) listString;
    }

    //Khởi tạo mang hoan vi
    public void Init() {
        a = new int[n];
        for (int j = 0; j < n; j++) {
            a[j] = j;
        }
    }

    //Hiển thị kết quả
    public void Result() {
        StringBuilder temp = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (j != n - 1) {
                temp.append(mangKyTu[a[j]].trim() + " ");
            } else {
                temp.append(mangKyTu[a[j]].trim());
            }
        }
        listString.add(temp.toString());
    }

    //Sinh hoán vị
    public void sinhHoanVi() {
        do {
            Result();
            i = n - 2;
            while (i >= 0 && a[i] > a[i + 1]) --i;
            if (i >= 0) {
                int k = n - 1;
                while (a[k] < a[i]) --k; //lùi dần từ cuối dãy để tìm phân tử đầu tiên lớn hơn x[i]
                //đổi chỗ sau khi tìm thấy
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
                //Lật ngược đoạn cuối cùng
                k = n - 1;
                for (int j = i + 1; j < k; j++, k--) {
                    temp = a[j];
                    a[j] = a[k];
                    a[k] = temp;
                }
            }
        } while (i != -1);
    }

}
