package com.simulaton;

public class Resources {
    private String resourceType ;
    private int resourceAmount ;

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getResourceAmount() {
        return resourceAmount;
    }

    public void setResourceAmount(int resourceAmount) {
        this.resourceAmount = resourceAmount;
    }

    public Resources(String resourceType, int resourceAmount) {
        this.resourceType = resourceType;
        this.resourceAmount = resourceAmount;
    }
}
