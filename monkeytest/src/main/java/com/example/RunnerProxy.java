package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.aliyun.smoking.monkeyrunner.extend.ImageProcess;
import com.android.monkeyrunner.adb.AdbBackend;
import com.android.monkeyrunner.core.IMonkeyDevice;
import com.android.monkeyrunner.core.IMonkeyImage;
import com.android.monkeyrunner.core.TouchPressType;

public class RunnerProxy {
    private IMonkeyDevice device;
    private AdbBackend adb;
    private static RunnerProxy instance;

    public static RunnerProxy getInstance() {
        if (instance == null) {
            instance = new RunnerProxy();
        }
        return instance;
    }

    private RunnerProxy() {
        adb = new AdbBackend();
    }

    /**
     * this function will connect to a device, emulator or phone
     */
    public void connect() {
        assert (adb != null);
        device = adb.waitForConnection();
    }

    /**
     * this function clear device connect
     */
    public void dispose() {
        if (device != null) {
            device.dispose();
            device = null;
        }
    }

    private String imageDir;

    public void setImageDir(String imageDir) {
        this.imageDir = imageDir;
    }

    public String getImageDir() {
        return imageDir;
    }

    private String logDir;

    public void setLogDir(String logDir) {
        this.logDir = logDir;
    }

    public String getLogDir() {
        return logDir;
    }

    /**
     * this function finish touch operation
     *
     * @param x
     *            : x coordinate
     * @param y
     *            : y coordinate
     */
    public void touch(int x, int y) {
        assert (device != null);
        device.shell("sendevent /dev/input/event6 3 48 1");
        device.shell("sendevent /dev/input/event6 3 53 " + x);
        device.shell("sendevent /dev/input/event6 3 54 " + y);
        device.shell("sendevent /dev/input/event6 0 2 0");
        device.shell("sendevent /dev/input/event6 0 0 0");
        device.shell("sendevent /dev/input/event6 3 48 0");
        device.shell("sendevent /dev/input/event6 0 2 0");
        device.shell("sendevent /dev/input/event6 0 0 0");
    }

    /**
     * this function finish long touch operation
     *
     * @param x
     *            : x coordinate
     * @param y
     *            : y coordinate
     */
    public void longTouch(int x, int y) {
        assert (device != null);
        device.drag(x, y, x, y, 10, 2);
    }

    /**
     * this function finish drag from one point to another point
     *
     * @param x
     *            : x coordinate of start point
     * @param y
     *            : y coordinate of start point
     * @param endX
     *            : x coordinate of end point
     * @param endY
     *            : Y coordinate of end point
     *
     */
    public void drag(int x, int y, int endX, int endY) {
        assert (device != null);
        device.drag(x, y, endX, endY, 10, 2);
    }

    /**
     * this function finish type a text to view operation
     *
     * @param value
     *            : text to type in
     */
    public void type(String value) {
        assert (device != null);
        device.type(value);
    }

    /**
     * this function finish click a key operation
     *
     * @param keyCode
     *            : key code
     */
    public void press(String keyCode) {
        assert (device != null);
        device.press(keyCode, TouchPressType.DOWN_AND_UP);
    }

    /**
     * this function finish start an activity operation
     *
     * @param component
     *            : activity what to start
     */
    public void startActivity(String component) {
        assert (device != null);
        String action = "android.intent.action.MAIN";
        Collection<String> categories = new ArrayList<String>();
        categories.add("android.intent.category.LAUNCHER");
        device.startActivity(null, action, null, null, categories,
                new HashMap<String, Object>(), component, 0);
    }


}
