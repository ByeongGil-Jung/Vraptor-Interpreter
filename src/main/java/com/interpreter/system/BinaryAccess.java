package com.interpreter.system;

import com.interpreter.Configuration;
import com.interpreter.dto.AllSensorData;
import com.interpreter.dto.chassis.ChassisData;
import com.interpreter.dto.chassis.FanData;
import com.interpreter.dto.node.NodeData;
import com.interpreter.dto.node.ServerData;

import java.util.ArrayList;

public class BinaryAccess extends AccessObject implements Accessable {

    private static BinaryAccess instance;
    private Configuration configuration = Configuration.getInstance();

    public static BinaryAccess getInstance() {
        if (instance == null) {
            instance = new BinaryAccess();
        }

        return instance;
    }

    private BinaryAccess() { }

    /**
     * @param fanAutoSwitch
     * @param defaultTemperature
     */
    public boolean setFanMode(boolean fanAutoSwitch, int defaultTemperature) {
        if (fanAutoSwitch) {
            /**
             * @TODO
             * Set fan auto switch to True
             * Set defaultTemperature
             */
            return true;  // Remove this
        } else {
            /**
             * @TODO
             * Set fan auto switch to False
             */
            return true;  // Remove this
        }
        // return true;
    }

    public boolean setFanSpeed(int fanNumber, int speed) {
        return true;
    }

    /**
     * @param nodeNumber
     * @param powerStatus (0 : Reset, 1 : Off)
     */
    public boolean setPowerStatus(int nodeNumber, int powerStatus) {
        boolean resultStatus = false;

        // Reset
        if (powerStatus == 0) {
            /**
             * @TODO
             * Reset
             */
            resultStatus = true;
        // Off
        } else if (powerStatus == 1) {
            /**
             * @TODO
             * Off Power
             */
            resultStatus = true;
        }

        return resultStatus;
    }

    public AllSensorData getAllSensorData() {
        /**
         * @TODO
         * Should get system data
         * These are dummy data
         */
        return new AllSensorData.AllSensorDataBuilder()
                .setChassisData(getChassisData())
                .setServerData(getServerData())
                .build();
    }

    public ChassisData getChassisData() {
        /**
         * @TODO
         * Should get system data
         * These are dummy data
         */
        return new ChassisData.ChassisDataBuilder()
                .setTemperature(30)
                .setFanDataList(getAllFanData())
                .setFanAutoSwitch(true)
                .build();
    }

    public FanData getFanData(int fanNumber) {
        /**
         * @TODO
         * Should get system data
         * These are dummy data
         */
        return new FanData.FanDataBuilder()
                .setFanNumber(fanNumber)
                .setSpeed(200)
                .build();
    }

    public ArrayList<FanData> getAllFanData() {
        int fanNumber = Integer.parseInt(configuration.getProperty("fan_number"));
        ArrayList<FanData> fanDataList = new ArrayList<>();

        for (int i = 0; i < fanNumber; i++) {
            fanDataList.add(getFanData(i));
        }

        return fanDataList;
    }

    public ServerData getServerData() {
        /**
         * @TODO
         * Should get system data
         * These are dummy data
         */
        return new ServerData.ServerDataBuilder()
                .setNodeDataList(getAllNodeData())
                .build();
    }

    public NodeData getNodeData(int nodeNumber) {
        /**
         * @TODO
         * Should get system data
         */
        return new NodeData.NodeDataBuilder()
                .setNodeNumber(nodeNumber)
                .setPowerStatus(true)
                .build();
    }

    public ArrayList<NodeData> getAllNodeData() {
        int nodeNumber = Integer.parseInt(configuration.getProperty("node_number"));
        ArrayList<NodeData> nodeDataList = new ArrayList<>();

        for (int i = 0; i < nodeNumber; i++) {
            nodeDataList.add(getNodeData(i));
        }

        return nodeDataList;
    }
}
