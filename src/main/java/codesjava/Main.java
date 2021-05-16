package codesjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Network network = new Network();

        Level level1 = new Level();
        List<Neuron> list1 = new ArrayList<>();
        level1.setNeuronList(list1);
        network.getLevelList().add(level1);
        for (int i = 0; i < 5; i++) {
            list1.add(new Neuron("Level1; " + i));
        }
        level1.getNeuronList().get(0).setFunctionValue(0.980);
        level1.getNeuronList().get(1).setFunctionValue(0.977);
        level1.getNeuronList().get(2).setFunctionValue(0.941);
        level1.getNeuronList().get(3).setFunctionValue(0.090);
        level1.getNeuronList().get(4).setFunctionValue(0.1);

        Level level2 = new Level();
        List<Neuron> list2 = new ArrayList<>();
        level2.setNeuronList(list2);
        network.getLevelList().add(level2);
        for (int i = 0; i < 4; i++) {
            list2.add(new Neuron("Level2; " + i));
        }

        Level level3 = new Level();
        List<Neuron> list3 = new ArrayList<>();
        level3.setNeuronList(list3);
        network.getLevelList().add(level3);
        for (int i = 0; i < 2; i++) {
            list3.add(new Neuron("Level3; " + i));
        }

        Level level4 = new Level();
        List<Neuron> list4 = new ArrayList<>();
        level4.setNeuronList(list4);
        network.getLevelList().add(level4);
        for (int i = 0; i < 4; i++) {
            list4.add(new Neuron("Level4; " + i));
        }

        Level level5 = new Level();
        List<Neuron> list5 = new ArrayList<>();
        level5.setNeuronList(list5);
        network.getLevelList().add(level5);
        for (int i = 0; i < 5; i++) {
            list5.add(new Neuron("Level5; " + i));
        }
        network.addRandomWeightForSynapse();
        network.sumValue();
        network.backPropagation();
        for (int i = 0; i < network.getLevelList().size(); i++){
            System.out.println(network.getLevelList().get(i));
        }
        for (int i = 0; i < network.getSynapseList().size(); i++){
            System.out.println(network.getSynapseList().get(i));
        }

        for (int i = 0; i < 10000; i++) {
            level1.getNeuronList().get(0).setFunctionValue(0.980);
            level1.getNeuronList().get(1).setFunctionValue(0.977);
            level1.getNeuronList().get(2).setFunctionValue(0.941);
            level1.getNeuronList().get(3).setFunctionValue(0.090);
            level1.getNeuronList().get(4).setFunctionValue(0.0);
            network.sumValue();
            network.backPropagation();

            level1.getNeuronList().get(0).setFunctionValue(0.05);
            level1.getNeuronList().get(1).setFunctionValue(0.02);
            level1.getNeuronList().get(2).setFunctionValue(0.058);
            level1.getNeuronList().get(3).setFunctionValue(0.93);
            level1.getNeuronList().get(4).setFunctionValue(1.0);
            network.sumValue();
            network.backPropagation();

            level1.getNeuronList().get(0).setFunctionValue(0.27);
            level1.getNeuronList().get(1).setFunctionValue(0.36);
            level1.getNeuronList().get(2).setFunctionValue(0.41);
            level1.getNeuronList().get(3).setFunctionValue(0.5);
            level1.getNeuronList().get(4).setFunctionValue(1.0);
            network.sumValue();
            network.backPropagation();
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Введите размых крыльев");
        Double value1 = (in.nextDouble() - 10) / (35.5 - 10);

        System.out.println("Введите макс. взлётную массу");
        Double value2 = (in.nextDouble() - 27) / (72 - 27);

        System.out.println("Введите максимальная грузоподъёмность");
        Double value3 = (in.nextDouble() - 3) / (20 - 3);

        System.out.println("Введите максимальная скорость");
        Double value4 = (in.nextDouble() - 800) / (2400 - 800);

        System.out.println("Имеется ли оружие");
        Double value5 = in.nextDouble();

        level1.getNeuronList().get(0).setFunctionValue(value1);
        level1.getNeuronList().get(1).setFunctionValue(value2);
        level1.getNeuronList().get(2).setFunctionValue(value3);
        level1.getNeuronList().get(3).setFunctionValue(value4);
        level1.getNeuronList().get(4).setFunctionValue(value5);
        network.sumValue();
        System.out.println(network.getLevelList().get(4).getNeuronList());
    }

}
