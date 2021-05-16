package codesjava;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Network {

    private List<Synapse> synapseList = new ArrayList<>();
    private List<Level> levelList = new ArrayList<>();

    public void addRandomWeightForSynapse() {
        Random r = new Random();
        for (int i = 0; i < levelList.get(0).getNeuronList().size(); i++) {
            for (int j = 0; j < levelList.get(1).getNeuronList().size(); j++) {
                Synapse synapse = new Synapse();
                synapse.setInputNeron(levelList.get(0).getNeuronList().get(i));
                synapse.setOutputNeuron(levelList.get(1).getNeuronList().get(j));
                synapse.setSynapseWeight((r.nextDouble() - 0.5));
                synapseList.add(synapse);
            }
        }
        for (int i = 0; i < levelList.get(1).getNeuronList().size(); i++) {
            for (int j = 0; j < levelList.get(2).getNeuronList().size(); j++) {
                Synapse synapse = new Synapse();
                synapse.setInputNeron(levelList.get(1).getNeuronList().get(i));
                synapse.setOutputNeuron(levelList.get(2).getNeuronList().get(j));
                synapse.setSynapseWeight((r.nextDouble() - 0.5));
                synapseList.add(synapse);
            }
        }
        for (int i = 0; i < levelList.get(2).getNeuronList().size(); i++) {
            for (int j = 0; j < levelList.get(3).getNeuronList().size(); j++) {
                Synapse synapse = new Synapse();
                synapse.setInputNeron(levelList.get(2).getNeuronList().get(i));
                synapse.setOutputNeuron(levelList.get(3).getNeuronList().get(j));
                synapse.setSynapseWeight((r.nextDouble() - 0.5));
                synapseList.add(synapse);
            }
        }
        for (int i = 0; i < levelList.get(3).getNeuronList().size(); i++) {
            for (int j = 0; j < levelList.get(4).getNeuronList().size(); j++) {
                Synapse synapse = new Synapse();
                synapse.setInputNeron(levelList.get(3).getNeuronList().get(i));
                synapse.setOutputNeuron(levelList.get(4).getNeuronList().get(j));
                synapse.setSynapseWeight((r.nextDouble() - 0.5));
                synapseList.add(synapse);
            }
        }
    }

    public void backPropagation() {
        this.nullifySum();
        for (int i = 0; i < levelList.get(4).getNeuronList().size(); i++) {
            Neuron neuron = levelList.get(4).getNeuronList().get(i);
            Neuron neuronWithCorrectValue = levelList.get(0).getNeuronList().get(i);
            neuron.setMistakeValue(neuronWithCorrectValue.getFunctionValue() - neuron.getFunctionValue());
        }

        for (int i = 0; i < levelList.get(3).getNeuronList().size(); i++) {
            Neuron neuron = levelList.get(3).getNeuronList().get(i);
            Double mistakeValue = 0.0;
            for (int j = 0; j < levelList.get(4).getNeuronList().size(); j++) {
                Neuron neuronOutput = levelList.get(4).getNeuronList().get(j);
                Synapse synapse = findSynapse(neuron, neuronOutput);
                mistakeValue = mistakeValue + synapse.getSynapseWeight() * neuronOutput.getMistakeValue();
            }
            neuron.setMistakeValue(mistakeValue);
        }
        for (int i = 0; i < levelList.get(2).getNeuronList().size(); i++) {
            Neuron neuron = levelList.get(2).getNeuronList().get(i);
            Double mistakeValue = 0.0;
            for (int j = 0; j < levelList.get(3).getNeuronList().size(); j++) {
                Neuron neuronOutput = levelList.get(3).getNeuronList().get(j);
                Synapse synapse = findSynapse(neuron, neuronOutput);
                mistakeValue = mistakeValue + synapse.getSynapseWeight() * neuronOutput.getMistakeValue();
            }
            neuron.setMistakeValue(mistakeValue);
        }
        for (int i = 0; i < levelList.get(1).getNeuronList().size(); i++) {
            Neuron neuron = levelList.get(1).getNeuronList().get(i);
            Double mistakeValue = 0.0;
            for (int j = 0; j < levelList.get(2).getNeuronList().size(); j++) {
                Neuron neuronOutput = levelList.get(2).getNeuronList().get(j);
                Synapse synapse = findSynapse(neuron, neuronOutput);
                mistakeValue = mistakeValue + synapse.getSynapseWeight() * neuronOutput.getMistakeValue();
            }
            neuron.setMistakeValue(mistakeValue);
        }

        for (int i = 0; i < levelList.get(0).getNeuronList().size(); i++){
            Neuron neuron = levelList.get(0).getNeuronList().get(i);
            for (int j = 0; j < levelList.get(1).getNeuronList().size(); j++){
                Neuron neuronOutput = levelList.get(1).getNeuronList().get(j);
                Synapse synapse = findSynapse(neuron, neuronOutput);
                Double newValue = synapse.getSynapseWeight() +0.1 *neuronOutput.getMistakeValue() * neuronOutput.getFunctionValue() * (1 - neuronOutput.getFunctionValue()) * neuron.getFunctionValue();
                synapse.setSynapseWeight(newValue);
            }
        }
        for (int i = 0; i < levelList.get(1).getNeuronList().size(); i++){
            Neuron neuron = levelList.get(1).getNeuronList().get(i);
            for (int j = 0; j < levelList.get(2).getNeuronList().size(); j++){
                Neuron neuronOutput = levelList.get(2).getNeuronList().get(j);
                Synapse synapse = findSynapse(neuron, neuronOutput);
                Double newValue = synapse.getSynapseWeight() +0.1 *neuronOutput.getMistakeValue() * neuronOutput.getFunctionValue() * (1 - neuronOutput.getFunctionValue()) * neuron.getFunctionValue();
                synapse.setSynapseWeight(newValue);
            }
        }
        for (int i = 0; i < levelList.get(2).getNeuronList().size(); i++){
            Neuron neuron = levelList.get(2).getNeuronList().get(i);
            for (int j = 0; j < levelList.get(3).getNeuronList().size(); j++){
                Neuron neuronOutput = levelList.get(3).getNeuronList().get(j);
                Synapse synapse = findSynapse(neuron, neuronOutput);
                Double newValue = synapse.getSynapseWeight() +0.1 *neuronOutput.getMistakeValue() * neuronOutput.getFunctionValue() * (1 - neuronOutput.getFunctionValue()) * neuron.getFunctionValue();
                synapse.setSynapseWeight(newValue);
            }
        }
        for (int i = 0; i < levelList.get(3).getNeuronList().size(); i++){
            Neuron neuron = levelList.get(3).getNeuronList().get(i);
            for (int j = 0; j < levelList.get(4).getNeuronList().size(); j++){
                Neuron neuronOutput = levelList.get(4).getNeuronList().get(j);
                Synapse synapse = findSynapse(neuron, neuronOutput);
                Double newValue = synapse.getSynapseWeight() +0.1 *neuronOutput.getMistakeValue() * neuronOutput.getFunctionValue() * (1 - neuronOutput.getFunctionValue()) * neuron.getFunctionValue();
                synapse.setSynapseWeight(newValue);
            }
        }
    }

    public void sumValue() {
        for (int i = 0; i < synapseList.size(); i++) {
            Neuron nInput = synapseList.get(i).getInputNeron();
            Neuron nOutput = synapseList.get(i).getOutputNeuron();
            nOutput.sumSynapseWeightFunction(nInput.getFunctionValue() * synapseList.get(i).getSynapseWeight());
        }
    }

    public Synapse findSynapse(Neuron nInput, Neuron nOutput) {
        for (int i = 0; i < synapseList.size(); i++) {
            if (synapseList.get(i).getInputNeron().equals(nInput) && synapseList.get(i).getOutputNeuron().equals(nOutput))
                return synapseList.get(i);
        }
        return null;
    }

    public void nullifySum() {
        for (int i = 0; i < levelList.size(); i++) {
            for (int j = 0; j < levelList.get(i).getNeuronList().size(); j++) {
                levelList.get(i).getNeuronList().get(j).setSumSynapseWeight(0.0);
            }
        }
    }

}
