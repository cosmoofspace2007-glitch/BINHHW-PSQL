package Baiseasion12;

import Baiseasion11.Device;

public class NetworkDevice extends Asset
{

        private int numberOfPorts;

        public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
            super(assetCode, name, purchasePrice);
            this.numberOfPorts = numberOfPorts;
        }

        @Override
        public double getMarketValue() {
            return purchasePrice * 0.9;
        }

        @Override
        public String toString() {
            return "NetworkDevice | Code: " + assetCode +
                    " | Name: " + name +
                    " | Price: " + purchasePrice +
                    " | Ports: " + numberOfPorts +
                    " | Value: " + getMarketValue();
        }
}
