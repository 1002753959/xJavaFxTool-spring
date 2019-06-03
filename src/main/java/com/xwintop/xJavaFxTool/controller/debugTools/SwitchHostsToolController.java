package com.xwintop.xJavaFxTool.controller.debugTools;

import com.xwintop.xJavaFxTool.services.debugTools.SwitchHostsToolService;
import com.xwintop.xJavaFxTool.view.debugTools.SwitchHostsToolView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Setter
@Slf4j
@Lazy
@FXMLController
public class SwitchHostsToolController extends SwitchHostsToolView {

    private SwitchHostsToolService switchHostsToolService = new SwitchHostsToolService(this);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            initView();
            initEvent();
            initService();
        } catch (Exception e) {
            log.error("初始化失败", e);
        }
    }

    private void initView() {
        TreeItem<String> treeItem = new TreeItem<String>("Hosts");
        treeItem.setExpanded(true);
        hostFileTreeView.setRoot(treeItem);
        TreeItem<String> commonHostTreeItem = new TreeItem<String>("公共Host");
        TreeItem<String> systemHostTreeItem = new TreeItem<String>("系统当前Host");
        TreeItem<String> localHostTreeItem = new TreeItem<String>("本地方案");
        localHostTreeItem.setExpanded(true);
        TreeItem<String> localHostTreeItem1 = new TreeItem<String>("方案一");
        TreeItem<String> localHostTreeItem2 = new TreeItem<String>("方案二");
        localHostTreeItem.getChildren().add(localHostTreeItem1);
        localHostTreeItem.getChildren().add(localHostTreeItem2);
        TreeItem<String> webTreeItem = new TreeItem<String>("在线方案");
        webTreeItem.setExpanded(true);
        treeItem.getChildren().add(commonHostTreeItem);
        treeItem.getChildren().add(systemHostTreeItem);
        treeItem.getChildren().add(localHostTreeItem);
        treeItem.getChildren().add(webTreeItem);
    }

    private void initEvent() {
    }

    private void initService() throws Exception {
        switchHostsToolService.reloadSystemHosts();
    }

    @FXML
    private void addAction(ActionEvent event) {
    }

    @FXML
    private void reloadAction(ActionEvent event) {
    }

    @FXML
    private void editAction(ActionEvent event) {
    }

    @FXML
    private void deleteAction(ActionEvent event) {
    }
}