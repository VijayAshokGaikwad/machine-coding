package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}


/*
*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

            bufferedWriter.write(String.valueOf(n));
            bufferedWriter.newLine();


            List<Integer> l =  Stream.of(br.readLine().trim().split("\\s+")).map(Integer::parseInt).collect(toList());

            for (int i: l){
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
        *
* */