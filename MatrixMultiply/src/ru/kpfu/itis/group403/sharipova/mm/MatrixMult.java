package ru.kpfu.itis.group403.sharipova.mm;

import java.util.Random;
import java.util.Scanner;

public class MatrixMult {
	private int N;
	private Random random = new Random();
	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] matrix3;
	private Thread[] threads;
	public MatrixMult(int n) {
		N = n;

		matrix3 = new int[N][N];
		matrix1=new int[N][N];
		matrix2=new int[N][N];
		//		threads = new Thread[m];

		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				matrix1[i][j]=random.nextInt(10);
				matrix2[i][j]=random.nextInt(10);
			}
		}
	}

	public void restart() {
		matrix3=new int[N][N];
	}
	public void multiply(int m) {
		threads = new Thread[m];
		int k=0;

		for (int i = 0; i < m-1; i++) {
			threads[i]=new Thread(new Strings(k, k+N/m));
			threads[i].start();
			k+=N/m;
		}
		threads[m-1]=new Thread(new Strings(k, k+N/m+N%m));
		threads[m-1].start();
		for (int j = 0; j < threads.length; j++) {
			try {
				threads[j].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private class Strings implements Runnable{
		int b, e;
		public Strings(int b, int e) {
			this.b=b;
			this.e=e;
		}
		@Override
		public void run() {
			for (int i = b; i <e; i++) {
				for (int j = 0; j < N; j++) {
					for (int j2 = 0; j2 < matrix1.length; j2++) {
						matrix3[i][j] += matrix1[i][j2] * matrix2[j2][j]; 
					}

				}
			}

		}

	}
	public String toString() {
		for (int[] is : matrix1) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println();
		for (int[] is : matrix2) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println();
		for (int[] is : matrix3) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Введите размерность матриц");
		int N=sc.nextInt();

		MatrixMult matrixMultiply=new MatrixMult(N);
		for (int i = 1; i <= 10; i++) {

			System.out.println("Число потоков: " + i);

			long start = System.currentTimeMillis();
			matrixMultiply.multiply(i);
			System.out.println(System.currentTimeMillis() - start + " ms");
			matrixMultiply.restart();

		}
		System.out.println("Число потоков: " + 100);

		long start = System.currentTimeMillis();
		matrixMultiply.multiply(100);
		System.out.println(System.currentTimeMillis() - start + " ms");

	}

}
