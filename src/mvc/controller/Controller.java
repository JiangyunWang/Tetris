package mvc.controller;

import mvc.model.*;
import mvc.view.GameFrame;
import mvc.view.LeftPanel;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Controller {
    private GameFrame gf;
    private LeftPanelModel lpm;
    private RightPanelModel rpm;
    private IShape nexShape;
    private int[][] map;

    public Controller() {
        this.rpm = new RightPanelModel();
        this.nexShape = rpm.getBlock();
        this.lpm = new LeftPanelModel(nexShape);
        this.map = lpm.getMap();
        this.gf = new GameFrame();
        gf.setBoard(map);
        gf.setBlock(lpm);

    }

    public void move() {

    }


}
