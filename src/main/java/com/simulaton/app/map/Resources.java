package com.simulaton.app.map;


public class Resources {
    /**
     *
     */
    private String[] resourceType ={"wood", "stone", "iron", "food"};

    public String[] getResourceType() {
        return resourceType;
    }

    /**
     *
     * @param resourceType
     */
    public void setResourceType(String[] resourceType) {
        this.resourceType = resourceType;
    }

    private int resourceAmount ;

    public int getResourceAmount() {
        return resourceAmount;
    }

    /**
     *
     * @param resourceAmount
     * @return
     */

    public Resources setResourceAmount(int resourceAmount) {
        this.resourceAmount = resourceAmount;
        return null;
    }
}
