package com.example.gospellremotestb;

public class RemoteCommandCode {
    public int frequency;
    public int[] codes;

    public RemoteCommandCode(int numberOfCodes) {
        codes = new int[numberOfCodes];
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int[] getCodes() {
        return codes;
    }

    public void setCodes(int[] codes) {
        this.codes = codes;
    }

    public void setCode(int i, int code){
        codes[i] = code;
    }
}
