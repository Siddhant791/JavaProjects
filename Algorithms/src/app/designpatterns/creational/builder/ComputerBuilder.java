package com.siddhant.drive.designPattern.creational.builder;

import lombok.Getter;

public class ComputerBuilder {

    // Required attributes
    @Getter
    private String hdd;
    @Getter
    private String ram;

    //Optional attributes
    @Getter
    private boolean isGraphicCardEnabled = false;
    @Getter
    private boolean isBluetoothEnabled = false;
    @Getter
    private String os = "Windows";

    public ComputerBuilder(String hdd, String ram){
        this.hdd = hdd;
        this.ram = ram;
    }

    public ComputerBuilder setGraphicCardEnabled(boolean status){
        this.isGraphicCardEnabled = status;
        return this;
    }

    public ComputerBuilder setIsBluetoothEnabled(boolean status){
        this.isBluetoothEnabled = status;
        return this;
    }

    public ComputerBuilder setOs(String os){
        this.os = os;
        return this;
    }

    public Computer build(){
        return new Computer(this);
    }

}
