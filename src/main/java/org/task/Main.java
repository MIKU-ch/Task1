package org.task;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double num1 = 0, num2 = 0;
    char operator = ' ';
    boolean validInput = true;
    boolean validOperator = true;

    // ユーザーから1番目の数字を入力
    try {
      System.out.print("1番目の数字を入力してください: ");
      num1 = scanner.nextDouble();
    } catch (InputMismatchException e) {
      System.out.println("エラー: 数字を入力してください。");
      validInput = false;
    }

    if (validInput) {
      // 演算子を入力
      System.out.print("演算子を入力してください (+, -, *, /): ");
      operator = scanner.next().charAt(0);

      // 演算子の妥当性をチェック
      if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
        System.out.println("エラー: 無効な演算子です。");
        validOperator = false;
      }
    }

    if (validInput && validOperator) {
      // ユーザーから2番目の数字を入力
      try {
        System.out.print("2番目の数字を入力してください: ");
        num2 = scanner.nextDouble();
      } catch (InputMismatchException e) {
        System.out.println("エラー: 数字を入力してください。");
        validInput = false;
      }
    }

    double result = 0;

    if (validInput && validOperator) {
      // 演算子に応じて計算を実行
      switch (operator) {
        case '+':
          result = num1 + num2;
          break;
        case '-':
          result = num1 - num2;
          break;
        case '*':
          result = num1 * num2;
          break;
        case '/':
          if (num2 != 0) {
            result = num1 / num2;
          } else {
            System.out.println("エラー: 0で割ることはできません。");
            validOperator = false;
          }
          break;
      }

      // 結果を表示
      if (validOperator) {
        System.out.println("計算結果: " + num1 + " " + operator + " " + num2 + " = " + result);
      }
    }

    scanner.close();
  }
}
