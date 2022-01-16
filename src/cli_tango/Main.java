package cli_tango;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		try {

			Scanner sc = new Scanner(System.in);
			File file = new File("data.txt");
			if(file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				
				System.out.println("昇順に学習する:1");
				System.out.println("降順に学習する:2");
				System.out.println("ランダムで学習する:3");
				System.out.println("終了する:99");
				int selector = sc.nextInt();
				System.out.println("");
				
				if(selector == 1) {
					//昇順に表示する場合
					String data;
					while((data = br.readLine()) != null) {
						String[] ary = data.split("　");
						System.out.println(">>>  " + ary[0]);
						
							
						String result = sc.nextLine();
						do {
							result = sc.nextLine();
						}while(result != "");
						System.out.println(">>>  " + ary[1]);
						System.out.println("---------------------------------------------");
					}
				}else if(selector == 2) {
					//降順に表示する場合
					String data;
					List<String> dataArray = new ArrayList<>();
					while((data = br.readLine()) != null) {
						dataArray.add(data);
					}
					for(int i = dataArray.size() - 1; i >= 0; i--) {
						String[] ary = dataArray.get(i).split("　");
						System.out.println(ary[0]);
						String event = sc.nextLine();
						do {
							event = sc.nextLine();
						}while(event != "");
						System.out.println(">>>  " + ary[1]);
						System.out.println("---------------------------------------------");
					}
				}else if(selector == 3) {
					//ランダムに表示する場合
					String data;
					List<String> dataArray = new ArrayList<>();
					while((data = br.readLine()) != null) {
						dataArray.add(data);
					}
					int[] targetArray = new int[dataArray.size()];
					for(int i = 0; i < dataArray.size(); i++) {
						targetArray[i] = i;
					}
					List<Integer> randomIndex= new ArrayList<>();
					for(int i = 0; i < dataArray.size(); i++) {
						randomIndex.add(i);
					}
					Collections.shuffle(randomIndex);
					
					if(randomIndex.size() != 0) {
						for(int i = 0; i < randomIndex.size(); i++) {
							String[] ary = dataArray.get(randomIndex.get(i)).split("　");
							System.out.println(">>>  " + ary[0]);
							String result = sc.nextLine();
							do {
								result = sc.nextLine();
							}while(result != "");
							System.out.println(">>>  " + ary[1]);
							System.out.println("---------------------------------------------");
						}
					}
				}
				
				
				System.out.println("終了しました");
				fr.close();
			}else {
				System.out.println("このアプリを使用するには");
				System.out.println("１.data.txtを作成し、アプリケーションと同じディレクトリ内に配置します。");
				System.out.println("2.data.txtの中に、「表示したい単語＋全角スペース＋単語の説明￥ｎ」の形式で記述します");
				System.out.println("3.もう一度アプリを起動してください");
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
