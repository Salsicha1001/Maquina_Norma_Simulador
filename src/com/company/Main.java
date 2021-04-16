package com.company;

import com.company.Model.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Component> componentList =new ArrayList<>();
    private static char operator;
    public static void main(String[] args) {
        leitura();

    }
    public static void somaComDoisRegistradores(){
        while(!VerifyZeroNeg(componentList.get(0).getResult().get(0))){
            Decrement(componentList.get(0));
            Decrement(componentList.get(1));
            if(VerifyZero(componentList.get((0)))){
                componentList.get(0).setResultNeg(0);
            }
        }
        while (!VerifyZero(componentList.get(1))){
            Increment(componentList.get(0));
            Decrement(componentList.get(1));
        }
        System.out.println("A soma entre A+B  resulta em  "+ componentList.get(0).getResult());
    }

        public static void SomaComTresRegistradores(){
        if(!VerifyZeroNeg(componentList.get(0).getResult().get(0))) {
            while (!VerifyZeroNeg(componentList.get(0).getResult().get(0))) {
                Decrement(componentList.get(0));
                Decrement(componentList.get(1));
                Increment(componentList.get(2));
                if (VerifyZero(componentList.get((0)))) {
                    componentList.get(0).setResultNeg(0);
                }
            }
            System.out.println("O Valor da soma entre A+B com auxilio do C = "+componentList.get(1).getResult());
        }
            if(VerifyZero(componentList.get(2))){
                while (!VerifyZero(componentList.get(1))){
                    Increment(componentList.get(0));
                    Increment(componentList.get(2));
                    Decrement(componentList.get(1));
                }
                while (!VerifyZero(componentList.get(2))){
                    Increment(componentList.get(1));
                    Decrement(componentList.get(2));
                }
                System.out.println("O Valor da soma entre A+B com auxilio do C = "+componentList.get(0).getResult());
            }

        }

        public static void Multiplicacao(){
            Component componentd = new Component();
            componentd.setName("D");
             boolean neg=false;
            boolean neg1=false;
            componentList.add(componentd);
            if(!VerifyZeroNeg(componentList.get(0).getResult().get(0))){
                neg = true;
                componentList.get(0).setResultNeg(0);
            }
            if(!VerifyZeroNeg(componentList.get(1).getResult().get(0))){
                neg1 = true;
                componentList.get(1).setResultNeg(0);
            }
            if(VerifyZero(componentList.get(3))){
                while (!VerifyZero(componentList.get(0))){
                    Increment(componentList.get(3));
                    Decrement(componentList.get(0));
                }
                while (!VerifyZero(componentList.get(3))) {
                    SomaComTresRegistradores();
                    Decrement(componentList.get(3));
                }
            }
    if(neg == true|| neg1 == true){
        componentList.get(0).setResultNeg(1);
    }  if(neg == true&& neg1 == true){
                componentList.get(0).setResultNeg(0);
            }

          System.out.println("O resultado da multiplicação é "+ componentList.get(0).getResult());

        }

    public static void subtracao(){
        if(operator =='-'){
            componentList.get(1).setResultNeg(1);
        }
        while(!VerifyZero(componentList.get(1))){
            Decrement(componentList.get(1));
            if(!VerifyZeroNeg(componentList.get(0).getResult().get(0))){
                Increment(componentList.get(0));
            }else{
                Decrement(componentList.get(0));
            }

        }
        System.out.println("O resultado entre A-B é "+componentList.get(0).getResult());
    }

    public static void leitura(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o Valor de A: ");
        int valueA = scanner.nextInt();
        System.out.println("Digite o operador: ");
        operator = scanner.next().charAt(0);
        System.out.println("Digite o Valor de B: ");
        int valueB = scanner.nextInt();
        SaveList(valueA,valueB);
    }

    private static void SaveList(int a, int b){
        Component component = new Component();
        component.setName("A");

        Component componentb = new Component();
        componentb.setName("B");
        Component componentc = new Component();
          componentc.setName("C");

        if(operator == '+'){
            Contador(component, a);
            Contador(componentb, b);
            componentList.add(component);
            componentList.add(componentb);
            componentList.add(componentc);
            somaComDoisRegistradores();
            //SomaComTresRegistradores();
        }else if(operator =='*'){
            Contador(component, a);
            Contador(componentb, b);
            componentList.add(component);
            componentList.add(componentb);
            componentList.add(componentc);
            Multiplicacao();
        }else if(operator =='-'){
            Contador(component, a);
            Contador(componentb, b);
            componentList.add(component);
            componentList.add(componentb);
            componentList.add(componentc);
            subtracao();
        }else{
            System.out.println("Digite as contas de Adição + ou subtração - ou multiplicação *");
            componentList.clear();
            leitura();
        }

    }
private static void Contador(Component c, int a){
        if(VerifyZero(c)){
            if(a<0){
                c.setResultNeg(1);
                a = a * -1;
            }
            while (c.getResult().get(1) !=a) {
                Increment(c);
            }
        }
        System.out.println("Finalizado a contagem de valores de "+ c.getName() + " com o valor de "+c.getResult());

}


    public static Component Increment(Component component){
        System.out.println("Valor de "+ component.getName()+ " era "+ component.getResult());
        component.setResultValue(component.getResult().get(1)+1);
        if(component.getResult().get(0)==1&& component.getResult().get(1)==0){
            component.setResultNeg(0);
        }

        System.out.println("Valor de "+ component.getName()+ " fica "+ component.getResult().get(1));
        System.out.println("=============================================================");
        return component;
    }
    public static Component Decrement(Component component){
        System.out.println("Valor de "+ component.getName()+ " era "+ component.getResult());
        System.out.println("=============================================================");
        if(!VerifyZero(component)){
            component.setResultValue(component.getResult().get(1) - 1);
            System.out.println("Valor de " + component.getName() + " fica " + component.getResult().get(1));
            System.out.println("=============================================================");
            return component;
        }else{
            component.setResultNeg(1);
            Increment(component);
        }
        return component;
    }
    public static boolean VerifyZero(Component component){
        if(component.getResult().get(1)==0){
            System.out.println( component.getName() + " é " +0);
            System.out.println("=============================================================");
            return true;
        }else{
            System.out.println(component.getName() + " não é 0");
            System.out.println("=============================================================");
            return false;
        }
    }
    public static boolean VerifyZeroNeg(Integer component){
        if(component==0){
            return true;
        }else{
            return false;
        }
    }
}
