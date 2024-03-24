package com.siddhant.drive.designPattern.creational.builder;

import lombok.Data;

@Data
public class Computer {

    // Required attributes
    private String hdd;
    private String ram;

    //Optional attributes
    private boolean isGraphicCardEnabled;
    private boolean isBluetoothEnabled;
    private String os;

    public Computer(ComputerBuilder builder){
        this.hdd = builder.getHdd();
        this.ram = builder.getRam();
        this.isGraphicCardEnabled = builder.isGraphicCardEnabled();
        this.isBluetoothEnabled = builder.isBluetoothEnabled();
        this.os = builder.getOs();
    }

}
