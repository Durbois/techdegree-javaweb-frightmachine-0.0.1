package com.teamtreehouse.techdegree.hardware;

import com.example.accessory.Accessory;

public class Camera implements Accessory {

    private int numberOfPhotos;

    public Camera() {
    }

    public void snapPhotos(int numberOfPhotos) {
        for (int i = 0; i < numberOfPhotos; i++) {
            System.out.println("SNAP:  Photo #" + (i + 1) + " taken");
        }
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public void setNumberOfPhotos(int numberOfPhotos) {
        this.numberOfPhotos = numberOfPhotos;
    }

    @Override
    public void activate() {
        snapPhotos(numberOfPhotos);
    }
}
